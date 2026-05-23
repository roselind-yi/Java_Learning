package chapter02.homework;

public class HomeWork09_二维数组求和 {

    public static void main(String[] args) {

        int[][] matrix = {
                {10, 20, 30, 40},
                {20, 30, 40, 50},
                {30, 40, 50, 60}
        };
        int result = sumMatrix(matrix);
        System.out.println("二维数组所有元素的求和后结果：" + result);
    }

    static int sumMatrix(int[][] m) {
        int sum = 0;
        for (int x = 0; x < m.length; x++) {
            for (int y = 0; y < m[x].length; y++) {
                sum += m[x][y];
            }
        }
        return sum;
    }
}
