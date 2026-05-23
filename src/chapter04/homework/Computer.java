package chapter04.homework;

public class Computer {
    String brand;//品牌
    Integer price;//价格
    String size;//尺寸
    Integer releaseYear;//发售年份
    Float weight;//重量


    public Computer() {
    }

    public Computer(String brand, Integer price, String size, Integer releaseYear, Float weight) {
        this.brand = brand;
        this.price = price;
        this.size = size;
        this.releaseYear = releaseYear;
        this.weight = weight;
    }

    public void show(){
        System.out.println("【====电脑"+getType()+"的信息====】");
        System.out.println("【品牌】" + this.brand);
        System.out.println("【价格】" + this.price);
        System.out.println("【尺寸(如：16寸、14寸)】" + this.size);
        System.out.println("【发售年份】" + this.releaseYear);
        System.out.println("【重量（kg）】" + this.weight);
    }
    public String getType(){
        return "";
    }
}
