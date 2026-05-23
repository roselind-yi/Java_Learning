package homework51.advance;

import java.util.Scanner;

// 图书类，作为链表节点
class Book {
    String name;   // 书名
    String author; // 作者
    Book next;     // 下一个节点

    // 构造方法
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        this.next = null;
    }
}

// 图书链表管理类
class BookList {
    private Book head;  // 链表头节点

    // 添加图书
    public void add(String name, String author) {
        Book newBook = new Book(name, author);

        if (head == null) {
            head = newBook;
        } else {
            Book current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newBook;
        }
        System.out.println("图书添加成功！");
    }

    // 删除图书（按书名）
    public void delete(String name) {
        // 如果链表为空
        if (head == null) {
            System.out.println("图书列表为空");
            return;
        }

        // 如果要删除的是头节点
        if (head.name.equals(name)) {
            head = head.next;
            System.out.println("图书删除成功！");
            return;
        }

        // 遍历链表查找要删除的节点
        Book current = head;
        while (current.next != null && !current.next.name.equals(name)) {
            current = current.next;
        }

        // 如果找到匹配的节点
        if (current.next != null) {
            current.next = current.next.next;  // 跳过要删除的节点
            System.out.println("图书删除成功！");
        } else {
            System.out.println("未找到该图书");
        }
    }

    // 查询图书（按书名）
    public void find(String name) {
        Book current = head;
        while (current != null) {
            if (current.name.equals(name)) {
                System.out.println("找到图书：《" + current.name + "》 - " + current.author);
                return;
            }
            current = current.next;
        }
        System.out.println("未找到该图书");
    }

    // 显示所有图书
    public void printAll() {
        if (head == null) {
            System.out.println("图书列表为空");
            return;
        }

        Book current = head;
        System.out.println("图书列表：");
        while (current != null) {
            System.out.println("《" + current.name + "》 - " + current.author);
            current = current.next;
        }
    }
}

public class h4图书管理系统_链表增删改查 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookList bookList = new BookList();  // 创建图书链表

        while (true) {
            // 显示菜单
            System.out.println("\n请选择操作：1.添加图书 2.删除图书 3.查询图书 4.显示所有 5.退出");
            System.out.print("请输入选择：");
            int choice = scanner.nextInt();
            scanner.nextLine();  // 读取换行符

            switch (choice) {
                case 1:  // 添加图书
                    System.out.print("请输入书名：");
                    String name = scanner.nextLine();
                    System.out.print("请输入作者：");
                    String author = scanner.nextLine();
                    bookList.add(name, author);
                    break;
                case 2:  // 删除图书
                    System.out.print("请输入要删除的书名：");
                    String deleteName = scanner.nextLine();
                    bookList.delete(deleteName);
                    break;
                case 3:  // 查询图书
                    System.out.print("请输入要查询的书名：");
                    String findName = scanner.nextLine();
                    bookList.find(findName);
                    break;
                case 4:  // 显示所有图书
                    bookList.printAll();
                    break;
                case 5:  // 退出
                    System.out.println("程序退出");
                    scanner.close();
                    return;
                default:
                    System.out.println("无效选择");
            }
        }
    }
}