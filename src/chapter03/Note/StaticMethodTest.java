package chapter03.homework03;

/**
 * 静态方法测试类 - 专门测试静态方法create 和 print
 */

public class StaticMethodTest {
    public static void main(String[] args) {
        System.out.println("=== 静态方法测试 ===");

        //=====================================
        //测试静态create方法的各种重载版本
        //=====================================
        System.out.println("\n1.使用静态create方法创建对象：");

        //使用create()方法创建空对象
        Product product1=Product.create();
        product1.id=1;
        product1.name="智能手表";
        product1.price=1999.98;
        product1.quantity=40;
        product1.description="多功能AI手表";

        //使用静态print方法打印商品信息
        Product.print(product1);

        //使用create(Integer,String)方法
        Product product2=Product.create(2,"蓝牙音响");
        product2.price=299.98;
        product2.quantity=30;
        product2.description="高品质蓝牙音响";
        Product.print(product2);

        //使用create(Integer,String,Double)方法
        Product product3=Product.create(3,"游戏手柄",3999.00);
        product3.quantity=20;
        product3.description="无线游戏AI可视化智能手柄";
        Product.print(product3);

        //使用create(Integer,String,Double,Interger,String)方法
        Product product4=Product.create(4,"VR",19999.99,5,"AI可触发交互式眼镜");
        Product.print(product4);

        System.out.println("\n=== 静态方法测试完成 ===");
    }
    //这个类只测试静态方法，不使用构造函数和成员方法
    //所有的对象创建都通过Produtc.create()方法完成
    //所有的打印都通过Product.print()静态方法完成
}
