package chapter01.test;
//代码必须写在函数里面
public class Test02_数据类型 {
    public static void main(String[] args) {
        //数据类型
        //计算机最小存储单位bit：比特 0或 1（一位就是表示一个0正或一个1负）
        //计算机最小存储单元byte：1个字节=8个比特

        //01：整数类型,字节（占用空间的大小）
        byte a =-128 ;//单字节整数 -2^7 - 2^7-1   -128-127
        short b=999;//双字节整数 -2^15 - 2^15-1   -32768 -32767
        int c =99999;//四字节整数 -2^31 - 2^31-1  -21亿-21亿
        long d=9999999;//八字节整数 -2^63 -2^63-1

        //第二类：浮点数（整数＋浮点 来表述小数）
        float e =3.1415926391731F; //单精度浮点数（4个字节）【注意最后加个F（大小写均可），不加的话该直接量用4个字节存】
        System.out.println(e);//最大精度5-6位
        double f = 3.141592617382467412;//双精度浮点数（8个字节）
        System.out.println(f);//最大精度15-16位

        //第三类：布尔Boolean类型（true,false）-》一个字节
        boolean h =true;
        boolean z =false;

        //第四类：单字符类型char【计算机不能直接存储符号，其存储原理是存储符号的编码，而符号的编码是一个数字。】
        char j = 'A';//英文字符需要1个字节
        char k = '以';//中文则需要2、3、4个字节存储
        System.out.println(j);//打印字符'A'
        System.out.println(k);//打印字符'以'
        System.out.println((int)j);//打印字符'A'的编码
        System.out.println((int)k);//打印字符'以'的编码

        //第五类：字符串类型String，双引号，存储一串字符
        String m = "hello";

        //写一个循环，字符串，本循环输出为各种很好玩的表情或符号
        for(int i =1;i<100000;i++){
            System.out.println(i + ":" + (char)i);
        }

        //基本基础类型一共是八个，byte,short,long,char
        //float,double
        // boolean
        // char

    }

}
