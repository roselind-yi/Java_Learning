package homework51.advance;

import java.util.Random;
import java.util.Scanner;

public class h3猜数字游戏升级版 {
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