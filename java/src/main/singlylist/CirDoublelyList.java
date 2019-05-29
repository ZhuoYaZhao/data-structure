package main.singlylist;

import java.util.Objects;

public class CirDoublelyList<T> {
    DoubleNode<T> head;

    public CirDoublelyList() {
        this.head = new DoubleNode<T>();
        this.head.prev = this.head;
        this.head.next = this.head;
    }

    public boolean isEmpty() {
        return this.head.next == this.head;
    }

    public CirDoublelyList(T[] values) {
        this();
        for (int i = 0; i < values.length; i++) {
            this.insert(values[i]);
        }

    }

    public CirDoublelyList(SinglyList<? extends T> list) {
        this();
        if (list == null) {
            throw new java.lang.NullPointerException("x == null");
        }
        Node<? extends T> front = list.getHead();
        while (front.next != null) {
            front = front.next;
            T data = front.data;
            this.insert(front.data);
        }
    }

    public void clear() {

        this.head.next = this.head;
        this.head.prev = this.head;
    }

    public CirDoublelyList(CirDoublelyList<? extends T> list) {
        this();
        if (list == null) {
            throw new java.lang.NullPointerException("list == null");
        }
        DoubleNode<? extends T> front = list.head;
        while (front.next != list.head) {
            front = front.next;
            this.insert(front.data);
        }
    }

    public DoubleNode<T> insert(int i, T x) {

        if (x == null) {
            throw new java.lang.NullPointerException("x == null");
        }
        DoubleNode<T> front = this.head;

        for (int j = 0; j < i && front.next != this.head; j++) { //i-1
            front = front.next;
        }
        DoubleNode<T> tDoubleNode = new DoubleNode<T>(x, front, front.next); // i
        front.next.prev = tDoubleNode;
        front.next = tDoubleNode;
        return tDoubleNode;
    }

    public DoubleNode<T> insert(T x) {
        if (x == null) {
            throw new java.lang.NullPointerException("x == null");
        }

        DoubleNode<T> node = new DoubleNode<>(x, this.head.prev, this.head);
        this.head.prev.next = node;
        this.head.prev = node;

        return node;
    }
    public DoubleNode<T> insertDifferent(T x){

        if (this.search(x)==null) {
           return this.insert(x);
        }
        return  null;

    }

    public int size() {
        int i = 0;
        DoubleNode<T> front = this.head;
        for (i = 0; front.next != this.head; i++) { //i-1
            front = front.next;
        }
        return i;
    }

    public T get(int i) {
        DoubleNode<T> front = this.head.next;
        for (int j = 0; front != this.head && j < i; j++) {
            front = front.next;
        }
        return (i >= 0) ? front.data : null;

    }
    public void addAll(CirDoublelyList<T> list){

        if (list==this) {
            list = new CirDoublelyList<>(list);
        }
        DoubleNode<T> tail1 = this.head.prev;//尾部节点
        DoubleNode<T> tail2 = list.head.prev;//尾部节点

        tail1.next = list.head.next;
        list.head.next.prev = tail1;
        tail2.next = this.head;
        tail1 = tail2;

    }

    public DoubleNode<T> search(T key) {
        if (key == null) {
            throw new java.lang.NullPointerException("key==null");
        }
        DoubleNode<T> front = this.head.next;
        while (front != this.head) {
            if (front.data.equals(key)) {
                return front;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            throw new java.lang.NullPointerException("obj==null");
        }

        if (obj instanceof CirDoublelyList) {
            CirDoublelyList<T> obj1 = (CirDoublelyList<T>) obj;
            if (obj1.hashCode() != this.hashCode()) {
                return false;
            }
            DoubleNode<T> front1 = this.head.next;
            DoubleNode<T> front2 = obj1.head.next;
            while (front1 != this.head && front2 != obj1.head) {
                if (!front1.data.equals(front2.data)) {
                    return false;
                }
            }
        }
        return true;

    }

    @Override
    public int hashCode() {
        return Objects.hash(head);
    }

    public void set(int i, T data) {

        if (i < 0) {
            throw new java.lang.IndexOutOfBoundsException(i + "");
        }
        if (data == null) {
            throw new java.lang.NullPointerException("x==null");
        }

        DoubleNode<T> front = this.head.next;
        for (int j = 0; j < i && front != this.head; j++) {
            front = front.next;
        }
        if (front == null) {
            throw new java.lang.NullPointerException(this.getClass().getName() + " index:" + i);
        }
        front.data = data;

    }

    public DoubleNode<T> remove(int i) {


        DoubleNode<T> front = this.head;
        int j = 0;
        for (j = 0; j <= i && front.next.data != null; j++) { // i 节点
            front = front.next;
        }
        if (j - 1 == i && i >= 0) {

            DoubleNode<T> old = front; //i 节点
            front.next.prev = front.prev;
            front.prev.next = front.next;

            return old;
        }
        return null;
    }

    @Override
    public String toString() {
        DoubleNode<T> front = this.head;
        String str = this.getClass().getName() + "[";
        while ((front = front.next).data != null) {
            str += front.data.toString() + "";
            if (front.next.data != null) {
                str += ", ";
            }
        }
        str += "]";
        return str;
    }

}


