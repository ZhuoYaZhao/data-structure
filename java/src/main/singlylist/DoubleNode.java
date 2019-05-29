package main.singlylist;

public class DoubleNode<T> {
    public T data;
    public DoubleNode<T> prev, next;

    public DoubleNode(T data, DoubleNode<T> prev, DoubleNode<T> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public DoubleNode(T data) {
        this(data, null, null);
    }

    public DoubleNode() {
        this(null, null, null);
    }

    @Override
    public String toString() {
        return data.toString();

    }
}
