# GUI 客户端 — 开发计划

> 基于现有 CLI 客户端，使用 Java **AWT + Swing** 新增图形界面版客户端。
> **不修改服务端**，完全复用现有通信协议。

---

## 总体架构

```
com.chatroom.client
├── ClientMain.java          ← 现有 CLI 客户端（不改动）
├── MessageReceiver.java     ← 现有接收线程（不改动）
│
com.chatroom.client.gui      ← 新增包
├── GuiClientMain.java       ← GUI 客户端入口（登录窗口）
├── ChatFrame.java           ← 聊天主窗口
├── LoginPanel.java          ← 登录面板（昵称 + 服务器地址 + 连接按钮）
├── ChatPanel.java           ← 聊天面板（消息列表 + 输入框 + 发送按钮 + 在线用户列表）
└── GuiMessageReceiver.java  ← GUI 版消息接收器（消息回调到 Swing 组件）
```

**核心原则**：
- 网络层（Socket、IO 流）复用现有逻辑，与 CLI 客户端一致
- GUI 层使用 AWT/Swing 的 **事件分发线程（EDT）** 处理界面更新
- 接收线程通过 `SwingUtilities.invokeLater()` 安全更新 UI

---

## 开发步骤（按优先级排序）

### 步骤 G1 — 登录窗口：昵称输入 + 连接服务端

**目标**：用户打开程序看到一个登录窗口，输入昵称后点击连接，成功后关闭登录窗口并打开聊天窗口。

**实现方案**：

1. 创建 `GuiClientMain`，`main()` 中启动登录窗口
2. 创建 `LoginPanel`（`JPanel`），包含：
   - `JLabel`："昵称"
   - `JTextField`：昵称输入框
   - `JLabel`："服务器地址"
   - `JTextField`：默认填 `127.0.0.1:8888`
   - `JButton`："连接"
3. 点击连接按钮后：
   - 建立 `Socket` 连接
   - 发送昵称（首条消息，复用现有协议）
   - 启动接收线程
   - 关闭登录窗口 → 打开 `ChatFrame`
4. 连接失败时弹出 `JOptionPane` 错误提示

**涉及文件**：
- `src/com/chatroom/client/gui/GuiClientMain.java`
- `src/com/chatroom/client/gui/LoginPanel.java`

**验收标准**：
- 启动程序出现登录窗口
- 输入昵称点击连接，服务端日志显示 `xxx 已加入聊天室`
- 连接失败（服务端未启动）弹出错误提示

---

### 步骤 G2 — 聊天主窗口布局

**目标**：连接成功后打开一个结构清晰的聊天窗口。

**实现方案**：

1. 创建 `ChatFrame`（`JFrame`），标题显示昵称
2. 使用 `BorderLayout` 布局：
   - **右侧（EAST）**：在线用户列表面板（`JList` + `DefaultListModel`），宽约 150px
   - **中央（CENTER）**：`ChatPanel`
3. `ChatFrame` 关闭时触发断线逻辑（发送 `/quit` + 关闭 Socket）

**涉及文件**：
- `src/com/chatroom/client/gui/ChatFrame.java`

**验收标准**：
- 登录成功后出现聊天窗口，左侧聊天区 + 右侧在线用户列表
- 窗口标题显示当前用户昵称
- 关闭窗口时服务端显示离开通知

---

### 步骤 G3 — 消息接收与展示（核心）

**目标**：聊天区能实时显示服务端转发来的消息。

**实现方案**：

1. 创建 `GuiMessageReceiver`，实现 `Runnable`
   - 构造函数接收 `BufferedReader` + 回调接口 `MessageCallback`
2. 定义 `MessageCallback` 接口：
   ```java
   interface MessageCallback {
       void onMessage(String message);    // 普通消息
       void onSystemMessage(String msg);  // 系统消息（进出通知等）
       void onUserList(String[] users);   // 在线用户列表更新
       void onDisconnected();             // 连接断开
   }
   ```
3. `ChatPanel` 实现 `MessageCallback`
   - `onMessage()`：追加消息到 `JTextArea`（不可编辑，自动滚到底部）
   - `onSystemMessage()`：追加带颜色/样式的系统消息
   - 所有 UI 更新通过 `SwingUtilities.invokeLater()` 执行

**涉及文件**：
- `src/com/chatroom/client/gui/ChatPanel.java`
- `src/com/chatroom/client/gui/GuiMessageReceiver.java`

