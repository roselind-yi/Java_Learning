package chapter02.test;

public class test04_实验权限 {
    public static void main(String[] args) {
        test03_类内调用.fee();//记得加上前缀：test03.
        test03_类内调用.wee();//私有拒绝跨类调用。当不写权限时就可以调用，即默认权限（允许跨类但不允许挎包）
    }
}
