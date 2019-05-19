package seqlist;

public class SeqList<T> {

    protected Object[] objects;
    protected int n;
    private SeqList<? extends T> list;

    public SeqList(int length) {
        this.objects = new Object[length]; //申请数组得存储空间
        this.n = 0;// 初始化当前存储了多少元素
    }

    public SeqList() {
        this(64);//默认创建64个容量得数组
    }

    public SeqList(T[] values) {


        this(values.length);

        for (int i = 0; i < values.length; i++) {
            this.objects[i] = values[i];
        }
        this.n = values.length;
    }

    public boolean isEmpty() {
        return this.n == 0;
    }

    public int size() {
        return this.n;
    }

    public T get(int i) {
        if (i >= 0 && i < this.n)
            return (T) objects[i];
        return null;
    }

    public void set(int i, T x) {
        if (x == null) {
            throw new NullPointerException("x==null");
        }
        if (i >= 0 && i < this.n) {
            this.objects[i] = x;

        } else {
            throw new java.lang.IndexOutOfBoundsException(i + "");
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(this.getClass().getName() + "(");
        if (this.n > 0) {
            str.append(this.objects[0].toString());
            for (int i = 1; i < this.n; i++) {
                str.append(",").append(this.objects[i].toString());
            }
        }
        return str + ")";
    }

    public int insert(int i, T x) {
        if (x == null) {
            throw new NullPointerException("x==null");
        }
        if (i < 0) {
            i = 0;
        }
        if (i > this.n) {
            i = this.n;
        }
        Object[] source = this.objects;
        if (this.n == this.objects.length) {
            this.objects = new Object[source.length * 2];

            for (int j = 0; j < i; i++) {
                this.objects[i] = source[i];
            }
        }
        for (int j = this.n - 1; j >= i; j--) {
            this.objects[i + 1] = source[j];
        }
        this.objects[i] = x;
        this.n++;
        return i;

    }

    public int insert(T x) {
        return this.insert(this.n, x);
    }

    public T remove(int i) {
        if (this.n > 0 && i < this.n && i >= 0) {
            T old = (T) this.objects[i];
            for (int j = i; j < this.n - 1; j++) {
                this.objects[j] = this.objects[i + 1];
            }
            this.objects[this.n - 1] = null;
            this.n--;
            return old;
        }
        return null;
    }

//    public SeqList(SeqList<T> list) {
//        this.n = list.n;
//        this.objects = list.objects;
//    }

    public SeqList(SeqList<? extends T> list) {
        if (list == null) {
            throw new NullPointerException("list==null");
        }
        if (list.size() == 0) {
            this.n = 64;
            this.objects = new Object[64];
        }

        this.n = list.n;
        this.objects = new Object[list.objects.length];
        for (int i = 0; i < list.n; i++) {
            this.objects[i] = list.objects[i];
        }

    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj instanceof SeqList<?>) {
            SeqList<T> o = (SeqList<T>) obj;


            if (o.n == this.n) {
                for (int i = 0; i < o.n; i++) {
                    if (!(o.objects[i].equals(this.objects[i]))) {
                        return false;
                    }

                }
                return true;
            }
        }
        return false;
    }
}
