package chapter01;

public class Test04 {
    public static void main(String[] args) {
        String name="jam";
        int age =22;
        char gender = '男';
        String subject = "data science";
        double height =180.88;
        // \转义词
        // \t ,转义t,制表
        // \n ,换行
        // println 打印后自动换行。print加\n自动
        System.out.print("姓名\t"+name);
        System.out.print("\n");
        System.out.println("年龄\t"+age);
        System.out.println("性别\t"+gender);
        System.out.println("专业\t"+subject);
        System.out.println();
        System.out.println();
        System.out.println();
    }


}
