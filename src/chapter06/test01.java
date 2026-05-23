package chapter06;

import chapter04.Dog;

public class test01 {
    public static void main(String[] args) {
        //在外部测试双向链表的功能
        //使用的时候，写清楚T到底是什么类型
        //若T=Dog，则在这个用例上，所有的T都是Dog
        //T=String，----------，---------String
        //T=Integer，----------，---------Integer

        //T不可以是基本类型。
        MyLinkedList<String> list=new MyLinkedList();
        list.addFirst("张飞");
        list.addFirst("关羽");
        list.addFirst("貂蝉");
        list.addFirst("老子");
        list.addFirst("孔子");
    }
}
