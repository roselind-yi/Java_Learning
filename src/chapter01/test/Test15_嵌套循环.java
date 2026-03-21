package chapter01.test;

public class Test15_嵌套循环 {
    public static void main(String[] args) {
        //嵌套循环
        System.out.println("A");//不在循环中打印1此
        for (int i=1;i<=5;i++){
            System.out.print("B");//在外层循环中，打印5次
            for(int j=1;j<=6;j++){
                System.out.print("C");//在内层循环中，打印5*6=30次

            }
        }
    }
}
