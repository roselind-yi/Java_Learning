package chapter04;

//类名用大写！
public class test01 {
    //主函数一般写在测试类中
    //将“阿福”存储到dog对象中时，
    //Java编译器会先检查Dog类中是否有nickname的定义，如果没有，向上检查其父类中是否有定义
    //若父类也无，则会爆红，无法通过编译
    //
    public static void main(String[] args) {
        Dog dog=new Dog("阿福",1,1,1,"拉布拉多");
        //dog.nickname="阿福";
        //dog.exp=100;
        //dog.health=1;
        //dog.level=1;
        //dog.bread="拉不拉多";
        dog.show();
    }

}
