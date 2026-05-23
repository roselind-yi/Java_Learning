package chapter06;

public class test03 {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.addFirst("AAA");
        list.addFirst("BBB");
        list.addFirst("CCC");
        list.addFirst("DDD");
        list.addFirst("EEE");
        list.addFirst("FFF");
        list.addFirst("GGG");
        list.addFirst("HHH");
        list.addFirst("III");
        list.addFirst("JJJ");
        System.out.println(list.get(0));//JJJ
        System.out.println(list.get(9));//AAA
        System.out.println(list.get(3));//GGG
        System.out.println(list.get(7));//CCC
        System.out.println(list.get(10));//抛出异常

        /*
        // 用 addBefore 构建有序链表
        // 先插入第一个元素
        list2.addFirst(3);  // 链表: [3]

        // 在索引0前插入2（3的前面）
        list2.addBefore(0, 2);  // 链表: [2, 3]

        // 在索引0前插入1（2的前面）
        list2.addBefore(0, 1);  // 链表: [1, 2, 3]

        // 在索引2前插入5（3的前面）
        list2.addBefore(2, 5);  // 链表: [1, 2, 5, 3]

        for (int i = 0; i < list2.size; i++) {
            System.out.println("索引 " + i + ": " + list2.get(i));
        }
        */
        list.addBefore(1,"www");
        list.addBefore(2,"whdw");
        System.out.println(list.get(0));//JJJ
        System.out.println(list.get(10));//抛出异常
    }
}
