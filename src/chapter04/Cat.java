package chapter04;

public class Cat extends Pet{
    String color;

    public Cat(String nickname, Integer exp, Integer health, Integer level, String color) {
        super(nickname, exp, health, level, color);
        this.color = color;
    }

    public Cat() {
    }

    public void show(){
        super.show();
        System.out.println("【颜色】"+this.color);
    }
    //cat类特有的方法
    public void sleep(){
        System.out.println("正在睡觉。");
    }

    public String getType(){
        return "猫";
    }
}
