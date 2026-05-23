package chapter05;

import chapter04.Cat;
import chapter04.Dog;
import chapter04.Pet;

//形参的类型决定实参可以是什么类型
//实参的类型决定了运行时调用哪个子类的功能

public class test02 {
    public static void main(String[] args) {
        foo(new Dog());//必须传递【实际参数】
        foo(new Cat());
    }
    static void foo(Pet pet){//形式参数
        //此处调用的是哪个类的show方法？
        //编译时不确定
        //运行时才确定：由运行时传递过来的实参类型决定
        pet.show();

    }
}
