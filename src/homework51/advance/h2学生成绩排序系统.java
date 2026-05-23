package homework51.advance;

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

public class h2学生成绩排序系统 {
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