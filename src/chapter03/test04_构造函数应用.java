package chapter03;

public class test04_构造函数应用 {
    public static void main(String[] args) {
        //用没有参数的构造函数（空参函数）构造学生
        //stu=this;
        student stu=new student();
        //用有参数的构造函数构造学生
        //stu=this;
        student stu2=new student(
                "td4",
                "通工",
                "诸葛亮",
                '男',
                4.45F,
                "20230909"
        );
        //打印,指针.函数名() 来调用函数
        stu.print();//函数内的this=stu
        stu2.print();//函数内的this=stu2
    }
}
