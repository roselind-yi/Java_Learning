package homework51.base;

public class h7打印九九乘法表 {
    public static void main(String[] args) {
        for(int i=0;i<=9;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+"*"+i+"="+(j*i+"\t"));
            }
            System.out.print("\n");
        }
    }
}
