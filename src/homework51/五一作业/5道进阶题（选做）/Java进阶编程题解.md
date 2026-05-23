
# Java 进阶编程题解（5道）

---

## 1. 链表实现队列

### 解题思路
- 队列是先进先出（FIFO）的数据结构
- 使用链表实现队列，需要维护头指针（head）和尾指针（tail）
- 入队（enqueue）：在链表尾部添加节点
- 出队（dequeue）：从链表头部移除节点
- 查看队首（peek）：返回头部节点的数据但不移除

### 解题步骤
1. 创建 Node 类作为链表节点：
   - 属性：data（数据）、next（下一个节点）
   - 构造方法初始化数据
2. 创建 Queue 类管理队列：
   - 属性：head（头指针）、tail（尾指针）
   - enqueue()：入队操作
   - dequeue()：出队操作
   - peek()：查看队首
   - isEmpty()：判断队列是否为空
3. 在主方法中：
   - 创建 Scanner 和 Queue 对象
   - 使用循环提供菜单操作
   - 根据用户选择执行相应操作

```java
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

public class QueueWithLinkedList {
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
```

---

## 2. 学生成绩排序系统

### 解题思路
- 创建 Student 类，实现 Comparable 接口
- 重写 compareTo() 方法，按成绩降序排序
- 使用 Arrays.sort() 方法对 Student 数组排序
- 排序后遍历输出学生信息

### 解题步骤
1. 创建 Student 类：
   - 属性：name（姓名）、score（成绩）
   - 构造方法初始化属性
   - getter方法获取属性
   - 实现 Comparable<Student> 接口
   - 重写 compareTo() 方法，按成绩降序比较
2. 在主方法中：
   - 创建 Scanner 对象
   - 读取学生数量
   - 创建 Student 数组
   - 循环读取学生信息，创建对象存入数组
   - 使用 Arrays.sort() 排序
   - 遍历输出排序后的学生信息
   - 关闭 Scanner

```java
import java.util.Scanner;
import java.util.Arrays;

// 学生类，实现Comparable接口以支持排序
class Student implements Comparable<Student> {
    private String name;  // 姓名
    private int score;    // 成绩
    
    // 构造方法
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    // 获取姓名
    public String getName() {
        return name;
    }
    
    // 获取成绩
    public int getScore() {
        return score;
    }
    
    // 重写compareTo方法，按成绩降序排序
    // 返回负数：当前对象排在参数对象前面
    // 返回正数：当前对象排在参数对象后面
    @Override
    public int compareTo(Student other) {
        // 按成绩降序：other.score - this.score
        // 如果返回正数，说明other.score > this.score，this排在后面
        return other.score - this.score;
    }
}

public class StudentSortSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入学生数量：");
        int n = scanner.nextInt();
        scanner.nextLine();  // 读取换行符
        
        Student[] students = new Student[n];  // 创建学生数组
        
        // 循环输入学生信息
        for (int i = 0; i < n; i++) {
            System.out.print("请输入第" + (i + 1) + "个学生姓名：");
            String name = scanner.nextLine();
            
            System.out.print("请输入第" + (i + 1) + "个学生成绩：");
            int score = scanner.nextInt();
            scanner.nextLine();  // 读取换行符
            
            students[i] = new Student(name, score);
        }
        
        // 使用Arrays.sort()排序，会自动调用Student的compareTo()方法
        Arrays.sort(students);
        
        // 输出排序后的学生信息
        System.out.println("\n按成绩排序后：");
        for (int i = 0; i < students.length; i++) {
            System.out.println((i + 1) + ". " + students[i].getName() + " - " + students[i].getScore() + "分");
        }
        
        scanner.close();
    }
}
```

---

## 3. 猜数字游戏升级版

### 解题思路
- 程序随机生成1-100的数字作为目标
- 用户有5次猜测机会
- 每次猜测后显示剩余次数
- 猜对得20分，支持多轮游戏
- 使用外层循环控制多轮游戏
- 使用内层循环控制每轮的5次猜测

### 解题步骤
1. 创建 Random 和 Scanner 对象
2. 初始化总得分、轮数和游戏状态
3. 使用外层 `while` 循环控制多轮游戏：
   - 生成目标数字
   - 使用内层 `for` 循环控制5次猜测机会
   - 比较猜测与目标，给出提示
   - 猜对则加分并跳出本轮
4. 每轮结束后询问是否继续
5. 游戏结束输出总得分
6. 关闭 Scanner

