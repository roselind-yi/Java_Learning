package chapter04.homework;

public class Test01 {
    public static void main(String[] args) {
        CPU cpu=new CPU("联想",5999,"16寸",2025, 2.7F,8);
        cpu.show();

        HDD hdd=new HDD("Mac",9999,"15寸",2025,1.35F,"1TB");
        hdd.show();

    }
}
