package homework51.advance;

import java.util.Scanner;

public class h5成绩统计分析系统 {
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