```java
import java.util.Random;
import java.util.Scanner;

public class GuessNumberAdvanced {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        int totalScore = 0;  // 总得分
        int round = 1;       // 当前轮数
        String playAgain = "y";  // 是否继续游戏
        
        // 外层循环：控制多轮游戏
        while (playAgain.equalsIgnoreCase("y")) {
            int target = random.nextInt(100) + 1;  // 生成1-100的随机数
            int attempts = 5;                      // 剩余猜测次数
            boolean guessed = false;               // 是否猜对
            
            System.out.println("\n=== 第" + round + "轮游戏 ===");
            
            // 内层循环：控制每轮的5次猜测机会
            for (int i = 0; i < 5; i++) {
                System.out.print("猜一个1-100之间的数字：");
                int guess = scanner.nextInt();
                
                attempts--;  // 减少剩余次数
                
                if (guess == target) {
                    System.out.println("恭喜！猜对了！本轮得分：20");
                    totalScore += 20;  // 加分
                    guessed = true;
                    break;  // 跳出本轮
                } else if (guess > target) {
                    System.out.println("太大了！剩余次数：" + attempts);
                } else {
                    System.out.println("太小了！剩余次数：" + attempts);
                }
            }
            
            // 如果没猜对，显示正确答案
            if (!guessed) {
                System.out.println("游戏结束！正确答案是：" + target);
            }
            
            // 询问是否继续游戏
            System.out.print("\n是否继续游戏？(y/n)：");
            playAgain = scanner.next();
            round++;  // 轮数加1
        }
        
        // 游戏结束，输出总得分
        System.out.println("\n游戏结束！总得分：" + totalScore);
        scanner.close();
    }
}
```

---

## 4. 图书管理系统（链表增删改查）

### 解题思路
- 使用链表存储图书信息
- 实现添加、删除、查询、显示所有图书功能
- 删除和查询都需要遍历链表找到目标节点
- 使用菜单驱动用户操作

### 解题步骤
1. 创建 Book 类作为链表节点：
   - 属性：name（书名）、author（作者）、next（下一个节点）
   - 构造方法初始化属性
2. 创建 BookList 类管理链表：
   - add()：添加图书到链表末尾
   - delete()：按书名删除图书
   - find()：按书名查询图书
   - printAll()：显示所有图书
3. 在主方法中：
   - 创建 Scanner 和 BookList 对象
   - 使用循环显示菜单
   - 根据用户选择执行相应操作

```java
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

public class BookManagementSystem {
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
```

---

## 5. 成绩统计分析系统

### 解题思路
- 使用数组存储所有学生成绩
- 遍历数组计算总分、最高分、最低分
- 统计及格人数计算及格率
- 使用计数器数组统计各分数段人数
- 最后格式化输出所有统计结果

### 解题步骤
1. 创建 Scanner 对象
2. 读取学生数量
3. 创建成绩数组并读取成绩
4. 初始化统计变量：
   - sum：总分
   - max：最高分
   - min：最低分
   - passCount：及格人数
   - ranges：各分数段人数数组
5. 遍历成绩数组更新统计变量
6. 计算平均分和及格率
7. 格式化输出统计结果
8. 关闭 Scanner

```java
import java.util.Scanner;

public class ScoreAnalysisSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入学生数量：");
        int n = scanner.nextInt();
        
        int[] scores = new int[n];  // 存储所有成绩
        
        // 读取成绩
        for (int i = 0; i < n; i++) {
            System.out.print("请输入第" + (i + 1) + "个学生成绩：");
            scores[i] = scanner.nextInt();
        }
        
        // 初始化统计变量
        int sum = 0;           // 总分
        int max = scores[0];   // 最高分
        int min = scores[0];   // 最低分
        int passCount = 0;     // 及格人数
        
        // 分数段计数器：[0-59, 60-69, 70-79, 80-89, 90-100]
        int[] ranges = new int[5];
        
        // 遍历成绩统计
        for (int score : scores) {
            sum += score;  // 累加总分
            
            if (score > max) max = score;  // 更新最高分
            if (score < min) min = score;  // 更新最低分
            
            if (score >= 60) passCount++;  // 统计及格人数
            
            // 统计各分数段人数
            if (score < 60) {
                ranges[0]++;
            } else if (score < 70) {
                ranges[1]++;
            } else if (score < 80) {
                ranges[2]++;
            } else if (score < 90) {
                ranges[3]++;
            } else {
                ranges[4]++;
            }
        }
        
        // 计算平均分和及格率
        double average = (double) sum / n;
        double passRate = (double) passCount / n * 100;
        
        // 输出统计结果
        System.out.println("\n=== 成绩统计分析 ===");
        System.out.printf("平均分：%.1f\n", average);
        System.out.println("最高分：" + max);
        System.out.println("最低分：" + min);
        System.out.printf("及格率：%.1f%%\n", passRate);
        
        // 输出各分数段人数
        System.out.println("\n各分数段人数：");
        System.out.println("0-59分：" + ranges[0] + "人");
        System.out.println("60-69分：" + ranges[1] + "人");
        System.out.println("70-79分：" + ranges[2] + "人");
        System.out.println("80-89分：" + ranges[3] + "人");
        System.out.println("90-100分：" + ranges[4] + "人");
        
        scanner.close();
    }
}
```
