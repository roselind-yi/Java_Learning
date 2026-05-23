
# Java 基础编程题解（20道）

---

## 1. 两个数相加

### 解题思路
- 使用 `Scanner` 类从控制台获取用户输入的两个整数
- 通过算术运算符 `+` 计算两个数的和
- 最后输出计算结果

### 解题步骤
1. 导入 `java.util.Scanner` 包
2. 创建 Scanner 对象用于接收用户输入
3. 提示用户输入第一个数并读取
4. 提示用户输入第二个数并读取
5. 计算两个数的和
6. 输出结果
7. 关闭 Scanner 对象

```java
import java.util.Scanner;  // 导入Scanner类用于接收用户输入

public class AddTwoNumbers {
    public static void main(String[] args) {
        // 创建Scanner对象，关联标准输入流
        Scanner scanner = new Scanner(System.in);
        
        // 提示用户输入第一个数
        System.out.print("请输入第一个数：");
        int num1 = scanner.nextInt();  // 读取整数输入
        
        // 提示用户输入第二个数
        System.out.print("请输入第二个数：");
        int num2 = scanner.nextInt();  // 读取整数输入
        
        // 计算两个数的和
        int sum = num1 + num2;
        
        // 输出结果，使用字符串拼接
        System.out.println(num1 + " + " + num2 + " = " + sum);
        
        // 关闭Scanner，释放资源
        scanner.close();
    }
}
```

---

## 2. 判断奇偶性

### 解题思路
- 使用取模运算符 `%` 判断整数是否能被2整除
- 如果 `num % 2 == 0`，说明是偶数；否则是奇数
- 通过 `if-else` 分支结构输出结果

### 解题步骤
1. 导入 Scanner 包
2. 创建 Scanner 对象
3. 读取用户输入的整数
4. 使用 `num % 2 == 0` 判断奇偶性
5. 根据判断结果输出相应信息
6. 关闭 Scanner

```java
import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入一个整数：");
        int num = scanner.nextInt();  // 获取用户输入的整数
        
        // 判断条件：能被2整除即为偶数
        if (num % 2 == 0) {
            System.out.println(num + " 是偶数");
        } else {
            System.out.println(num + " 是奇数");
        }
        
        scanner.close();
    }
}
```

---

## 3. 判断闰年

### 解题思路
- 闰年判断规则：能被4整除但不能被100整除，或者能被400整除
- 使用逻辑运算符 `&&` 和 `||` 组合条件
- 通过 `if-else` 输出判断结果

### 解题步骤
1. 导入 Scanner 包
2. 创建 Scanner 对象
3. 读取用户输入的年份
4. 使用复合条件判断是否为闰年
5. 输出判断结果
6. 关闭 Scanner

```java
import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入年份：");
        int year = scanner.nextInt();  // 获取年份
        
        // 闰年判断条件：
        // 条件1：能被4整除但不能被100整除
        // 条件2：能被400整除
        // 两个条件满足其一即为闰年
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        
        if (isLeap) {
            System.out.println(year + "年是闰年");
        } else {
            System.out.println(year + "年不是闰年");
        }
        
        scanner.close();
    }
}
```

---

## 4. 求三个数的最大值

### 解题思路
- 使用 `Math.max()` 方法可以方便地获取最大值
- `Math.max(a, b)` 返回a和b中的较大值
- 嵌套使用 `Math.max(a, Math.max(b, c))` 即可获取三个数的最大值

### 解题步骤
1. 导入 Scanner 包
2. 创建 Scanner 对象
3. 依次读取三个整数
4. 使用 `Math.max()` 方法求最大值
5. 输出结果
6. 关闭 Scanner

```java
import java.util.Scanner;

public class MaxOfThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入第一个数：");
        int a = scanner.nextInt();
        
        System.out.print("请输入第二个数：");
        int b = scanner.nextInt();
        
        System.out.print("请输入第三个数：");
        int c = scanner.nextInt();
        
        // 嵌套使用Math.max()获取三个数的最大值
        // 先比较b和c，再将结果与a比较
        int max = Math.max(a, Math.max(b, c));
        
        System.out.println("最大值是：" + max);
        
        scanner.close();
    }
}
```

