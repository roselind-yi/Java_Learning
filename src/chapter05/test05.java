package chapter05;

import chapter04.Cat;
import chapter04.Dog;
import chapter04.Pet;

public class test05 {
    public static void main(String[] args) {
        /*
        Pet pet=new Dog();
        Cat cat=(Cat) pet;
        报错。编译时不显示，但是运行时就报错了。
        Exception in thread "main" java.lang.ClassCastException: chapter04.Dog cannot be cast to chapter04.Cat
	at chapter05.test05.main(test05.java:10)
    进程已结束，退出代码为 1
        cat.show();
        cat.sleep();
         */
    }
    static void foo(Pet pet){
        if(pet instanceof Cat){
            Cat cat=(Cat) pet;

        }
        if (pet instanceof  Dog){
            Dog dog=(Dog) pet;


        }

    }
}
