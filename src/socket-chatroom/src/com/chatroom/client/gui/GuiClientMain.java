package com.chatroom.client.gui;

import javax.swing.*;

/**
 * GUI 客户端入口 - 启动 macOS 风格登录窗口
 */
public class GuiClientMain {

    public static void main(String[] args) {
        // 使用跨平台 LookAndFeel 以确保自定义绘制生效
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        // 全局设置字体抗锯齿
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");

        SwingUtilities.invokeLater(() -> {
            JFrame loginFrame = new JFrame();
            loginFrame.setTitle("ChatRoom - 登录");
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrame.setSize(420, 560);
            loginFrame.setLocationRelativeTo(null);
            loginFrame.setResizable(false);

            LoginPanel loginPanel = new LoginPanel(loginFrame);
            loginFrame.add(loginPanel);
            loginFrame.setVisible(true);
        });
    }
}