---

## 5. 计算BMI指数

### 解题思路
- BMI计算公式：BMI = 体重(kg) / 身高(m)²
- 根据BMI值判断体型：<18.5偏瘦，18.5-24正常，≥24偏胖
- 使用 `if-else if-else` 分支结构判断体型

### 解题步骤
1. 导入 Scanner 包
2. 创建 Scanner 对象
3. 读取身高（double类型）
4. 读取体重（double类型）
5. 计算BMI值
6. 判断体型并输出结果
7. 关闭 Scanner

```java
import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入身高（米）：");
        double height = scanner.nextDouble();  // 读取身高（米）
        
        System.out.print("请输入体重（公斤）：");
        double weight = scanner.nextDouble();  // 读取体重（公斤）
        
        // BMI计算公式：体重 / (身高 × 身高)
        double bmi = weight / (height * height);
        
        // 使用printf格式化输出，保留两位小数
        System.out.printf("您的BMI指数是：%.2f\n", bmi);
        
        // 根据BMI值判断体型
        String status;
        if (bmi < 18.5) {
            status = "偏瘦";
        } else if (bmi < 24) {  // 隐含条件：bmi >= 18.5
            status = "正常";
        } else {
            status = "偏胖";
        }
        
        System.out.println("体型：" + status);
        
        scanner.close();
    }
}
```

---

## 6. 简单计算器

### 解题思路
- 使用 `switch-case` 语句处理不同的运算符
- 支持加减乘除四种运算
- 需要处理除数为0的异常情况

### 解题步骤
1. 导入 Scanner 包
2. 创建 Scanner 对象
3. 读取第一个操作数
4. 读取运算符
5. 读取第二个操作数
6. 根据运算符执行相应运算
7. 处理异常情况（无效运算符、除数为0）
8. 输出结果
9. 关闭 Scanner

```java
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入第一个数：");
        double num1 = scanner.nextDouble();  // 读取第一个操作数
        
        System.out.print("请输入运算符：");
        char op = scanner.next().charAt(0);  // 读取运算符（取字符串第一个字符）
        
        System.out.print("请输入第二个数：");
        double num2 = scanner.nextDouble();  // 读取第二个操作数
        
        double result = 0;
        boolean valid = true;  // 标记运算是否有效
        
        // 根据运算符执行相应计算
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                // 除法需要判断除数是否为0
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("错误：除数不能为0");
                    valid = false;  // 标记运算无效
                }
                break;
            default:
                System.out.println("错误：无效的运算符");
                valid = false;
        }
        
        // 只有运算有效时才输出结果
        if (valid) {
            System.out.println(num1 + " " + op + " " + num2 + " = " + result);
        }
        
        scanner.close();
    }
}
```

---

## 7. 打印九九乘法表

### 解题思路
- 使用双层 `for` 循环实现
- 外层循环控制行数（1-9）
- 内层循环控制每行的列数（1到当前行数）
- 使用 `\t` 实现对齐

### 解题步骤
1. 外层循环遍历1到9，控制行数
2. 内层循环遍历1到当前行号，控制列数
3. 输出 `j × i = i×j` 的格式
4. 每行结束后换行

```java
public class MultiplicationTable {
    public static void main(String[] args) {
        // 外层循环：控制行数（1-9）
        for (int i = 1; i <= 9; i++) {
            // 内层循环：控制每行的列数（1到当前行号i）
            for (int j = 1; j <= i; j++) {
                // 输出乘法表达式，使用\t对齐
                System.out.print(j + "×" + i + "=" + (i * j) + "\t");
            }
            // 每行结束后换行
            System.out.println();
        }
    }
}
```

---

## 8. 求1到100的和

### 解题思路
- 使用 `for` 循环从1遍历到100
- 使用累加变量 `sum` 存储总和
- 初始值 `sum = 0`，每次循环将当前数加到sum上

### 解题步骤
1. 初始化累加变量 `sum = 0`
2. 使用 `for` 循环遍历1到100
3. 每次循环将当前数累加到sum
4. 循环结束后输出结果

