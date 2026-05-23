package chapter06;

import chapter04.Pet;
/*
节点类
泛型机制：Java允许用泛型来定义未知的数据类型
 */
public class Node<T> {
    //节点的前驱指针
    Node pre;
    //节点的后驱指针
    Node next;
    //节点的数据域，可以存储任意类型的对象
    T item;
    Node(){}

    Node(Node<T> pre,Node<T> next,T item){
        this.pre=pre;
        this.next=next;
        this.item=item;
    }
}
