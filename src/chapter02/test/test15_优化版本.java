package chapter02.test;

public class test15_优化版本 {
    //矩阵对称性判断函数，true对称，false不对称
    static boolean isJude (int[][] m){
        //先定义一个布尔变量，默认是true
        boolean result=true;
        for(int x=1;x<m.length;x++){//上三角：x<m.length-1;int y=x+1;
            for(int y=0;y<x;y++){//现在左侧是下三角的遍历方式。
                if(m[x][y]!=m[y][x]){
                    System.out.println("找到了不对称的坐标x："+x+"，y:"+y);
                    return false;
                }
            }
        }
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

