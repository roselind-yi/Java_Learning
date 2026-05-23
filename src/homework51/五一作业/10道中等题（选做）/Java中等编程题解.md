
# Java 中等编程题解（10道）

---

## 1. 数组统计

### 解题思路
- 使用数组存储用户输入的5个整数
- 遍历数组，分别计算最大值、最小值和总和
- 通过总和除以元素个数得到平均值

### 解题步骤
1. 创建 Scanner 对象
2. 声明长度为5的整数数组
3. 使用循环读取5个整数存入数组
4. 初始化最大值、最小值为数组第一个元素，总和为0
5. 遍历数组，更新最大值、最小值和总和
6. 计算平均值
7. 输出统计结果
8. 关闭 Scanner

```java
import java.util.Scanner;

public class ArrayStats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];  // 声明长度为5的整数数组
        
        // 循环读取5个整数存入数组
        for (int i = 0; i < 5; i++) {
            System.out.print("请输入第" + (i + 1) + "个数：");
            numbers[i] = scanner.nextInt();
        }
        
        // 初始化最大值、最小值和总和
        int max = numbers[0];
        int min = numbers[0];
        int sum = 0;
        
        // 遍历数组计算统计值
        for (int num : numbers) {
            if (num > max) max = num;  // 更新最大值
            if (num < min) min = num;  // 更新最小值
            sum += num;                // 累加求和
        }
        
        // 计算平均值（转换为double避免整数除法）
        double average = (double) sum / numbers.length;
        
        // 输出结果
        System.out.println("最大值：" + max);
        System.out.println("最小值：" + min);
        System.out.println("平均值：" + average);
        
        scanner.close();
    }
}
```

---

## 2. 数组反转

### 解题思路
- 使用双指针法：一个指针从数组开头（left=0），一个从末尾（right=length-1）
- 交换两个指针指向的元素
- 然后向中间移动指针，直到 left >= right

### 解题步骤
1. 创建 Scanner 对象
2. 读取数组长度
3. 创建对应长度的数组
4. 使用循环读取数组元素
5. 输出原数组
6. 使用双指针法反转数组
7. 输出反转后的数组
8. 关闭 Scanner

```java
import java.util.Scanner;

public class ArrayReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入数组长度：");
        int length = scanner.nextInt();
        
        int[] array = new int[length];  // 创建数组
        
        // 读取数组元素
        for (int i = 0; i < length; i++) {
            System.out.print("请输入第" + (i + 1) + "个元素：");
            array[i] = scanner.nextInt();
        }
        
        // 输出原数组
        System.out.print("原数组：[");
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + (i < length - 1 ? ", " : "]\n"));
        }
        
        // 双指针法反转数组
        int left = 0;                // 左指针从开头开始
        int right = length - 1;      // 右指针从末尾开始
        
        while (left < right) {
            // 交换左右指针指向的元素
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            
            left++;   // 左指针右移
            right--;  // 右指针左移
        }
        
        // 输出反转后的数组
        System.out.print("反转后：[");
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + (i < length - 1 ? ", " : "]"));
        }
        
        scanner.close();
    }
}
```

---

## 3. 斐波那契数列

### 解题思路
- 斐波那契数列：第一个和第二个数都是1，从第三个数开始，每个数等于前两个数之和
- 使用变量 a 和 b 保存前两个数
- 通过循环计算后续的数

### 解题步骤
1. 创建 Scanner 对象
2. 读取数列长度n
3. 处理边界情况：n=1输出[1]，n=2输出[1,1]
4. 使用循环计算后续项：c = a + b，然后更新 a=b, b=c
5. 输出结果
6. 关闭 Scanner

```java
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入数列长度：");
        int n = scanner.nextInt();
        
        System.out.println("斐波那契数列前" + n + "项：");
        
        // 处理边界情况
        if (n >= 1) System.out.print(1);
        if (n >= 2) System.out.print(" 1");
        
        // 从第3项开始计算
        int a = 1, b = 1;  // 保存前两个数
        for (int i = 3; i <= n; i++) {
            int c = a + b;   // 当前数 = 前两个数之和
            System.out.print(" " + c);
            a = b;           // 更新前一个数
            b = c;           // 更新当前数
        }
        
        scanner.close();
    }
}
```

---

## 4. 学生成绩管理

### 解题思路
- 创建 Student 类，包含姓名和成绩属性
- 使用数组存储多个 Student 对象
- 通过循环输入学生信息并创建对象
- 遍历数组输出所有学生信息

### 解题步骤
1. 创建 Student 类：
   - 私有属性：name（姓名）、score（成绩）
   - 构造方法初始化属性
   - getter方法获取属性值
2. 在主方法中：
   - 创建 Scanner 对象
   - 创建 Student 数组
   - 循环读取学生信息，创建对象存入数组
   - 遍历数组输出学生信息
   - 关闭 Scanner

