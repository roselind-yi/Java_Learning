package chapter01.test;

//静态导入，包名.类名.*(*表示该类的所有函数)
//import static chapter02.test03.*;
//导入包名.*（*表示该包中的所有类）
//import chapter02.*;

//1.
import chapter02.test.test03_类内调用;

public class test22_跨类包练习 {
    public static void main(String[] args) {
        //1.
        test03_类内调用.fee();

        //2.
        // chapter02.test03.fee();//记得加上前缀：test03.

        //test03.wee();//wee()' 在 'chapter02.test03' 中不为 public。无法从外部软件包访问
        //chapter02.test03.wee();//私有拒绝跨类调用。当不写权限时就可以调用，即默认权限（允许跨类但不允许挎包）
    }
}
