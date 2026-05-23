package chapter06;

public class test02 {
    public static void main(String[] args) {
        //在外部测试双向链表的功能
        //使用的时候，写清楚T到底是什么类型
        //若T=Dog，则在这个用例上，所有的T都是Dog
        //T=String，----------，---------String
        //T=Integer，----------，---------Integer

        //T不可以是基本类型。
        MyLinkedList<Integer> list=new MyLinkedList();
        list.addLast(2);
        list.addLast(5);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);
    }
}
