package homework51.base;
import java.util.Random;
import java.util.Scanner;

public class h9猜数字游戏 {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("这是一个猜数字游戏。");
        System.out.println("请输入一个你猜的的数字：（1-100之间选择）");
        Scanner scanner = new Scanner(System.in);

        int target = random.nextInt(100) + 1;
        int guess;

        while (true) {
            guess = scanner.nextInt();
            if (guess > target) {
                System.out.println("太大了噢。");
            } else if (guess < target) {
                System.out.println("太小了噢。");
            } else {
                System.out.println("真棒！你猜对啦。");
                break;
            }
        }

        scanner.close();
    }
}

