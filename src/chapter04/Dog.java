package chapter04;
//class 子类 extend 父类
public class Dog extends Pet{
    //只需要定义特有的成员即可
    String bread;

    public Dog(String nickname, Integer exp, Integer health, Integer level, String bread) {
        super(nickname, exp, health, level, bread);
        this.bread = bread;
    }

    public Dog() {
    }

    public void show(){
        super.show();
        System.out.println("【品种】"+this.bread);
    }
    //dog类特有的
    public void run(){
        System.out.println("正在奔跑。");
    }
    public String getType(){
        return "狗";
    }
}
