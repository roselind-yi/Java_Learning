package chapter05;

import java.util.Random;

public class test06 {
    public static void main(String[] args) {
        Random random=new Random();
        int a=random.nextInt();
        System.out.println(a);

        int b=random.nextInt(100);
        System.out.println(b);

        boolean c=random.nextBoolean();
        System.out.println(c);

        double d=random.nextDouble();
        System.out.println(d);

        //特定要求：随机返回一个四位数
        int e=random.nextInt(9000)+1000;
        System.out.println(e);

    }
}
