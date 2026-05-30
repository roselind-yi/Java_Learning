package com.chatroom.client.gui;

import com.chatroom.common.Constants;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.*;
import java.net.Socket;

/**
 * 登录面板 - macOS 风格磨砂玻璃效果 + 动态渐变背景
 */
public class LoginPanel extends JPanel {

    private final JTextField nicknameField;
    private final JTextField hostField;
    private final JTextField portField;
    private final JButton connectButton;
    private final JLabel statusLabel;
    private final JFrame parentFrame;

    // 渐变动画
    private float hueOffset = 0.0f;
    private Timer gradientTimer;

    // placeholder 文本
    private static final String NICK_PLACEHOLDER = "请输入您的昵称";
    private static final String HOST_PLACEHOLDER = "服务器地址";
    private static final String PORT_PLACEHOLDER = "端口号";

    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;
    private String nickname;

    public LoginPanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;

        setLayout(new BorderLayout());
        setOpaque(false); // 透明，让渐变背景透过来

        // ===== 中央磨砂玻璃卡片 =====
        JPanel glassCard = createGlassCard();

        // 标题图标 + 文字
        JPanel titlePanel = createTitlePanel();
        glassCard.add(titlePanel, BorderLayout.NORTH);

        // 表单区域
        JPanel formPanel = new JPanel();
        formPanel.setOpaque(false);
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(24, 36, 8, 36));

        // 昵称输入
        formPanel.add(createFormField("昵 称",
                nicknameField = createStyledField(NICK_PLACEHOLDER)));
        formPanel.add(Box.createVerticalStrut(16));

        // 服务器地址
        formPanel.add(createFormField("服务器地址",
                hostField = createStyledField(HOST_PLACEHOLDER, Constants.DEFAULT_HOST)));
        formPanel.add(Box.createVerticalStrut(16));

        // 端口
        formPanel.add(createFormField("端 口",
                portField = createStyledField(PORT_PLACEHOLDER, String.valueOf(Constants.DEFAULT_PORT))));
        formPanel.add(Box.createVerticalStrut(28));

        // 连接按钮
        connectButton = createConnectButton();
        connectButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(connectButton);

        // 状态标签
        statusLabel = new JLabel(" ", SwingConstants.CENTER);
        statusLabel.setForeground(new Color(140, 140, 160));
        statusLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        statusLabel.setBorder(BorderFactory.createEmptyBorder(12, 0, 4, 0));
        formPanel.add(statusLabel);

        glassCard.add(formPanel, BorderLayout.CENTER);
        add(glassCard, BorderLayout.CENTER);

        // 回车触发连接
        nicknameField.addActionListener(e -> connect());
        hostField.addActionListener(e -> connect());
        portField.addActionListener(e -> connect());

        // 启动渐变背景动画
        startGradientAnimation();

        SwingUtilities.invokeLater(() -> nicknameField.requestFocus());
    }

    /**
     * 创建磨砂玻璃卡片容器
     */
    private JPanel createGlassCard() {
        JPanel card = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // 半透明白色背景 - 模拟磨砂玻璃
                g2d.setColor(new Color(255, 255, 255, 200));
                int arc = 20;
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);
                // 微妙的内边框高光
                g2d.setColor(new Color(255, 255, 255, 100));
                g2d.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, arc - 2, arc - 2);
                g2d.dispose();
                super.paintComponent(g);
            }
        };
        card.setOpaque(false);
        card.setBorder(BorderFactory.createEmptyBorder(32, 32, 32, 32));
        return card;
    }

    /**
     * 创建标题区域
     */
    private JPanel createTitlePanel() {
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 6));
        titlePanel.setOpaque(false);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(12, 0, 4, 0));

        // 图标 (使用 Unicode 聊天气泡)
        JLabel iconLabel = new JLabel("\uD83D\uDCAC");
        iconLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 36));
        titlePanel.add(iconLabel);

        JLabel titleLabel = new JLabel("ChatRoom");
        titleLabel.setFont(new Font("SF Pro Display", Font.BOLD, 26));
        if (!isFontAvailable("SF Pro Display")) {
            titleLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 26));
        }
        titleLabel.setForeground(new Color(44, 62, 80));
        titlePanel.add(Box.createHorizontalStrut(8));
        titlePanel.add(titleLabel);

        return titlePanel;
    }

    /**
     * 创建带圆角和阴影的输入框
     */
    private JTextField createStyledField(String placeholder) {
        return createStyledField(placeholder, "");
    }

    private JTextField createStyledField(String placeholder, String defaultValue) {
        JTextField field = new JTextField(defaultValue) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // 圆角背景
                Color bgColor = hasFocus()
                        ? new Color(255, 255, 255)
                        : new Color(248, 250, 252);
                g2d.setColor(bgColor);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                g2d.dispose();
                super.paintComponent(g);
            }
        };
        field.setPreferredSize(new Dimension(280, 42));
        field.setMaximumSize(new Dimension(280, 42));
        field.setMinimumSize(new Dimension(280, 42));
        field.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(new Color(210, 215, 223), 1, 10),
                BorderFactory.createEmptyBorder(0, 14, 0, 14)
        ));
        field.setCaretColor(new Color(66, 133, 244));
        field.setAlignmentX(Component.LEFT_ALIGNMENT);

        // placeholder 效果
        if (defaultValue.isEmpty()) {
            field.setForeground(new Color(180, 185, 193));
            field.setText(placeholder);
        } else {
            field.setForeground(new Color(44, 62, 80));
        }
        final String phText = placeholder;

        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                field.setBorder(BorderFactory.createCompoundBorder(
                        new RoundedBorder(new Color(66, 133, 244), 1.5f, 10),
                        BorderFactory.createEmptyBorder(0, 14, 0, 14)
                ));
                if (field.getText().equals(phText) || field.getText().isEmpty()) {
                    field.setText("");
                    field.setForeground(new Color(44, 62, 80));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                field.setBorder(BorderFactory.createCompoundBorder(
                        new RoundedBorder(new Color(210, 215, 223), 1, 10),
                        BorderFactory.createEmptyBorder(0, 14, 0, 14)
                ));
                if (field.getText().isEmpty()) {
                    field.setText(phText);
                    field.setForeground(new Color(180, 185, 193));
                }
            }
        });

        return field;
    }

    /**
     * 创建表单行：标签 + 输入框
     */
    private Component createFormField(String labelText, JTextField field) {
        JPanel row = new JPanel();
        row.setOpaque(false);
        row.setLayout(new BoxLayout(row, BoxLayout.Y_AXIS));
        row.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
        label.setForeground(new Color(100, 110, 130));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setBorder(BorderFactory.createEmptyBorder(0, 2, 6, 0));
        row.add(label);

        row.add(field);
        return row;
    }

    /**
     * 创建现代化连接按钮
     */
    private JButton createConnectButton() {
        JButton btn = new JButton("进入聊天室") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // 渐变色按钮背景
                GradientPaint gp = new GradientPaint(0, 0,
                        new Color(79, 120, 240), getWidth(), getHeight(),
                        new Color(66, 103, 225));
                g2d.setPaint(gp);

                int w = getWidth(), h = getHeight();
                g2d.fillRoundRect(0, 0, w, h, 10, 10);

                // 顶部微光
                g2d.setColor(new Color(255, 255, 255, 40));
                g2d.fillRoundRect(0, 0, w, h / 2, 10, 10);
                g2d.dispose();

                super.paintComponent(g);
            }
        };

        btn.setPreferredSize(new Dimension(280, 44));
        btn.setMaximumSize(new Dimension(280, 44));
        btn.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // hover 效果
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                btn.setBackground(new Color(50, 80, 200));
            }
        });

        btn.addActionListener(e -> connect());
        return btn;
    }

    /**
     * 启动动态渐变背景动画
     */
    private void startGradientAnimation() {
        gradientTimer = new Timer(60, e -> {
            hueOffset += 0.002f;
            if (hueOffset > 1.0f) hueOffset -= 1.0f;
            repaint();
        });
        gradientTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth(), h = getHeight();

        // 动态渐变背景 - 模仿 macOS 风格
        float h1 = hueOffset;
        float h2 = (hueOffset + 0.15f) % 1.0f;
        float h3 = (hueOffset + 0.35f) % 1.0f;

        Color c1 = Color.getHSBColor(h1, 0.55f, 0.92f);   // 暖色
        Color c2 = Color.getHSBColor(h2, 0.45f, 0.88f);   // 中间色
        Color c3 = Color.getHSBColor(h3, 0.60f, 0.85f);   // 冷色

        GradientPaint grad1 = new GradientPaint(0, 0, c1, w, 0, c2);
        GradientPaint grad2 = new GradientPaint(0, 0, c2, 0, h, c3);

        // 填充基础渐变
        g2d.setPaint(grad1);
        g2d.fillRect(0, 0, w, h);

        // 叠加垂直方向渐变增加层次
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        g2d.setPaint(grad2);
        g2d.fillRect(0, 0, w, h);

        // 叠加一层半透明白色柔化整体
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.15f));
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, w, h);

        g2d.dispose();
        super.paintComponent(g);
    }

    private boolean isFontAvailable(String fontName) {
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String f : fonts) {
            if (f.equals(fontName)) return true;
        }
        return false;
    }

    private void connect() {
        String rawNick = nicknameField.getText().trim();
        if (rawNick.isEmpty() || rawNick.equals(NICK_PLACEHOLDER)) {
            showStatus("请输入昵称！", new Color(220, 70, 70));
            nicknameField.requestFocus();
            return;
        }
        nickname = rawNick;

        String host = hostField.getText().trim();
        if (host.isEmpty() || host.equals(HOST_PLACEHOLDER)) {
            host = Constants.DEFAULT_HOST;
        }
        String portStr = portField.getText().trim();
        if (portStr.isEmpty() || portStr.equals(PORT_PLACEHOLDER)) {
            portStr = String.valueOf(Constants.DEFAULT_PORT);
        }
        int port;
        try {
            port = Integer.parseInt(portStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "端口号格式错误！", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        connectButton.setEnabled(false);
        connectButton.setText("连接中...");
        showStatus("正在连接服务器...", new Color(79, 120, 240));

        final String finalHost = host;
        new Thread(() -> {
            try {
                socket = new Socket(finalHost, port);
                writer = new PrintWriter(
                        new OutputStreamWriter(socket.getOutputStream(), Constants.CHARSET), true);
                reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream(), Constants.CHARSET));

                writer.println(nickname);

                SwingUtilities.invokeLater(() -> {
                    ChatFrame chatFrame = new ChatFrame(nickname, reader, writer, socket);
                    chatFrame.setVisible(true);
                    parentFrame.dispose();
                });
            } catch (IOException ex) {
                SwingUtilities.invokeLater(() -> {
                    showStatus("连接失败: " + ex.getMessage(), new Color(220, 70, 70));
                    connectButton.setEnabled(true);
                    connectButton.setText("进入聊天室");
                    JOptionPane.showMessageDialog(this,
                            "无法连接到服务器：" + ex.getMessage(),
                            "连接失败", JOptionPane.ERROR_MESSAGE);
                });
            }
        }).start();
    }

    private void showStatus(String text, Color color) {
        statusLabel.setText(text);
        statusLabel.setForeground(color);
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public void removeNotify() {
        super.removeNotify();
        if (gradientTimer != null && gradientTimer.isRunning()) {
            gradientTimer.stop();
        }
    }

    // ==================== 圆角边框 ====================

    private static class RoundedBorder extends AbstractBorder {
        private final Color color;
        private final float thickness;
        private final int radius;

        RoundedBorder(Color color, float thickness, int radius) {
            this.color = color;
            this.thickness = thickness;
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(color);
            g2d.setStroke(new BasicStroke(thickness));
            g2d.draw(new RoundRectangle2D.Float(x, y, width - 1, height - 1, radius, radius));
            g2d.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets((int) thickness + 2, (int) thickness + 2, (int) thickness + 2, (int) thickness + 2);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.top = insets.right = insets.bottom = (int) thickness + 2;
            return insets;
        }
    }
}
