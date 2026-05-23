package chapter03;

public class test02_深度理解地址是否相同 {
    public static void main(String[] args) {
        student stu=new student();
        student stu2=new student();
        stu.name="123";
        stu2.name="456";
        System.out.println(stu);
        System.out.println(stu2);
        System.out.println(stu == stu2);
        System.out.println(stu.name);//123
        System.out.println(stu2.name);//456

    }
}
