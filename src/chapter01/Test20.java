package chapter01;

public class Test20 {
    public static void main(String[] args) {
        //找出1-200之间的所有质数
        for (int i = 1; i <= 200; i++) {
            //定义标识符，默认true是质数
            boolean flag = true;
            //内层循环2-i/2
            for (int j = 2; j <= i / 2; j++) {
                //如果i取余j的结果是0，说明i能够被j整除
                if (i % j == 0) {
                    flag = false;
                    //跳出内层循环
                    break;
                }
            }
            //如果标识符为真，则是质数
            if (flag) {
                System.out.println(i + "是质数");
            }
        }
    }
}