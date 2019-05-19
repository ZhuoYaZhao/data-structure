package seqlist;

public class SortedSeqList<T extends Comparable<? super T>> extends SeqList<T> {
    public SortedSeqList(int length) {
        super(length);
    }


    public SortedSeqList() {
    }

    public SortedSeqList(T[] values) {
        super(values);

        for (int i = 0; i < values.length; i++) {
            this.insert(values[i]);
        }
    }

    public SortedSeqList(SeqList list) {
        super(list);
    }

    @Override
    public int insert(T x) {
        int i = 0;
        if (this.isEmpty() || x.compareTo(this.get(this.size() - 1)) > 0) {

        }
        return 0;
    }
}
