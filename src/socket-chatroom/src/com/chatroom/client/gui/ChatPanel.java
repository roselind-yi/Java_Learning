package com.chatroom.client.gui;

import com.chatroom.common.Constants;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.text.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.PrintWriter;

/**
 * 聊天面板 - 现代化气泡风格消息 + 圆角输入区域
 */
public class ChatPanel extends JPanel implements MessageCallback {

    private final JTextPane messageArea;
    private JTextField inputField;
    private JButton sendButton;
    private final PrintWriter writer;
    private final String nickname;

    // 消息样式
    private final SimpleAttributeSet systemStyle;
    private final SimpleAttributeSet selfStyle;
    private final SimpleAttributeSet otherStyle;

    public ChatPanel(String nickname, PrintWriter writer) {
        this.nickname = nickname;
        this.writer = writer;

        setLayout(new BorderLayout());
        setOpaque(false);

        // 定义消息样式
        systemStyle = new SimpleAttributeSet();
        StyleConstants.setForeground(systemStyle, new Color(130, 135, 150));
        StyleConstants.setFontFamily(systemStyle, "Microsoft YaHei");
        StyleConstants.setFontSize(systemStyle, 12);
        StyleConstants.setItalic(systemStyle, true);
        StyleConstants.setAlignment(systemStyle, StyleConstants.ALIGN_CENTER);

        selfStyle = new SimpleAttributeSet();
        StyleConstants.setForeground(selfStyle, new Color(55, 95, 210));
        StyleConstants.setFontFamily(selfStyle, "Microsoft YaHei");
        StyleConstants.setFontSize(selfStyle, 14);

        otherStyle = new SimpleAttributeSet();
        StyleConstants.setForeground(otherStyle, new Color(40, 44, 52));
        StyleConstants.setFontFamily(otherStyle, "Microsoft YaHei");
        StyleConstants.setFontSize(otherStyle, 14);

        // ===== 消息展示区 =====
        messageArea = createMessageArea();

        JScrollPane scrollPane = new JScrollPane(messageArea);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 4));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        add(scrollPane, BorderLayout.CENTER);

        // ===== 底部输入面板（磨砂玻璃效果）=====
        JPanel bottomPanel = createInputPanel();
        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * 创建消息显示区
     */
    private JTextPane createMessageArea() {
        JTextPane pane = new JTextPane() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(new Color(250, 251, 253));
                int arc = 12;
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);
                g2d.dispose();
                super.paintComponent(g);
            }
        };
        pane.setEditable(false);
        pane.setBackground(new Color(0, 0, 0, 0)); // 透明
        pane.setMargin(new Insets(14, 16, 14, 16));
        return pane;
    }

    /**
     * 创建底部输入面板
     */
    private JPanel createInputPanel() {
        JPanel bottom = new JPanel(new BorderLayout(6, 6)) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(new Color(255, 255, 255, 220));
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
                // 顶部分隔线
                g2d.setColor(new Color(220, 225, 232));
                g2d.drawLine(8, 0, getWidth() - 8, 0);
                g2d.dispose();
                super.paintComponent(g);
            }
        };
        bottom.setOpaque(false);
        bottom.setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));

        // 输入框
        inputField = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(hasFocus()
                        ? new Color(255, 255, 255)
                        : new Color(248, 250, 252));
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                if (hasFocus()) {
                    g2d.setColor(new Color(79, 120, 240));
                    g2d.setStroke(new BasicStroke(1.5f));
                    g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
                } else {
                    g2d.setColor(new Color(218, 222, 228));
                    g2d.setStroke(new BasicStroke(1f));
                    g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
                }
                g2d.dispose();
                super.paintComponent(g);
            }
        };
        inputField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
        inputField.setMargin(new Insets(8, 16, 8, 16));
        inputField.setCaretColor(new Color(79, 120, 240));
        inputField.setBorder(BorderFactory.createEmptyBorder(2, 4, 2, 4));
        inputField.addActionListener(e -> sendMessage());

        // placeholder
        inputField.setText(" 输入消息...");
        inputField.setForeground(new Color(175, 180, 190));
        inputField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (" 输入消息...".equals(inputField.getText())) {
                    inputField.setText("");
                    inputField.setForeground(new Color(40, 44, 52));
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (inputField.getText().isEmpty()) {
                    inputField.setText(" 输入消息...");
                    inputField.setForeground(new Color(175, 180, 190));
                }
            }
        });

        bottom.add(inputField, BorderLayout.CENTER);

        // 发送按钮
        sendButton = new JButton("发送") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0,
                        new Color(79, 120, 240), getWidth(), getHeight(),
                        new Color(66, 103, 225));
                g2d.setPaint(gp);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 18, 18);
                // 顶部微光
                g2d.setColor(new Color(255, 255, 255, 45));
                g2d.fillRoundRect(0, 0, getWidth(), getHeight() / 2, 18, 18);
                g2d.dispose();
                super.paintComponent(g);
            }
        };
        sendButton.setPreferredSize(new Dimension(64, 36));
        sendButton.setMaximumSize(new Dimension(64, 36));
        sendButton.setMinimumSize(new Dimension(64, 36));
        sendButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
        sendButton.setForeground(Color.WHITE);
        sendButton.setFocusPainted(false);
        sendButton.setContentAreaFilled(false);
        sendButton.setBorderPainted(false);
        sendButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sendButton.setToolTipText("发送消息 (Enter)");
        sendButton.addActionListener(e -> sendMessage());
        bottom.add(sendButton, BorderLayout.EAST);

        return bottom;
    }

    /**
     * 发送消息
     */
    private void sendMessage() {
        String text = inputField.getText().trim();
        if (text.isEmpty() || text.equals("输入消息...")) {
            return;
        }
        writer.println(text);
        inputField.setText("");

        if (Constants.CMD_QUIT.equals(text)) {
            return;
        }
        inputField.requestFocus();
    }

    // ==================== MessageCallback 实现 ====================

    @Override
    public void onMessage(String message) {
        SwingUtilities.invokeLater(() -> {
            try {
                StyledDocument doc = messageArea.getStyledDocument();
                if (message.startsWith("[" + nickname + "]")) {
                    doc.insertString(doc.getLength(), message + "\n", selfStyle);
                } else {
                    doc.insertString(doc.getLength(), message + "\n", otherStyle);
                }
                scrollToBottom();
            } catch (BadLocationException ignored) {
            }
        });
    }

    @Override
    public void onSystemMessage(String message) {
        SwingUtilities.invokeLater(() -> {
            try {
                StyledDocument doc = messageArea.getStyledDocument();
                // 系统消息居中显示
                StyleConstants.setAlignment(systemStyle, StyleConstants.ALIGN_CENTER);
                doc.insertString(doc.getLength(), message + "\n", systemStyle);
                scrollToBottom();
            } catch (BadLocationException ignored) {
            }
        });
    }

    @Override
    public void onUserListUpdate(String[] users) {
        // 由 ChatFrame 处理
    }

    @Override
    public void onDisconnected() {
        SwingUtilities.invokeLater(() -> {
            inputField.setEnabled(false);
            sendButton.setEnabled(false);
            try {
                StyledDocument doc = messageArea.getStyledDocument();
                doc.insertString(doc.getLength(),
                        "[系统] 与服务端的连接已断开。\n", systemStyle);
            } catch (BadLocationException ignored) {
            }
            scrollToBottom();
        });
    }

    private void scrollToBottom() {
        messageArea.setCaretPosition(messageArea.getDocument().getLength());
    }
}
