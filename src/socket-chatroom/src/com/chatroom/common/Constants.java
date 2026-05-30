package com.chatroom.common;

/**
 * 全局常量定义
 */
public interface Constants {

    /** 服务端默认监听端口 */
    int DEFAULT_PORT = 8888;

    /** 默认连接地址 */
    String DEFAULT_HOST = "127.0.0.1";

    /** 线程池核心大小 */
    int DEFAULT_POOL_SIZE = 10;

    /** 字符编码 */
    String CHARSET = "UTF-8";

    /** 系统消息发送者标识 */
    String SYSTEM_SENDER = "[系统]";

    /** 退出指令 */
    String CMD_QUIT = "/quit";

    /** 查看在线用户指令 */
    String CMD_WHO = "/who";

    /** 心跳消息 */
    String HEARTBEAT = "PING";
}
