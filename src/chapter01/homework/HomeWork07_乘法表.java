package chapter01.homework;

public class HomeWork07_乘法表 {
    public static void main(String[] args) {
        for(int i=1;i<10;i++){
            for(int j=1;j<=i;j++){
                int s=i*j;
                System.out.print(i+"*"+j+"="+s+"\t");
            }
            System.out.println();
        }
    }
}