**验收标准**：
- 服务端发送消息后，GUI 聊天区实时显示
- 进入/离开通知正常显示
- 消息自动滚动到底部

---

### 步骤 G4 — 消息发送

**目标**：用户可在输入框输入消息，点击发送或按回车键发送。

**实现方案**：

1. `ChatPanel` 底部包含：
   - `JTextField`：消息输入框
   - `JButton`："发送"
2. 发送逻辑：
   - 点击发送按钮 → 获取输入框文本 → `writer.println(msg)` → 清空输入框
   - 回车键绑定：`inputField.addActionListener(e -> sendMessage())`
   - 空消息不发送
   - `/quit` 指令触发关闭窗口
3. 发送后清空输入框并保持焦点

**涉及文件**：
- `src/com/chatroom/client/gui/ChatPanel.java`

**验收标准**：
- 输入文字点击发送，另一个客户端能收到
- 按回车键也能发送
- 发送后输入框自动清空

---

### 步骤 G5 — 在线用户列表实时更新

**目标**：右侧面板实时显示当前在线用户。

**实现方案**：

1. `ChatFrame` 包含 `DefaultListModel<String>` + `JList`
2. `MessageCallback.onUserList(users)` 回调时：
   - 清空 model
   - 逐一添加用户
   - 通过 `SwingUtilities.invokeLater()` 更新
3. 解析服务端消息中的系统通知（`[系统] xxx 进入了聊天室` / `离开了聊天室`）来增量更新列表
4. 客户端首次连接时，自动发 `/who` 获取初始列表（可选）

**涉及文件**：
- `src/com/chatroom/client/gui/ChatFrame.java`

**验收标准**：
- 有用户进入/离开时，在线列表实时刷新
- 自己的昵称也显示在列表中

---

### 步骤 G6 — 界面美化

**目标**：让聊天界面看起来更现代、更美观。

**实现方案**：

1. **字体**：消息区使用等宽字体 `"Microsoft YaHei"` 14pt
2. **颜色区分**：
   - 系统消息：灰色
   - 自己发送的消息：蓝色
   - 他人消息：黑色
3. **滚动条**：`JTextArea` 放入 `JScrollPane`，始终显示滚动条
4. **间距**：各组件之间使用 `EmptyBorder` 留白
5. **窗口尺寸**：默认 800×600，最小 600×400
6. **窗口居中**：`setLocationRelativeTo(null)`

**涉及文件**：
- `src/com/chatroom/client/gui/ChatFrame.java`
- `src/com/chatroom/client/gui/ChatPanel.java`

**验收标准**：
- 窗口美观，字体清晰，消息颜色区分明显
- 窗口大小可调，布局自适应

---

## 依赖关系

```
G1(登录窗口) ──→ G2(主窗口布局) ──→ G3(消息接收) ──→ G4(消息发送)
                                        │                    │
                                        └──→ G5(在线列表) ←──┘
                                                  │
                                                  └──→ G6(美化)
```

> G3、G4、G5 可并行开发；G6 在所有功能完成后进行。

---

## 协议复用说明

GUI 客户端与 CLI 客户端使用**完全相同的通信协议**，无需修改服务端：

| 场景 | 客户端发送 | 服务端响应 |
|------|-----------|-----------|
| 登录 | 首行：昵称 | 广播 `[系统] 昵称 进入了聊天室` |
| 聊天 | 任意文本 | 广播 `[昵称]：消息内容` |
| 退出 | `/quit` | 广播 `[系统] 昵称 离开了聊天室` |
| 查在线 | `/who` | 回复 `[系统] 在线用户：xxx, yyy` |

---

## 新增文件清单

| 序号 | 文件路径 | 职责 |
|:---:|---|------|
| 1 | `gui/GuiClientMain.java` | GUI 客户端入口，启动登录窗口 |
| 2 | `gui/LoginPanel.java` | 登录面板（昵称、地址输入） |
| 3 | `gui/ChatFrame.java` | 聊天主窗口（含在线用户列表） |
| 4 | `gui/ChatPanel.java` | 聊天面板（消息展示 + 输入发送） |
| 5 | `gui/GuiMessageReceiver.java` | GUI 版消息接收器（回调模式） |
| 6 | `gui/MessageCallback.java` | 消息回调接口（内部接口或独立文件） |
