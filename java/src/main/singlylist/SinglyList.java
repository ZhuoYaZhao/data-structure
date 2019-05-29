package main.singlylist;

public class SinglyList<T> {
    private Node<T> head;//头结点

    public SinglyList() {
        this.head = new Node<T>();
    }

    public SinglyList(T[] values) {
        this();
        Node<T> rear = this.head; //rear存储最后一个节点地址
        for (T value : values) {//
            rear.next = new Node<>(value, null);
            rear = rear.next;
        }
    }
    public boolean isEmpty() {
        return this.head.next == null;
    }
    public T get(int i) {
        Node<T> p = this.head.next;
        for (int j = 0; p != null && j < i; j++) {
            p = p.next;
        }
        return (i > 0 && p != null) ? p.data : null;
    }

    public void set(int i, T x) {
        if (i < 0) {
            throw new java.lang.IndexOutOfBoundsException(i + "");
        }
        if (x == null) {
            throw new java.lang.NullPointerException("x==null");
        }

        Node<T> p = this.head.next;

        if (p == null) {
            throw new java.lang.NullPointerException(this.getClass().getName() + "size:0");

        }

        for (int j = 0; p != null && j < i; j++) {

            p = p.next;
        }
        if (p == null) {
            throw new java.lang.NullPointerException(this.getClass().getName() + " index:" + i);
        }
        p.data = x;

    }

    public int size() {
        int n = 0;
        Node<T> p = this.head.next;
        for (int j = 0; p != null; j++) {
            n++;
            p = p.next;

        }
        return n;
    }

    public Node<T> insert(int i, T x) {
        if (x == null) {
            throw new java.lang.NullPointerException("x==null");

        }
        Node<T> front = this.head;
        for (int j = 0; j < i && front.next != null; j++) {
            front = front.next;

        }
        front.next = new Node<>(x, front.next);
        return front.next;
    }

    public T remove(int i) {
        Node<T> front = this.head;
        for (int j = 0; j < i && front.next != null; j++) {
            front = front.next;
        }
        if (i >= 0 && front.next != null) {
            T old = front.next.data;
            front.next = front.next.next;
            return old;
        }
        return null;

    }

    public void clear() {
        this.head.next = null;
    }

    //TODO Fix Error
    public Node<T> search(T x) {
        if (x == null) {
            throw new java.lang.NullPointerException("x==null");

        }
        Node<T> front;
        while ((front = this.head.next) != null) {

            if (front.data.equals(x)) {
                return front;
            }
            front = front.next;
        }
        return null;
    }

    public boolean contains(T x) {
        return this.search(x) != null;
    }

    //TODO
    public Node<T> insertDifferent(T x) {
        return null;
    }

    public T remove(T key) {
        Node<T> front = this.head;

        while (front.next != null) {
            if (front.next.data.equals(key)) {
                front.next = front.next.next;
                return key;
            }
            front = front.next;
        }
        return null;
    }

    public SinglyList<T> reverse() {

        Node<T> front = this.head;
        Node<T> p = front.next;
        Node<T> succ = p.next;
        front.next=null;
        while (succ.next != null) {

            p.next = front;
            front = p;
            p = succ;
            succ = succ.next;
        }
        this.head.next = p;
        return this;
    }

    public Node<T> insert(T x) {
        return this.insert(Integer.MAX_VALUE, x);
    }


    public Node<T> getHead() {
        return head;
    }


    @Override
    public String toString() {

        String str = this.getClass().getName() + "[";
        for (Node<T> p = this.head.next; p != null; p = p.next) {
            str += p.data.toString();
            if (p.next != null) {
                str += ", ";
            }
        }
        str += "]";
        return str;
    }

}