```java
public class Sum1To100 {
    public static void main(String[] args) {
        int sum = 0;  // 累加变量，初始值为0
        
        // for循环：从1遍历到100
        for (int i = 1; i <= 100; i++) {
            sum += i;  // 等价于 sum = sum + i
        }
        
        System.out.println("1到100的和是：" + sum);
    }
}
```

---

## 9. 猜数字游戏（简单版）

### 解题思路
- 使用 `Random` 类生成1-100的随机数
- 使用 `while(true)` 无限循环接收用户猜测
- 根据猜测与目标值的大小关系给出提示
- 猜对后使用 `break` 跳出循环

### 解题步骤
1. 创建 Random 对象
2. 生成1-100的随机数作为目标值
3. 创建 Scanner 对象
4. 使用 `while(true)` 循环接收用户输入
5. 比较猜测值与目标值，给出"太大了"或"太小了"的提示
6. 猜对后输出恭喜信息并退出循环
7. 关闭 Scanner

```java
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Random random = new Random();  // 创建随机数生成器
        Scanner scanner = new Scanner(System.in);
        
        // 生成1-100的随机数（nextInt(100)生成0-99，+1后变为1-100）
        int target = random.nextInt(100) + 1;
        int guess;  // 存储用户猜测的数字
        
        System.out.println("猜一个1-100之间的数字：");
        
        // 无限循环，直到猜对为止
        while (true) {
            guess = scanner.nextInt();  // 获取用户猜测
            
            if (guess > target) {
                System.out.println("太大了！");
            } else if (guess < target) {
                System.out.println("太小了！");
            } else {
                System.out.println("恭喜！猜对了！");
                break;  // 猜对后退出循环
            }
        }
        
        scanner.close();
    }
}
```

---

## 10. 判断成绩等级

### 解题思路
- 使用 `if-else if-else` 分支结构判断成绩等级
- 判断顺序从高到低：90分以上优秀，80-89良好，70-79中等，60-69及格，60以下不及格
- 利用条件的"短路"特性，后面的条件隐含了前面条件不成立的前提

### 解题步骤
1. 导入 Scanner 包
2. 创建 Scanner 对象
3. 读取成绩（整数）
4. 使用多分支判断成绩等级
5. 输出等级
6. 关闭 Scanner

```java
import java.util.Scanner;

public class GradeLevel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入成绩：");
        int score = scanner.nextInt();  // 获取成绩
        
        String level;  // 存储等级
        
        // 从高到低判断成绩等级
        if (score >= 90) {
            level = "优秀";
        } else if (score >= 80) {  // 隐含：score < 90
            level = "良好";
        } else if (score >= 70) {  // 隐含：score < 80
            level = "中等";
        } else if (score >= 60) {  // 隐含：score < 70
            level = "及格";
        } else {
            level = "不及格";
        }
        
        System.out.println(level);
        
        scanner.close();
    }
}
```

---

## 11. 计算圆的面积和周长

### 解题思路
- 圆的面积公式：S = πr²
- 圆的周长公式：C = 2πr
- 使用 `Math.PI` 获取圆周率常量
- 使用 `printf` 格式化输出，保留两位小数

### 解题步骤
1. 导入 Scanner 包
2. 创建 Scanner 对象
3. 读取圆的半径
4. 计算面积和周长
5. 格式化输出结果
6. 关闭 Scanner

```java
import java.util.Scanner;

public class Circle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入圆的半径：");
        double radius = scanner.nextDouble();  // 获取半径
        
        // 计算面积：π × 半径²
        double area = Math.PI * radius * radius;
        
        // 计算周长：2 × π × 半径
        double perimeter = 2 * Math.PI * radius;
        
        // 格式化输出，保留两位小数
        System.out.printf("圆的面积：%.2f\n", area);
        System.out.printf("圆的周长：%.2f\n", perimeter);
        
        scanner.close();
    }
}
```

---

## 12. 华氏温度转摄氏温度

### 解题思路
- 转换公式：C = (F - 32) × 5/9
- 需要注意使用浮点除法（5.0/9.0）而非整数除法

