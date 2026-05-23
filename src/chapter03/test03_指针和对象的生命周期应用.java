package chapter03;

//main函数调用create函数，传递了6个参数给create函数
//create函数中创建指针=创建对象，将参数存储到指针指向的对象中，并返回指针stu
//

public class test03_指针和对象的生命周期应用 {
    public static void main(String[] args) {
        student stu=createstudent(
                "td1234",
                "软件工程",
                "张飞",
                '男',
                4.45F,
                "20230909"
        );
        //调用打印函数，拷贝给stu
        printstudent(stu);

        student stu2=createstudent(
                "td34",
                "计算机",
                "刘备",
                '男',
                4.45F,
                "20230909"
        );
        printstudent(stu2);

        //creat函数返回一个指针，print函数入参一个指针。
        // 当返回值类型时student和输出类型一致时，可以直接用create函数的返回值作为print函数的入参。
        //这种情况适用于后续不再使用stu3指针
        printstudent(createstudent("td4",
                "通工",
                "诸葛亮",
                '男',
                4.45F,
                "20230909")
        );

    }
    static student createstudent(//创建指针=创建对象
            String sno,
            String subject,
            String name,
            char gender,
            float gpa,
            String hiredate){
        /*
         * 创建学生的函数
         * sno,name,gender,gpa,subject.hiredate
         */
        student stu=new student();
        //指针变量.成员变量=参数。//写入到对象
        stu.name=name;
        stu.sno=sno;
        stu.gender=gender;
        stu.subject=subject;
        stu.gpa=gpa;
        stu.hiredate=hiredate;
        return stu;
    }

    /**
     * 打印学生信息
     *
     * @param stu 参数是一个学生指针变量，这里是一个指针参数
     */
    static void printstudent (student stu){
        System.out.println("=======学生的信息========");
        System.out.println("【学号】"+stu.sno);
        System.out.println("【姓名】"+stu.name);
        System.out.println("【性别】"+stu.gender);
        System.out.println("【绩点】"+stu.gpa);
        System.out.println("【专业】"+stu.subject);
        System.out.println("【入学日期】"+stu.hiredate);
        System.out.println("======================\n");
    }
}
