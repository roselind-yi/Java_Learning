package chapter09.chat;

import javax.swing.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 聊天消息类
 * 用于客户端和服务端之间的消息传输
 * 使用对象流进行序列化和反序列化
 */
public class Message implements Serializable {
    private static final long serialVersionUID = -1;
    /**
     * 发送者的用户名
     */
    private String username;
    /**
     * 消息的发送时间
     */
    private String sendTime;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 消息类型
     */
    private MessageType type;
    /**
     * 目标用户 (该字段用于私聊，该字段为null表示群聊消息)
     */
    private String targetUser;

    /**
     * 无参构造函数
     */
    public Message() {
    }

    /**
     * 指定用户名和消息内容的构造函数
     * @param username
     * @param content
     */
    public Message(String username, String content) {
        this.username = username;
        this.content = content;
        // 获取当前系统时间, 并格式化为 年-月-日 时:分:秒
        this.sendTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        // 消息类型默认是聊天消息
        this.type = MessageType.CHAT;
    }

    /**
     * 指定消息类型的构造函数，用于指定其他类型的消息
     * @param username
     * @param content
     * @param type
     */
    public Message(String username, String content, MessageType type) {
        this.username = username;
        this.content = content;
        this.type = type;
    }

    /**
     * 指定目标用户的构造函数 (用于构造一个私聊的消息)
     * @param username
     * @param content
     * @param targetUser
     */
    public Message(String username, String content, String targetUser) {
        this.username = username;
        this.content = content;
        this.targetUser = targetUser;
        this.type = MessageType.CHAT;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(String targetUser) {
        this.targetUser = targetUser;
    }
}