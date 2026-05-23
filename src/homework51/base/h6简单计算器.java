package homework51.base;

import java.util.Scanner;

public class h6简单计算器 {
    public static void main(String[] args) {
        System.out.println("这里在模拟一个简单的计算器。");
        Scanner scanner=new Scanner(System.in);

        System.out.print("请输入第一个数：");
        double num1= scanner.nextDouble();

        //这里不会，看了解析！
        System.out.println("请输入运算符：");
        char op=scanner.next().charAt(0);

        System.out.print("请输入第二个数：");
        double num2=scanner.nextDouble();

        double result =0;
        boolean valid =true;

        switch(op){
            case '+':
                result=num1+num2;
                break;
            case '-':
                result=num1-num2;
                break;
            case '*':
                result=num1*num2;
                break;
            case '/':
                if(num2!=0) {
                    result = num1 / num2;
                }else{
                    System.out.println("除数不能为零！");
                    valid=false;
                }
                break;
            default:
                System.out.println("无效的运算符！");
                valid=false;
        }
        if(valid){
            System.out.println(num1+" "+op+" "+num2+"="+result);
        }
        scanner.close();//这里还学到一个释放内存的习惯。


    }
}
