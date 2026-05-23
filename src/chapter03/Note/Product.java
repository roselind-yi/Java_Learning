package chapter03.homework03;

/**
 * 商品类，用于表示一个商品对象
 * 这是一个完整的类定义，包含商品的各种属性
 */
public class Product {
    //成员变量定义（使用包装类型）
    //Integer 对应基本类型int，表示商品编号
    Integer id;

    //String 表示商品名称
    String name;

    //Double 表示商品价格
    Double price;

    //Integer 对应基本类型int，表示商品数量
    Integer quantity;

    //String表示商品描述信息
    String description;

    /**
     * 1.什么是包装类型？
     * 包装类型就是基本类型的“包装版”，比如Integer是int的包装类型，Double是double的包装类型
     *
     * 2.为什么要用包装类型？
     * 包装类型可以为null（表示没有值），而基本类型有默认值（比如int默认为0）
     *
     * 3.成员变量没有权限修饰符时，默认是包访问权限，同一个包下的类可以访问
     */

    /**
     * 无参构造函数 - 创建空对象
     * 当使用new Product()时调用此构造函数
     */
    public Product() {
        //无参构造函数可以为空，也可以在这里初始化默认值
    }

    /**
     * 构造函数 - 初始化id和name
     */
    public Product(Integer id, String name) {
        //this.id 表示当前对象的id成员变量
        //id 表示传入的参数
        this.id = id;
        this.name = name;
    }

    /**
     * 构造函数 - 初始化id、name和price
     */
    public Product(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(Integer id, String name, Double price, Integer quantity, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }
    //什么时构造函数？构造函数是创建对象时自动调用的方法，用于初始化对象
    //特点：方法名必须与类名相同，没有返回类型
    //this关键字是什么？this代表当前对象，用于区分成员变量和参数


    /**
     * 静态工厂方法 - 创建空的商品对象
     * 不需要任何参数，返回一个新创建的空对象
     */
    public static Product create() {
        //使用new关键字创建一个新的project对象
        //new Project()会调用无参构造函数
        return new Product();
    }

    /**
     * 静态工厂方法 - 创建并初始化id和name的商品对象
     * id 商品编号
     * name 商品名称
     */
    public static Product create(Integer id, String name) {
        //第一步：创建空对象
        Product product = new Product();

        //第二步： 给对象的成员变量赋值
        product.id = id;
        product.name = name;

        //第三步：返回创建好的对象
        return product;
    }

    /**
     * 静态工厂方法 - 创建并初始化id、name、price的商品对象
     * price 商品价格
     */
    public static Product create(Integer id, String name, Double price) {
        Product product = new Product();
        product.id = id;
        product.name = name;
        product.price = price;
        return product;
    }

    /**
     * 静态工厂方法 - 创建并初始化所有成员变量的商品对象
     */
    public static Product create(Integer id, String name, Double price, Integer quantity, String description) {
        Product product = new Product();
        product.id = id;
        product.name = name;
        product.price = price;
        product.quantity = quantity;
        product.description = description;

        return product;
    }

/**
 * 1.什么是静态方法？
 *静态方法可以直接通过类名调用，不需要先创建对象
 *
 * 2.什么是方法重载？
 * 方法名相同，但参数列表（参数类型、数量、顺序）不同的方法
 *
 * 3.为什么要重载？
 * 为了提供不同的创建方法，方便用户根据需要选择。
 */

    /**
     * 静态打印方法，打印商品的详细信息
     * product要打印的商品对象
     */

    public static void print(Product product) {
        //检查对象是否为空，避免空指针异常
        if (product != null) {
            //打印商品信息，使用中文标签更易读
            System.out.println("\n=====商品信息====");
            System.out.println("[ID]" + product.id);
            System.out.println("[名称]" + product.name);
            System.out.println("[价格]" + product.price);
            System.out.println("[数量]" + product.quantity);
            System.out.println("[描述]" + product.description);
            System.out.println("====================");
        } else {
            //如果对象为空，打印提示信息
            System.out.println("商品对象为空");
        }
    }

    /**
     * 为什么要检查null?
     * 如果传入的对象是null(没有创建成功)，直接访问它的成员变量会导致程序崩溃
     */
    public void print() {
        /**
         * 在成员方法中，this代表当前对象
         * 可以直接使用this访问所有成员变量
         */
        System.out.println("\n=====商品信息=====");
        System.out.println("[ID]" + this.id);
        System.out.println("[名称]" + this.name);
        System.out.println("[价格]" + this.price);
        System.out.println("[数量]" + this.quantity);
        System.out.println("[描述]" + this.description);
        System.out.println("====================");
    }
    /**
     * 成员方法和静态方法的区别：
     * 成员：需要先创建对象，通过对象调用（如product.print()）
     * 静态：直接通过类名调用（如Product.print(product)）
     * this 关键字在成员方法中表示当前对象，可以省略（如this.id和id效果一样）
     */
}





