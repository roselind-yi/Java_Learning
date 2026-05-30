package com.chatroom.client.gui;

/**
 * 消息回调接口：GUI 组件实现此接口以接收来自接收线程的消息
 */
public interface MessageCallback {

    /**
     * 收到普通聊天消息
     */
    void onMessage(String message);

    /**
     * 收到系统消息（进入/离开通知等）
     */
    void onSystemMessage(String message);

    /**
     * 在线用户列表更新
     */
    void onUserListUpdate(String[] users);

    /**
     * 连接断开
     */
    void onDisconnected();
}
