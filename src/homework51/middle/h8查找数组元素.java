package homework51.middle;
import java.util.Scanner;

public class h8查找数组元素 {
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

        int index = -1;

        for (int i = 0; i < length; i++) {
            if (array[i] == target) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            System.out.println("目标值" + target + "在数组中的索引是：" + index);
        } else {
            System.out.println("目标值" + target + "不在数组中");
        }
        scanner.close();
    }
}
