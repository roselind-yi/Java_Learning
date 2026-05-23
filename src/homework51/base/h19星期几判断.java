package homework51.base;

import java.util.Scanner;

public class h19星期几判断 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入数字(1-7)：");
        int day = scanner.nextInt();

        String[] days = {"", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};

        if (day >= 1 && day <= 7) {
            System.out.println(days[day]);
        } else {
            System.out.println("您的输入无效");
        }

        scanner.close();
    }
}
