package chapter04.homework;

public class CPU extends Computer{
    Integer coreNum;//核心数量

    public CPU() {
    }

    public CPU(String brand, Integer price, String size, Integer releaseYear, Float weight, Integer coreNum) {
        super(brand, price, size, releaseYear, weight);
        this.coreNum = coreNum;
    }

    public void show(){
        super.show();
        System.out.println("【核心数量】"+this.coreNum);
    }
    public String getType(){
        return "CPU";
    }
}
