package chapter05;

import chapter04.Cat;
import chapter04.Dog;
import chapter04.Pet;

public class test04 {
    public static void main(String[] args) {
        /*
        Dog dog=new Dog();
        Cat cat=new Cat();

        dog.show();
        dog.run();
        dog.sleep();
        cat.show();
        cat.sleep();
        cat.run();
        */

        Pet pet =new Dog();
        pet.show();
        //pet.run();//报错
        Dog dog=(Dog) pet;//向下转型实现调用，没有新建对象。
        dog.run();

        ((Dog)pet).run();//上面两句可以合并为一步
    }
}
