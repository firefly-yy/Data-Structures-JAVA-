import com.sun.org.apache.xpath.internal.operations.Bool;

public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public  Node(E e) { this(e,null); }

        public Node() { this (null,null); }

        @Override
        public String toString () {return e.toString();}
    }

    // dummyHead 更容易对链表头进行操作
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    //获取总元素个数
    public int getSize() {return size;}

    // 判断链表是否为空
    public Boolean isEmpty() {return size == 0; }

    // 在链表头添加元素e
    public void addFirst(E e) { add(0,e);}
    // 在链表index位置添加元素e（不常用）
    public void add(int index, E e) {

        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

            Node prev = dummyHead;
            for(int i = 0; i < index; ++ i) {
                prev = prev.next;
            }
            prev.next = new Node(e,prev.next);
            size ++;
    }
    // 在链表尾添加元素e
    public void addLast(E e) { add(size, e); }


    // 删
    public E remove(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        Node prev = dummyHead;
        for(int i = 0; i < index; ++i)
            prev = prev.next;


        Node retNode  = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;

        return retNode.e;

    }
    // 删头
    public E removeFirst() {return remove(                                                                                                      0); }
    // 删尾
    public E removeLast() {return remove(size - 1);}

    // 删特定元素
    public void removeElement(E e) {
        Node prev = dummyHead;
        while(prev.next != null) {
            if(prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if(prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }

    }
    // 改
    public void set(int index, E e) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node prev = dummyHead.next;
        for(int i = 0; i < index; ++ i)
             prev = prev.next;

        prev.e = e;
    }

    // 查
    public Boolean contains(E e) {
        Node cur = dummyHead;
        while (cur.next != null) {
            if(cur.next.e == e) {
                return true;
            } else {
                cur = cur.next;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        for(Node cur = dummyHead.next; cur != null; cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");

        return res.toString();
    }
}