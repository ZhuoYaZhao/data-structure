package main.seqlist;

public class SortedSeqList<T extends Comparable<? super T>> extends SeqList<T> {
    public SortedSeqList(int length) {
        super(length);
    }


    public SortedSeqList() {
    }

    public SortedSeqList(T[] values) {
        super(values.length);

        for (int i = 0; i < values.length; i++) {
            this.insert(values[i]);
        }
    }
    public SortedSeqList(SeqList<? extends T> list) {
        super(list.n);

        for (int i = 0; i < list.n; i++) {
            this.insert(list.get(i));
        }
    }

    public SortedSeqList(SortedSeqList<? extends T> list) {
        super(list);

    }

    @Override
    public int insert(T x) {
        int i = 0;
        if (this.isEmpty() || x.compareTo(this.get(this.size() - 1)) > 0) {
            i = this.n;
        } else {
            while (i < this.n && x.compareTo(this.get(i)) > 0) { // 大于 1 ,等于0，小于-1
                i++;
            }
        }
        super.insert(i, x);
        return i;
    }

    @Override
    public void set(int i, T x) {

        throw new java.lang.UnsupportedOperationException("set(inti Tx)");
    }

    @Override
    public int insert(int i, T x) {

        throw new java.lang.UnsupportedOperationException("insert(int i, T x)");
    }

    @Override
    public int search(T x) {
        for (int i = 0; i < this.n && x.compareTo(this.get(i)) >= 0; i++) {
            if (x.compareTo(get(i)) == 0) {
                return i;
            }
        }
        return -1;

    }

    @Override
    public T remove(T x) {
        int index = this.search(x);
        return this.remove(index);

    }



}
