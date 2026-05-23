package chapter02.test;

public class test14_二维数组 {
    //矩阵对称性判断函数，true对称，false不对称
    static boolean isJude (int[][] m){
        //先定义一个布尔变量，默认是true
        boolean result=true;
        for(int x=0;x<m.length;x++){
            for(int y=0;y<m[x].length;y++){
                if(m[x][y]!=m[y][x]){
                    System.out.println("找到了不对称的坐标x："+x+"，y:"+y);
                    return false;//这里不需要break，而是直接return。
                    // 因为这里的break只能跳出内层循环，外层循环仍会继续。
                }
            }
        }
        //如果上面的循环没有触发return,那么我们再最后return true。
        return result;
    }
    public static void main(String[] args) {

        //数组中嵌套数组，又称矩阵matrix
        int[][] matrix = {
                {10,20,30,40},
                {20,30,40,5},
                {30,40,50,60},
                {40,50,60,70}
        };
        if(isJude(matrix)){
            System.out.println("矩阵是对称的。");
        }else{
            System.out.println("矩阵不是对称的。");
        }

    }

}

