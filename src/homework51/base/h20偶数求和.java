package homework51.base;
import java.util.Scanner;
public class h20偶数求和 {
    public static void main(String[] args) {
        System.out.print("请输入整数n：");
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int sum = 0;

        for (int i = 2; i <= n; i += 2) {
            sum += i;
        }
        System.out.println("从1到" + n + "之间的偶数和：" + sum);

        scanner.close();
    }
}
