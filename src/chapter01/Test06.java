package chapter01;

public class Test06 {
    public static void main(String[] args) {
        //用除法/+取余法%拆解四位数
        int n=6789;
        int a,b,c,d;
        a=n%10;
        b=n%100/10;
        c=n/100%10;//【vital】
        d=n/1000;
        System.out.println(a);//9
        System.out.println(b);//8
        System.out.println(c);//7
        System.out.println(d);//6
    }
}