### 解题步骤
1. 导入 Scanner 包
2. 创建 Scanner 对象
3. 读取华氏温度
4. 使用公式转换为摄氏温度
5. 输出结果
6. 关闭 Scanner

```java
import java.util.Scanner;

public class TemperatureConvert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入华氏温度：");
        double fahrenheit = scanner.nextDouble();  // 获取华氏温度
        
        // 转换公式：(华氏温度 - 32) × 5/9
        // 使用5.0/9.0确保浮点除法
        double celsius = (fahrenheit - 32) * 5.0 / 9.0;
        
        // 格式化输出，保留一位小数
        System.out.printf("%.1f°F = %.1f°C\n", fahrenheit, celsius);
        
        scanner.close();
    }
}
```

---

## 13. 判断是否为三角形

### 解题思路
- 三角形条件：任意两边之和大于第三边
- 需要同时满足三个条件：a+b>c、a+c>b、b+c>a
- 使用逻辑与 `&&` 连接三个条件

### 解题步骤
1. 导入 Scanner 包
2. 创建 Scanner 对象
3. 依次读取三条边的长度
4. 判断是否满足三角形条件
5. 输出判断结果
6. 关闭 Scanner

```java
import java.util.Scanner;

public class TriangleCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入第一条边：");
        double a = scanner.nextDouble();
        
        System.out.print("请输入第二条边：");
        double b = scanner.nextDouble();
        
        System.out.print("请输入第三条边：");
        double c = scanner.nextDouble();
        
        // 三角形条件：任意两边之和大于第三边
        boolean isTriangle = a + b > c && a + c > b && b + c > a;
        
        if (isTriangle) {
            System.out.println("可以构成三角形");
        } else {
            System.out.println("不能构成三角形");
        }
        
        scanner.close();
    }
}
```

---

## 14. 输出水仙花数

### 解题思路
- 水仙花数：一个三位数，其各位数字立方和等于该数本身
- 使用 `for` 循环遍历100-999
- 分解每个数的个位、十位、百位
- 判断立方和是否等于原数

### 解题步骤
1. 使用 `for` 循环遍历100到999
2. 分解每个数的各位数字：
   - 百位：`i / 100`
   - 十位：`(i / 10) % 10`
   - 个位：`i % 10`
3. 计算各位数字的立方和
4. 判断是否等于原数，是则输出

```java
public class NarcissisticNumber {
    public static void main(String[] args) {
        System.out.println("三位数的水仙花数有：");
        
        // 遍历所有三位数
        for (int i = 100; i < 1000; i++) {
            // 分解百位、十位、个位
            int hundreds = i / 100;        // 百位：整除100
            int tens = (i / 10) % 10;      // 十位：先整除10，再取模10
            int units = i % 10;            // 个位：取模10
            
            // 判断各位数字立方和是否等于原数
            if (Math.pow(hundreds, 3) + Math.pow(tens, 3) + Math.pow(units, 3) == i) {
                System.out.println(i);
            }
        }
    }
}
```

---

## 15. 求阶乘

### 解题思路
- 阶乘公式：n! = n × (n-1) × ... × 1
- 使用 `for` 循环累乘
- 使用 `long` 类型存储结果，避免整数溢出

### 解题步骤
1. 导入 Scanner 包
2. 创建 Scanner 对象
3. 读取用户输入的正整数
4. 使用 `for` 循环计算阶乘
5. 输出结果
6. 关闭 Scanner

```java
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入一个正整数：");
        int n = scanner.nextInt();
        
        // 使用long类型避免整数溢出
        long result = 1;
        
        // 从1累乘到n
        for (int i = 1; i <= n; i++) {
            result *= i;  // 等价于 result = result * i
        }
        
        System.out.println(n + "! = " + result);
        
        scanner.close();
    }
}
```

---

## 16. 打印倒三角形

### 解题思路
- 使用双层 `for` 循环
- 外层循环控制行数（从高度递减到1）
- 内层循环每行打印对应数量的星号

### 解题步骤
1. 导入 Scanner 包
2. 创建 Scanner 对象
3. 读取三角形高度
4. 外层循环从高度递减到1
5. 内层循环打印星号
6. 每行结束后换行
7. 关闭 Scanner

