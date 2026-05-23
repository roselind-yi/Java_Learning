package chapter04.homework;

public class HDD extends Computer{
    String capacity;//内存容量

    public HDD() {
    }

    public HDD(String brand, Integer price, String size, Integer releaseYear, Float weight, String capacity) {
        super(brand, price, size, releaseYear, weight);
        this.capacity = capacity;
    }

    public void show(){
        super.show();
        System.out.println("【内存容量(如：512GB、1TB)】"+this.capacity);
    }
    public String getType(){
        return "HDD";
    }
}
