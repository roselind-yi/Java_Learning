package homework51.base;

import java.util.Scanner;

public class h12华氏温度转摄氏温度 {
    public static void main(String[] args) {
        System.out.println("请输入华氏温度：");
        Scanner scanner=new Scanner(System.in);
        double fahrenheit=scanner.nextDouble();

        double celsius=(fahrenheit -32) * 5.0 / 9.0;

        System.out.printf("%.1f华氏温度=%.1f摄氏度\n",fahrenheit,celsius);
        scanner.close();
    }
}
