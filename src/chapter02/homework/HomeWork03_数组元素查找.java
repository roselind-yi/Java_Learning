package chapter02.homework;

public class HomeWork03_数组元素查找 {

    public static void main(String[] args) {
        int[] arr = {1, 33, 53, 256, 9};
        int index = search(arr, 8);
        if (index == -1) {
            System.out.println("不存在");
        } else {
            System.out.println("存在，其索引为：" + index);
        }
    }

    static int search(int[] arr, int target) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                index = 1;
                break;
            }
        }
        return index;
    }
}