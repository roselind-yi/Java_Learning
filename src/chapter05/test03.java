package chapter05;

import chapter04.Cat;
import chapter04.Dog;
import chapter04.Pet;

import java.util.Random;

public class test03 {
    public static void main(String[] args) {
        int count=0;
        while (true) {
            System.out.println("第"+(++count)+"次抽取宠物。");
            Pet pet = get();
            if (pet instanceof Dog) {//instansceof 运算符用于判断指向的对象的【原型】。
                System.out.println("抽到了宠物【狗】");
                break;
            } else if (pet instanceof Cat) {
                System.out.println("抽到了宠物【猫】");
            }
        }
    }
    //函数：随机获取一种宠物
    static Pet get(){
        //创建一个随机数生成器
        Random random=new Random();
        int r=random.nextInt(100);//代表边界。0<r<bound
        System.out.println("本次随机次数为："+r);
        Pet pet;
            if(r==99){
                pet= new Dog();
            }else{
                pet= new Cat();
            }
            return pet;


        /*
                //如果担心分支内缺少return
                //分支内不写return
                //分支结束后写一个return
                if(r==99){
                    return new Dog();
                }else{
                    return new Cat();
                }
         */
    }

}
