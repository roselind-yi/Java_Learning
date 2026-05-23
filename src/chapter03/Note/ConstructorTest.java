package chapter03.homework03;

public class ConstructorTest {
    public static void main(String[] args) {
        System.out.println("=== 构造函数和成员方法测试 ===");

        //================================
        //测试构造函数的各种重载版本
        //================================
        System.out.println("\n1.使用构造函数创建对象：");

        //使用无参构造函数创建对象，然后手动赋值
        Product product1=new Product();
        product1.id=1;
        product1.name="联想笔记本";
        product1.price=8999.99;
        product1.quantity=10;
        product1.description="高性能游戏本";

        //使用成员print方法打印商品信息
        product1.print();

        //使用带2个参数的构造函数
        Product product2=new Product(2,"vivo");
        product2.price=17999.99;
        product2.quantity=5;
        product2.description="6G高性能手机";
        product2.print();

        //使用带3个参数的构造函数
        Product product3=new Product(3,"ipad",3999.98);
        product3.quantity=100;
        product3.description="孩子上网课必备";
        product3.print();

        //使用带5个参数的构造函数
        Product product4=new Product(4,"无线耳机",599.99,90,"降噪无线耳机");
        product4.print();

        System.out.println("\n=== 构造函数和成员方法测试完成 ===");
    }
    //这个类只测试函数和成员方法，不使用静态方法
    //所有的对象创建都通过new Product()构造函数完成
    //所有的打印都通过product.print()成员方法完成
}
