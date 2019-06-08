package main.singlylist;

public class SortedCirDoubleList<T extends Comparable<? super T>> extends CirDoublelyList<T> {
    public SortedCirDoubleList() {
        super();
    }

    public SortedCirDoubleList(T[] values) {
        super();
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = values.length - 1; j > i; j--) {

                if (values[i].compareTo(values[j]) > 0) {
                    T t = values[i];
                    values[i] = values[j];
                    values[j] = t;
                }
            }
        }
    }

    @Override
    public DoubleNode insert(T x) {

        if (this.isEmpty() || x.compareTo(this.head.prev.data) > 0) {
            return super.insert(x);
        }

        DoubleNode<T> p = this.head.next;
        while (p != this.head && x.compareTo(p.data) > 0)
            p = p.next;
        DoubleNode<T> node = new DoubleNode<T>(x, p.prev, p);
        p.prev.next = node;
        p.prev = node;
        return node;
    }


}
