package homework51.middle;
import java.util.Scanner;
public class h9字符串反转 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入一个字符串：");
        String str = scanner.nextLine();

        char[] chars = str.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        String reversed = new String(chars);

        System.out.println("反转后的字符串：" + reversed);

        scanner.close();
    }
}
