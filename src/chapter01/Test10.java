package chapter01;

import java.util.Scanner;

public class Test10 {
    public static void main(String[] args) {
        //模拟用户登录程序【嵌套分支】
        String sysname ="admin";//acount
        String syspass ="12345";//password

        Scanner sc =new Scanner(System.in);
        System.out.println("put in your acount:");
        String name=sc.next();
        System.out.println("put in your password:");
        String pass =sc.next();
        //字符串之间不能用==。用equals，外层分支判断账号、内层密码
        if (name.equals(sysname)){//外
            if(pass.equals(syspass)){//内
                //路径1
                System.out.println("welcome!");
            }else{
                //路径2
                System.out.println("密码错误");
            }
        }else {
            //路径3
            System.out.println("账号错误");
        }
    }
}
