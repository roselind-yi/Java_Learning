package chapter01.homework;

public class HomeWork04_1到100之间所有的偶数之和 {
    public static void main(String[] args) {
    int s=1;
    for(int i=0;i<100;i++){
        if(i%2==0){
            s+=1;
        }
    }
        System.out.println("1-100之间所有的偶数之和为："+s);
    }
}
