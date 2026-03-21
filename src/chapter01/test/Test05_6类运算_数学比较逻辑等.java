package chapter01.test;

public class Test05_6类运算_数学比较逻辑等 {
    public static void main(String[] args) {

        // 1. 数学运算符 + - * /
        System.out.println(10 + 3); // 13
        System.out.println("10" + 3); // 103 拼接字符串
        System.out.println(10 / 3);
        System.out.println(10.0 / 3);
        System.out.println(10 % 3); // 取余数 (取模)

        // 2. 比较运算符 (运算结果一定是boolean类型)
        System.out.println(10 > 3);  // 是否大于
        System.out.println(10 >= 3); // 是否大于等于
        System.out.println(10 < 3);  // 是否小于
        System.out.println(10 <= 3); // 是否小于等于
        System.out.println(10 == 3); // 是否等于
        System.out.println(10 != 3); // 是否不等于
        int a = 10;
        int b = 20;
        boolean c = a > b;

        // 3. 逻辑运算符
        //【逻辑运行顺序，先左后右，再整体】【若右被短路，直接用左的结果】
        System.out.println(10 > 3 && 'A' == 65); // && 逻辑与
        System.out.println(10 > 3 || 'A' == 65); // || 逻辑或
        System.out.println(!(10 > 3 || 'A' == 65)); // !() 逻辑非

        //逻辑短路：
        // 1.与短路：左边为false，右边不再运行。
        // && 短路与  &不短路与
        // 2.或短路：左为true，右边不再运行。
        // ||短路或  |不短路或

        //4.自增++ 自减-- 运算符
        //++在前，先把x拷贝给y,然后x自增1

        int x =10;
        //int y=++x;//x=y=11
        int y=x++;//x=11,y=10
        System.out.println(x);
        System.out.println(y);

        //第五类：赋值
        // 4. 赋值运算符
        x = 10;  // 基本赋值
        x += 5;      // 先+后赋值 等同于 x = x + 5
        x -= 5;      // 先-后赋值
        x *= 5;      // 先*后赋值
        x /= 5;      // 先/后赋值
        x %= 5;      // 先取余后赋值

        //第六类：三元运算
        //元？元:元
        System.out.println(x  > 60 ? "great":"come on");
        System.out.println(x  > 60 ? 'A':'B');

    }

}