```java
import java.util.Scanner;

// 学生类，封装姓名和成绩
class Student {
    private String name;  // 姓名
    private int score;    // 成绩
    
    // 构造方法，初始化姓名和成绩
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
}

public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[3];  // 创建学生数组
        
        // 循环输入3个学生信息
        for (int i = 0; i < 3; i++) {
            System.out.print("请输入第" + (i + 1) + "个学生姓名：");
            String name = scanner.next();  // 读取姓名
            
            System.out.print("请输入第" + (i + 1) + "个学生成绩：");
            int score = scanner.nextInt();  // 读取成绩
            
            // 创建Student对象并存入数组
            students[i] = new Student(name, score);
        }
        
        // 输出所有学生信息
        System.out.println("\n学生列表：");
        for (Student student : students) {
            System.out.println("姓名：" + student.getName() + "，成绩：" + student.getScore());
        }
        
        scanner.close();
    }
}
```

---

## 5. 简单图书管理（链表基础）

### 解题思路
- 创建 Book 类作为链表节点，包含书名、作者和指向下一个节点的引用
- 创建 BookList 类管理链表，提供添加和打印功能
- 链表的添加操作：遍历到链表末尾，将新节点连接到最后

### 解题步骤
1. 创建 Book 类：
   - 属性：name（书名）、author（作者）、next（下一个节点）
   - 构造方法初始化属性
2. 创建 BookList 类：
   - 属性：head（链表头节点）
   - add() 方法：添加节点到链表末尾
   - print() 方法：遍历链表输出所有图书
3. 在主方法中：
   - 创建 Scanner 对象
   - 创建 BookList 对象
   - 循环读取图书信息并添加到链表
   - 调用 print() 方法输出所有图书
   - 关闭 Scanner

```java
import java.util.Scanner;

// 图书类，作为链表节点
class Book {
    String name;   // 书名
    String author; // 作者
    Book next;     // 指向下一个节点的引用
    
    // 构造方法
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        this.next = null;  // 初始化为null
    }
}

// 图书链表管理类
class BookList {
    private Book head;  // 链表头节点
    
    // 添加图书到链表末尾
    public void add(String name, String author) {
        Book newBook = new Book(name, author);
        
        // 如果链表为空，新节点作为头节点
        if (head == null) {
            head = newBook;
        } else {
            // 遍历到链表末尾
            Book current = head;
            while (current.next != null) {
                current = current.next;
            }
            // 将新节点连接到末尾
            current.next = newBook;
        }
    }
    
    // 遍历打印所有图书
    public void print() {
        Book current = head;  // 从头部开始遍历
        while (current != null) {
            System.out.println("《" + current.name + "》 - " + current.author);
            current = current.next;  // 移动到下一个节点
        }
    }
}

public class BookManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookList bookList = new BookList();  // 创建图书链表
        
        System.out.print("请输入图书数量：");
        int n = scanner.nextInt();
        scanner.nextLine();  // 读取换行符
        
        // 循环添加图书
        for (int i = 0; i < n; i++) {
            System.out.print("请输入第" + (i + 1) + "本书名：");
            String name = scanner.nextLine();
            
            System.out.print("请输入第" + (i + 1) + "本书作者：");
            String author = scanner.nextLine();
            
            bookList.add(name, author);  // 添加到链表
        }
        
        // 输出所有图书
        System.out.println("\n图书列表：");
        bookList.print();
        
        scanner.close();
    }
}
```

---

## 6. 数组去重

### 解题思路
- 使用一个计数器记录不重复元素的个数
- 遍历数组，对于每个元素，检查是否已存在于前面的不重复元素中
- 如果不存在，将其添加到不重复元素区域
- 最后只输出不重复的部分

### 解题步骤
1. 创建 Scanner 对象
2. 读取数组长度
3. 创建数组并读取元素
4. 处理空数组情况
5. 使用双重循环去重：
   - 外层循环遍历所有元素
   - 内层循环检查是否重复
6. 输出去重后的数组
7. 关闭 Scanner

```java
import java.util.Scanner;

public class ArrayRemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入数组长度：");
        int length = scanner.nextInt();
        
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.print("请输入第" + (i + 1) + "个元素：");
            array[i] = scanner.nextInt();
        }
        
        // 处理空数组情况
        if (length == 0) {
            System.out.println("去重后的数组：[]");
            return;
        }
        
        // 记录不重复元素的个数，至少有一个不重复元素
        int uniqueCount = 1;
        
        // 从第二个元素开始检查
        for (int i = 1; i < length; i++) {
            boolean isDuplicate = false;
            
            // 检查当前元素是否在已有的不重复元素中
            for (int j = 0; j < uniqueCount; j++) {
                if (array[i] == array[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            
            // 如果不重复，添加到不重复区域
            if (!isDuplicate) {
                array[uniqueCount] = array[i];
                uniqueCount++;
            }
        }
        
        // 输出去重后的数组
        System.out.print("去重后的数组：[");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(array[i] + (i < uniqueCount - 1 ? ", " : "]"));
        }
        
        scanner.close();
    }
}
```

---

## 7. 冒泡排序

