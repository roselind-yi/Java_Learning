package homework51.advance;
import java.util.Scanner;

// 节点类，作为队列的元素
class Node {
    String data;  // 存储的数据
    Node next;    // 指向下一个节点

    // 构造方法
    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

// 队列类，使用链表实现
class Queue {
    private Node head;  // 队列头部
    private Node tail;  // 队列尾部

    // 入队：在尾部添加元素
    public void enqueue(String data) {
        Node newNode = new Node(data);

        // 如果队列为空，头尾指针都指向新节点
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            // 否则在尾部添加新节点，更新尾指针
            tail.next = newNode;
            tail = newNode;
        }
    }

    // 出队：从头部移除元素
    public String dequeue() {
        // 如果队列为空，返回null
        if (head == null) {
            return null;
        }

        // 保存头部数据
        String data = head.data;

        // 移动头指针到下一个节点
        head = head.next;

        // 如果头指针变为null，说明队列已空，尾指针也置为null
        if (head == null) {
            tail = null;
        }

        return data;
    }

    // 查看队首元素（不移除）
    public String peek() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return head == null;
    }
}
public class h1链表实现队列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue();  // 创建队列

        while (true) {
            // 显示菜单
            System.out.println("\n请选择操作：1.入队 2.出队 3.查看队首 4.退出");
            System.out.print("请输入选择：");
            int choice = scanner.nextInt();
            scanner.nextLine();  // 读取换行符

            switch (choice) {
                case 1:  // 入队
                    System.out.print("请输入入队元素：");
                    String data = scanner.nextLine();
                    queue.enqueue(data);
                    break;
                case 2:  // 出队
                    String dequeued = queue.dequeue();
                    if (dequeued != null) {
                        System.out.println("出队元素：" + dequeued);
                    } else {
                        System.out.println("队列为空");
                    }
                    break;
                case 3:  // 查看队首
                    String front = queue.peek();
                    if (front != null) {
                        System.out.println("队首元素：" + front);
                    } else {
                        System.out.println("队列为空");
                    }
                    break;
                case 4:  // 退出
                    System.out.println("程序退出");
                    scanner.close();
                    return;
                default:
                    System.out.println("无效选择");
            }
        }
    }
}
