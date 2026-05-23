package chapter05;

import chapter04.Cat;
import chapter04.Dog;
import chapter04.Pet;

public class test01 {
    public static void main(String[] args) {
        //定义一个数组，存储多个宠物对象
        //Dog[] dogs= new Dog[5];//单态数组
        //System.out.println(dogs[0]);//运行后输出为：null
        //dogs[0] =new Dog();
        //System.out.println(dogs[0]);//运行后输出为一个地址：chapter04.Dog@1b6d3586

        Pet[] arr=new Pet[5];//多态数组，【继承】是【多态】的【前置条件】
        arr[0]=new Cat();
        arr[1]=new Dog();
        System.out.println(arr[0]);//运行后输出为一个地址：chapter04.Cat@1b6d3586
        System.out.println(arr[1]);//运行后输出为一个地址：chapter04.Dog@4554617c



    }
}
