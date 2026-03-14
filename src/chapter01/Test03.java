package chapter01;
//
public class Test03 {
    public static void main(String[] args) {
        //类型转换的4种情况：（大到小需要加强制，显式转换）(小到大直接auto，隐式转换)
        //situation1：整数<=>整数       byte < short < int <long
        //situation2：整数<=>浮点数     整数 < 浮点数
        //situation3：浮点数<=>浮点数    float < double
        //situation4：整数<=>单字符      short < char < int

        int a =10;
        double b=a;//auto change
        System.out.println(a);//10
        System.out.println(b);//10.0

        double c=9.8;
        //int d=c;从double到int是不行的，但可通过强制类型转换（int），但精度会丢失（小数部分）
        int d =(int)c;
        System.out.println(c);//9.8
        System.out.println(d);//9

        int e=128;
        //byte f=e;无法存入，e的字节为4.但f为1,故强制后有三个字节会丢失，但对e无影响，此过程为copy。
        byte f=(byte)e;//强制
        System.out.println(e);
        System.out.println(f);//-128；若e为127，则此处输出为-127

        char h='A';
        //byte k = h;short s=h;直接转换行不通；
        int p=h;//行得通，说明空间大小：int>char>short>byte

    }
}
