package chapter03;

public class test01_指针与内存地址 {
    //用自定义的类型定义变量
    public static void main(String[] args) {
        student stu;
        //怎么赋值？->给stu申请内存空间，在赋值。
        //stu不是基本类型，是复杂类型。
        //关键词new用于申请一块新的内存空间。
        //student(是一种特殊函数【构造函数】。
        //stu = 返回内存地址
        //这种能存储内存地址的变量类似于【指针变量】或【引用】
        stu = new student();//4*5+3=23个字节
        System.out.println(stu);
        //赋值存储到stu指向的内存空间中
        //指针。成员变量
        //【.】是寻址符
        stu.name="张飞";
        stu.sno="TD23270202";
        stu.gender='男';
        stu.subject="软件工程";
        stu.gpa=4.5F;
        stu.hiredate="2023-09-09";
        //System.out.println(stu.gpa);

        //定义第二个指针，指向第二个对象
        //student stu2 =new student();

        student stu2=stu;//当把将指针1拷贝给指针2后，输出的地址、名字一致。

        System.out.println(stu == stu2);
        //false：指针的比较。比较内存地址是否一致。
        //true，指向统一地址。

        System.out.println(stu.name);
        System.out.println(stu2.name);//还没写入时，此句输出为null。
        stu2.name="jame";
        System.out.println(stu.name);//但是当我们把这句话写在输出前时，就都会变成最新的名字。
        System.out.println(stu2.name);//此句放于命名后，才能输出对应写入。输出为jame。
        System.out.println(stu == stu2);//就算这里重新赋值姓名，但还是true。

        //-》如果你希望修改stu2的数据不影响stu的数据，应该新建一个对象赋值给stu2。
        //-》如果你希望修改stu2的数据同步影响stu的数据，应该直接拷贝stu的值给stu2。




    }
}
