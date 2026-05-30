package com.chatroom.server;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * 管理所有在线客户端，提供广播功能 + 线程池
 */
public class ClientManager {

    /** 线程池 */
    private static final ExecutorService threadPool =
            Executors.newFixedThreadPool(com.chatroom.common.Constants.DEFAULT_POOL_SIZE);

    /** 在线客户端列表：clientId → PrintWriter（线程安全） */
    private static final ConcurrentHashMap<String, PrintWriter> clients = new ConcurrentHashMap<>();

    // ==================== 线程池 ====================

    public static ExecutorService getThreadPool() {
        return threadPool;
    }

    public static void shutdown() {
        threadPool.shutdownNow();
    }

    // ==================== 客户端管理 ====================

    /**
     * 注册上线客户端
     */
    public static void register(String clientId, PrintWriter writer) {
        clients.put(clientId, writer);
    }

    /**
     * 注销离线客户端
     */
    public static void unregister(String clientId) {
        PrintWriter writer = clients.remove(clientId);
        if (writer != null) {
            try {
                writer.close();
            } catch (Exception ignored) {
            }
        }
    }

    // ==================== 消息广播 ====================

    /**
     * 向所有其他在线客户端广播消息
     *
     * @param senderId 发送者 ID（不发送给自己）
     * @param message  消息内容
     */
    public static void broadcast(String senderId, String message) {
        // 快照复制，避免遍历时 Map 被修改
        Map<String, PrintWriter> snapshot = new HashMap<>(clients);
        for (Map.Entry<String, PrintWriter> entry : snapshot.entrySet()) {
            String id = entry.getKey();
            if (id.equals(senderId)) {
                continue; // 不发送给自己
            }
            try {
                entry.getValue().println(message);
                entry.getValue().flush();
            } catch (Exception e) {
                // 发送失败（客户端已断开但尚未清理），移除之
                System.out.println("发送失败，移除客户端：" + id);
                unregister(id);
            }
        }
    }

    // ==================== 查询 ====================

    /**
     * 获取当前在线用户列表（字符串）
     */
    public static String getOnlineUsers() {
        if (clients.isEmpty()) {
            return "暂无其他在线用户";
        }
        return String.join(", ", clients.keySet());
    }
}
