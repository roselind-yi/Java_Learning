package com.chatroom.client.gui;

import com.chatroom.common.Constants;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.*;
import java.net.Socket;

/**
 * 聊天主窗口 - macOS 风格，磨砂玻璃侧边栏 + 渐变动画背景
 */
public class ChatFrame extends JFrame {

    private final String nickname;
    private final ChatPanel chatPanel;
    private DefaultListModel<String> userListModel;
    private JList<String> userList;
    private final Socket socket;
    private final GuiMessageReceiver receiver;
    private final Thread receiverThread;
    private PrintWriter writer; // 保存writer引用用于关闭时发送退出指令

    // 渐变动画
    private float hueOffset = 0.0f;
    private Timer gradientTimer;

    public ChatFrame(String nickname, BufferedReader reader, PrintWriter writer, Socket socket) {
        this.nickname = nickname;
        this.socket = socket;
        this.writer = writer;

        setTitle("ChatRoom — " + nickname);
        setSize(900, 640);
        setMinimumSize(new Dimension(700, 480));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // ===== 主面板（渐变背景）=====
        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                paintGradientBackground((Graphics2D) g);
                super.paintComponent(g);
            }
        };
        mainPanel.setOpaque(false);
        setContentPane(mainPanel);

        // ===== 左侧聊天区域（磨砂玻璃卡片）=====
        chatPanel = new ChatPanel(nickname, writer);
        JPanel leftCard = wrapInGlassCard(chatPanel, BorderLayout.CENTER);
        mainPanel.add(leftCard, BorderLayout.CENTER);

        // ===== 右侧在线用户列表（磨砂玻璃侧边栏）=====
        JPanel rightPanel = createUserSidebar();
        mainPanel.add(rightPanel, BorderLayout.EAST);

        // 启动消息接收
        receiver = new GuiMessageReceiver(reader, new MessageCallback() {
            @Override
            public void onMessage(String message) {
                chatPanel.onMessage(message);
                updateUserListFromMessage(message);
            }

            @Override
            public void onSystemMessage(String message) {
                chatPanel.onSystemMessage(message);
                handleSystemMessage(message);
            }

            @Override
            public void onUserListUpdate(String[] users) {
                SwingUtilities.invokeLater(() -> {
                    userListModel.clear();
                    for (String user : users) {
                        userListModel.addElement(user);
                    }
                });
            }

            @Override
            public void onDisconnected() {
                chatPanel.onDisconnected();
                setTitle(getTitle() + " [已断开]");
            }
        });
        receiverThread = new Thread(receiver, "GUI-MessageReceiver");
        receiverThread.setDaemon(true);
        receiverThread.start();

        // 窗口关闭处理
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                cleanup();
            }
        });

        // 启动渐变动画
        startGradientAnimation();
    }

    /**
     * 将组件包裹在磨砂玻璃卡片中
     */
    private JPanel wrapInGlassCard(Component comp, Object constraints) {
        JPanel card = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(new Color(255, 255, 255, 230));
                int arc = 16;
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);
                // 微妙高光边框
                g2d.setColor(new Color(255, 255, 255, 80));
                g2d.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, arc - 2, arc - 2);
                g2d.dispose();
                super.paintComponent(g);
            }
        };
        card.setOpaque(false);
        card.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 8));
        card.add(comp, constraints);
        return card;
    }

    /**
     * 创建右侧用户列表面板
     */
    private JPanel createUserSidebar() {
        JPanel sidebar = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // 半透明侧边栏背景
                g2d.setColor(new Color(255, 255, 255, 180));
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 16, 16);
                g2d.dispose();
                super.paintComponent(g);
            }
        };
        sidebar.setOpaque(false);
        sidebar.setPreferredSize(new Dimension(180, 0));
        sidebar.setBorder(BorderFactory.createEmptyBorder(12, 4, 12, 12));

        // 标题
        JLabel titleLabel = new JLabel("在线成员", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
        titleLabel.setForeground(new Color(90, 100, 120));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(6, 0, 10, 0));
        sidebar.add(titleLabel, BorderLayout.NORTH);

        // 用户列表
        userListModel = new DefaultListModel<>();
        userList = new JList<>(userListModel);
        userList.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
        userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        userList.setFixedCellHeight(30);
        userList.setBackground(new Color(0, 0, 0, 0)); // 透明背景
        userList.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));

        JScrollPane listScrollPane = new JScrollPane(userList);
        listScrollPane.setOpaque(false);
        listScrollPane.getViewport().setOpaque(false);
        listScrollPane.setBorder(BorderFactory.createEmptyBorder());
        listScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        sidebar.add(listScrollPane, BorderLayout.CENTER);

        return sidebar;
    }

    /**
     * 绘制动态渐变背景
     */
    private void paintGradientBackground(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();

        float h1 = hueOffset;
        float h2 = (hueOffset + 0.18f) % 1.0f;
        float h3 = (hueOffset + 0.40f) % 1.0f;

        Color c1 = Color.getHSBColor(h1, 0.45f, 0.94f);
        Color c2 = Color.getHSBColor(h2, 0.38f, 0.89f);
        Color c3 = Color.getHSBColor(h3, 0.52f, 0.86f);

        GradientPaint grad1 = new GradientPaint(0, 0, c1, w, 0, c2);
        g2d.setPaint(grad1);
        g2d.fillRect(0, 0, w, h);

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        GradientPaint grad2 = new GradientPaint(0, 0, c2, 0, h, c3);
        g2d.setPaint(grad2);
        g2d.fillRect(0, 0, w, h);

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.15f));
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, w, h);
    }

    /**
     * 启动渐变动画
     */
    private void startGradientAnimation() {
        gradientTimer = new Timer(60, e -> {
            hueOffset += 0.002f;
            if (hueOffset > 1.0f) hueOffset -= 1.0f;
            repaint();
        });
        gradientTimer.start();
    }

    private void handleSystemMessage(String message) {
        SwingUtilities.invokeLater(() -> {
            String prefix = Constants.SYSTEM_SENDER + " ";
            if (message.startsWith(prefix)) {
                String content = message.substring(prefix.length());
                if (content.contains("进入了聊天室")) {
                    String user = content.replace(" 进入了聊天室", "").trim();
                    if (!userListModel.contains(user)) {
                        userListModel.addElement(user);
                    }
                } else if (content.contains("离开了聊天室")) {
                    String user = content.replace(" 离开了聊天室", "").trim();
                    userListModel.removeElement(user);
                }
            }
        });
    }

    private void updateUserListFromMessage(String message) {
        SwingUtilities.invokeLater(() -> {
            int idx = message.indexOf("]：");
            if (idx > 1) {
                String sender = message.substring(1, idx);
                if (!userListModel.contains(sender)) {
                    userListModel.addElement(sender);
                }
            }
        });
    }

    private void cleanup() {
        try {
            writer.println(Constants.CMD_QUIT);
            writer.flush();
        } catch (Exception ignored) {
        }
        receiver.stop();
        try {
            socket.close();
        } catch (IOException ignored) {
        }
        if (gradientTimer != null && gradientTimer.isRunning()) {
            gradientTimer.stop();
        }
    }

    @Override
    public void removeNotify() {
        super.removeNotify();
        if (gradientTimer != null && gradientTimer.isRunning()) {
            gradientTimer.stop();
        }
    }
}
