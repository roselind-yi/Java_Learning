package chapter06;
/*
双向链表类
编写管理节点的代码
 */
public class MyLinkedList<T> {
    //成员1：头部节点
    Node<T> first;
    //成员2：尾部节点
    Node<T> last;
    //成员3：节点计数器
    int size;

    /**
     * 功能函数一【头插算法】
     * e 添加到头部节点中的对象
     */
    public void addFirst(T e) {
        //1.创建一个新的节点对象【前面指向null，后面指向null，数据域存储e】
        Node<T> newNode = new Node(null, first, e);
        //2.判断first是否为空
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            first.pre = newNode;
            first = newNode;
        }
        //如果first 是null，则说明是第一次插入节点。反则，则为第n(n>1)次插入
        //3.计数器加1
        size++;
    }

    //【尾插】
    public void addLast(T e) {
        Node<T> newNode = new Node(last, null, e);
        if (last == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    /**
     * 功能函数三：【根据指定的index查找节点中的对象】
     *
     * @param index 节点的索引【假】只是节点的逻辑序号
     * @return 指定节点中的数据域中存储的对象
     */
    public T get(int index) {
        //1. index合法性判断
        if (index < 0 || index >= size) {
            //抛出异常
            throw new RuntimeException("发生index越界。");
        }
        //2.查找节点
        Node<T> target;//局部变量target用于记录目标节点的地址
        //【方案一】first->next->next->next
        //【方案二】last->pre->pre->pre
        if (index < size >> 1) {
            //index在左半段,让目标节点从头部开始找
            target = first;
            for (int i = 0; i < index; i++) {
                target = target.next;
            }
        } else {
            //index在右半段，让目标节点从尾部开始找
            target = last;
            for (int i = size - 1; i > index; i--) {
                target = target.pre;
            }
        }
        return target.item;
    }

    /**
     * 前插算法：在index位置的节点 前面 插入一个新元素
     *
     * @param index 要插入到哪个节点前面
     * @param e     要插入的数据
     */

//公有属性 void 函数名(函数类型){
    public void addBefore(int index, T e) {
        //1.索引合法性校验
        if (index < 0 || index > size) {
            throw new RuntimeException("索引越界，合法范围：0~" + size);
        }
//2.如果插在最前面->直接调用头插
        if (index == 0) {
            addFirst(e);
            return;
        }

        // 新增：如果插在最后面->直接调用尾插
        if (index == size) {
            addLast(e);
            return;
        }

//3.找到index位置的目标节点（新节点要插在它前面）
//目标节点
        Node<T> target;
//判断位置
        if (index < size >> 1) {
            //index在左半段，让目标节点从头部开始找
            target = first;
            //再写个循环
            for (int i = 0; i < index; i++) {
                target = target.next;
            }
        } else {//else...
//index在右半段，让目标节点从尾部开始找
//再写个循环
            target = last;
            for (int i = size - 1; i > index; i--) {
                target = target.pre;
            }
        }

//4.创建新节点：前驱=target.pre，后继=target
        Node<T> newNode = new Node<>(target.pre, target, e);
//5.让target原来的前驱节点 指向新节点
        target.pre.next = newNode;
//6.让target的前驱 变成新节点
        target.pre = newNode;
//7.长度+1
        size++;
    }
}


















