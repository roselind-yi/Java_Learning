package chapter06;

public class test04 {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList();
        list.addFirst("aaa");
        list.addFirst("bbb");
        list.addFirst("ccc");
        list.addFirst("ddd");
        list.addFirst("eee");
        list.addFirst("fff");
        list.addFirst("ggg");
        list.addFirst("hhh");
        list.addFirst("iii");
        list.addFirst("jjj");
        list.addBefore(8,"mmm");  // 插到8位置
        System.out.println(list.get(0));  // 返回"jjj"
        System.out.println(list.get(9));  // 返回"bbb"
        System.out.println(list.get(3));  // 返回"ggg"
        System.out.println(list.get(7));  // 返回"ccc"
        // System.out.println(list.get(11));  // 抛异常
        list.addBefore(12,"www");  // 抛异常
        System.out.println(list.get(8));
    }
}