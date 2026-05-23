package homework51.base;

import java.util.Scanner;

public class h5计算BMI指数 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("请输入身高（米）：");
        double height=scanner.nextDouble();
        System.out.println("请输入体重（千克）：");
        double weight=scanner.nextDouble();

        double bmi=weight/(height*height);
        System.out.printf("您的BMI指数是：%.2f\n", bmi);

        String status;
        if(bmi<18.5) {
            status = "偏瘦";
        }else if(bmi<24) {
            status = "正常";
        }else if(bmi<28){
            status="超重";
        }else{
            status="肥胖";
        }

        System.out.println("您的体型为："+status);
    }
}