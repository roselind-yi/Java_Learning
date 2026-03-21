package chapter02.test;

public class test03_类内调用 {
    public static void fee() {
        System.out.println("执行fee");
    }

    public static void main(String[] args) {//【【主函数不能私有，因其必须被外部调用！】】
        System.out.println("执行main");
        fee();
        wee();

    }
     static void wee() {
        System.out.println("执行wee");

    }
}