### 解题思路
- 冒泡排序：重复遍历数组，比较相邻元素
- 如果前一个元素大于后一个，交换它们的位置
- 每一轮排序后，最大的元素会"冒泡"到数组末尾
- 需要进行 n-1 轮排序

### 解题步骤
1. 创建 Scanner 对象
2. 读取数组长度
3. 创建数组并读取元素
4. 输出排序前的数组
5. 使用双重循环进行冒泡排序：
   - 外层循环控制排序轮数（n-1轮）
   - 内层循环比较相邻元素并交换
6. 输出排序后的数组
7. 关闭 Scanner

```java
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入数组长度：");
        int length = scanner.nextInt();
        
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.print("请输入第" + (i + 1) + "个元素：");
            array[i] = scanner.nextInt();
        }
        
        // 输出排序前的数组
        System.out.print("排序前：[");
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + (i < length - 1 ? ", " : "]\n"));
        }
        
        // 冒泡排序
        for (int i = 0; i < length - 1; i++) {  // 外层循环：排序轮数
            // 内层循环：每轮比较次数递减（末尾i个元素已排好）
            for (int j = 0; j < length - 1 - i; j++) {
                // 如果前一个大于后一个，交换位置
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        
        // 输出排序后的数组
        System.out.print("排序后：[");
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + (i < length - 1 ? ", " : "]"));
        }
        
        scanner.close();
    }
}
```

---

## 8. 查找数组元素

### 解题思路
- 使用 `for` 循环遍历数组
- 比较每个元素与目标值
- 如果找到匹配项，记录索引并退出循环
- 如果遍历结束仍未找到，索引保持为-1

### 解题步骤
1. 创建 Scanner 对象
2. 读取数组长度
3. 创建数组并读取元素
4. 读取目标值
5. 使用 `for` 循环遍历数组查找目标值
6. 根据索引值输出结果
7. 关闭 Scanner

```java
import java.util.Scanner;

public class ArraySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入数组长度：");
        int length = scanner.nextInt();
        
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.print("请输入第" + (i + 1) + "个元素：");
            array[i] = scanner.nextInt();
        }
        
        System.out.print("请输入要查找的目标值：");
        int target = scanner.nextInt();
        
        int index = -1;  // 初始化为-1，表示未找到
        
        // 遍历数组查找目标值
        for (int i = 0; i < length; i++) {
            if (array[i] == target) {
                index = i;  // 找到目标值，记录索引
                break;      // 退出循环
            }
        }
        
        // 根据索引输出结果
        if (index != -1) {
            System.out.println("目标值" + target + "在数组中的索引是：" + index);
        } else {
            System.out.println("目标值" + target + "不在数组中");
        }
        
        scanner.close();
    }
}
```

---

## 9. 字符串反转

### 解题思路
- 将字符串转换为字符数组
- 使用双指针法反转字符数组：
  - 左指针从开头，右指针从末尾
  - 交换两个指针指向的字符
  - 向中间移动指针直到相遇
- 将反转后的字符数组转换回字符串

### 解题步骤
1. 创建 Scanner 对象
2. 读取输入的字符串
3. 将字符串转换为字符数组
4. 使用双指针法反转字符数组
5. 将字符数组转换为字符串
6. 输出反转后的字符串
7. 关闭 Scanner

```java
import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入一个字符串：");
        String str = scanner.nextLine();  // 读取字符串
        
        // 将字符串转换为字符数组
        char[] chars = str.toCharArray();
        
        int left = 0;                // 左指针从开头
        int right = chars.length - 1;  // 右指针从末尾
        
        // 双指针法反转字符数组
        while (left < right) {
            // 交换左右指针指向的字符
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            
            left++;   // 左指针右移
            right--;  // 右指针左移
        }
        
        // 将字符数组转换为字符串
        String reversed = new String(chars);
        
        System.out.println("反转后的字符串：" + reversed);
        
        scanner.close();
    }
}
```

---

## 10. 生成验证码

### 解题思路
- 创建包含所有可能字符的字符串（大写字母、小写字母、数字）
- 使用 `Random` 类随机生成索引
- 循环6次，每次随机选择一个字符
- 将选中的字符拼接成验证码字符串

### 解题步骤
1. 定义包含所有可能字符的字符串
2. 创建 Random 对象
3. 创建 StringBuilder 对象用于拼接验证码
4. 循环6次：
   - 生成0到字符长度-1之间的随机索引
   - 获取对应位置的字符
   - 添加到 StringBuilder
5. 输出生成的验证码

```java
import java.util.Random;

public class GenerateCode {
    public static void main(String[] args) {
        // 包含所有可能字符的字符串
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        
        Random random = new Random();
        
        // 使用StringBuilder拼接验证码
        StringBuilder code = new StringBuilder();
        
        // 生成6位验证码
        for (int i = 0; i < 6; i++) {
            // 生成随机索引（0到chars.length()-1）
            int index = random.nextInt(chars.length());
            // 获取对应字符并添加到验证码
            code.append(chars.charAt(index));
        }
        
        System.out.println("生成的验证码：" + code);
    }
}
```
