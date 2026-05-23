package homework51.base;

public class h14输出水仙花 {
    public static void main(String[] args) {
        System.out.println("三位数的水仙花数有：");
        for(int i=100;i<1000;i++){
            int hundreds=i/100;
            int tens=i/10%10;
            int units=i%10;
            if(Math.pow(hundreds,3)+Math.pow(tens,3)+Math.pow(units,3)==i){
                System.out.println(i);
            }
        }
    }
}