```java
import java.util.Scanner;

public class InvertedTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入三角形高度：");
        int height = scanner.nextInt();
        
        // 外层循环：从高度递减到1
        for (int i = height; i >= 1; i--) {
            // 内层循环：打印i个星号
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // 换行
            System.out.println();
        }
        
        scanner.close();
    }
}
```

---

## 17. 数字反转

### 解题思路
- 使用 `while` 循环和取模运算逐位提取数字
- 每次提取最后一位：`digit = num % 10`
- 构建反转数：`reversed = reversed * 10 + digit`
- 去掉已提取的最后一位：`num = num / 10`

### 解题步骤
1. 导入 Scanner 包
2. 创建 Scanner 对象
3. 读取用户输入的整数
4. 使用 `while` 循环逐位反转
5. 输出反转后的数字
6. 关闭 Scanner

```java
import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入一个整数：");
        int num = scanner.nextInt();
        
        int reversed = 0;  // 存储反转后的数字
        
        // 当num不为0时继续循环
        while (num != 0) {
            int digit = num % 10;        // 提取最后一位
            reversed = reversed * 10 + digit;  // 构建反转数
            num /= 10;                   // 去掉最后一位
        }
        
        System.out.println("反转后的数字：" + reversed);
        
        scanner.close();
    }
}
```

---

## 18. 计算等差数列和

### 解题思路
- 等差数列求和公式：Sn = n × (a1 + an) / 2
- 其中 an = a1 + (n-1) × d
- 或者使用循环累加每个项

### 解题步骤
1. 导入 Scanner 包
2. 创建 Scanner 对象
3. 读取首项、公差、项数
4. 计算末项：an = a1 + (n-1) × d
5. 使用公式计算总和
6. 输出结果
7. 关闭 Scanner

```java
import java.util.Scanner;

public class ArithmeticSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入首项：");
        int a1 = scanner.nextInt();  // 首项
        
        System.out.print("请输入公差：");
        int d = scanner.nextInt();   // 公差
        
        System.out.print("请输入项数：");
        int n = scanner.nextInt();   // 项数
        
        // 计算末项：an = a1 + (n-1) × d
        int an = a1 + (n - 1) * d;
        
        // 求和公式：Sn = n × (a1 + an) / 2
        int sum = n * (a1 + an) / 2;
        
        System.out.println("等差数列的和：" + sum);
        
        scanner.close();
    }
}
```

---

## 19. 星期几判断

### 解题思路
- 使用字符串数组存储星期名称
- 数组索引1-7对应星期一到星期日
- 根据用户输入的数字输出对应星期

### 解题步骤
1. 导入 Scanner 包
2. 创建 Scanner 对象
3. 读取用户输入的数字（1-7）
4. 创建星期名称数组
5. 判断输入是否有效
6. 输出对应的星期名称
7. 关闭 Scanner

```java
import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入数字(1-7)：");
        int day = scanner.nextInt();
        
        // 创建星期名称数组，索引0空出，索引1-7对应星期一到星期日
        String[] days = {"", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
        
        // 判断输入是否在有效范围内
        if (day >= 1 && day <= 7) {
            System.out.println(days[day]);
        } else {
            System.out.println("输入无效");
        }
        
        scanner.close();
    }
}
```

---

## 20. 偶数求和

### 解题思路
- 使用 `for` 循环遍历偶数
- 初始值为2，步长为2
- 累加所有偶数

### 解题步骤
1. 导入 Scanner 包
2. 创建 Scanner 对象
3. 读取整数n
4. 使用 `for` 循环遍历2到n的偶数（步长为2）
5. 累加求和
6. 输出结果
7. 关闭 Scanner

```java
import java.util.Scanner;

public class EvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("请输入整数n：");
        int n = scanner.nextInt();
        
        int sum = 0;
        
        // for循环：从2开始，步长为2，遍历所有偶数
        for (int i = 2; i <= n; i += 2) {
            sum += i;
        }
        
        System.out.println("1到" + n + "之间的偶数和：" + sum);
        
        scanner.close();
    }
}
```
