package homework51.middle;
import java.util.Random;

public class h10生成验证码 {
    public static void main(String[] args) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@##￥%%……&*（）——+=-0？“{}{:'.,/";

        Random random = new Random();

        StringBuilder code = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(chars.length());
            code.append(chars.charAt(index));
        }

        System.out.println("生成的验证码：" + code);
    }
}
