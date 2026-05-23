package chapter04;

public class Test02 {
    public static void main(String[] args) {
        Cat cat=new Cat();//不能直接带参构造：
        cat.nickname="喵呜";
        cat.health=1;
        cat.level=1;
        cat.exp=1;
        cat.color="红色";
        cat.show();
    }

}
