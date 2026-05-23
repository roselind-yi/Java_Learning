package homework51.base;

import java.util.Scanner;

public class h11计算圆的面积和周长 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入圆的半径：");
        double radius=scanner.nextDouble();
        double area=Math.PI * radius * radius;
        double perimeter=2*Math.PI*radius;
        System.out.printf("圆的面积：%.2f\n",area);
        System.out.printf("圆的周长：%.2f\n",perimeter);

    }
}
