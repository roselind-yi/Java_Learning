package homework51.middle;

import java.util.Scanner;

public class h7冒泡排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入数组长度：");
        int length = scanner.nextInt();

        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.print("请输入第" + (i + 1) + "个元素：");
            array[i] = scanner.nextInt();
        }

        System.out.print("排序前：[");
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + (i < length - 1 ? ", " : "]\n"));
        }

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.print("排序后：[");
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + (i < length - 1 ? ", " : "]"));
        }
        scanner.close();
    }
}
