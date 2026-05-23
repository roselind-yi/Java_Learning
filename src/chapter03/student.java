package chapter03;

/**
 * 自定义学生的结果类
 */
//写在函数里的，是函数内的局部变量（local variable）

public class student {
    //写在函数外的，结构的成员变量（member variable）
    String sno;     //4个字节
    String name;    //4
    Character gender;    //3
    String subject; //4
    Float gpa;      //4
    String hiredate;//4

    public student(//构造函数
            String sno,
            String subject,
            String name,
            char gender,
            float gpa,
            String hiredate){
        //this时特殊指针=指向当前正在创建的对象
        //将=右边的参数，赋值给左边的对象的成员变量。
        this.sno=sno;
        this.name=name;
        this.gender=gender;
        this.gpa=gpa;
        this.hiredate=hiredate;
        this.subject=subject;
        //构造函数的结尾处会自动返回this指针。所以不用写return。
        }

        //再定义一个没有参数的构造函数（防止外部代码报错）
        public student(){}

        //成员函数，没有static
        public void print(){
            System.out.println("=======学生的信息========");
            System.out.println("【学号】"+this.sno);
            System.out.println("【姓名】"+this.name);
            System.out.println("【性别】"+this.gender);
            System.out.println("【绩点】"+this.gpa);
            System.out.println("【专业】"+this.subject);
            System.out.println("【入学日期】"+this.hiredate);
            System.out.println("======================\n");
        }

}
