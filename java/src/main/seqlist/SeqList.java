package main.seqlist;

public class SeqList<T> {

    protected Object[] objects;
    protected int n;

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
        StringBuilder str = new StringBuilder(this.getClass().getName() + "{");
        if (this.n > 0) {
            str.append(this.objects[0].toString());

            for (int i = 1; i < this.n; i++) {
                str.append(", ").append(this.objects[i].toString());
            }
        }
        return str + "}";
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
        Object[] source = this.objects; //复制源数据

        if (this.n == this.objects.length) {
            this.objects = new Object[source.length * 2];// 扩充数组

            for (int j = 0; j < i; j++) { //复制前i个数据
                this.objects[j] = source[j];
            }
        }
        for (int j = this.n - 1; j >= i; j--) {
            this.objects[j + 1] = source[j];
        }
        this.objects[i] = x; //将数据插入第i个数据
        this.n++;//修改当前所存数据个数
        return i;

    }

    public int insert(T x) {
        return this.insert(this.n, x);
    }

    public T remove(int i) {
        if (this.n > 0 && i < this.n && i >= 0) {
            T old = (T) this.objects[i];
            for (int j = i; j < this.n - 1; j++) {
                this.objects[j] = this.objects[j + 1];
            }
            this.objects[this.n - 1] = null;
            this.n--;
            return old;
        }
        return null;
    }

    public T remove(T x) {
        int index = search(x);
        return this.remove(index);
    }

    /**
     * @param x
     * @return 当前插入值的index
     */
    public int insertDifferent(T x) {

        int index = this.search(x);
        return index >= 0 ? this.insert(x) : -1;
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

    public boolean contains(T key) {
        return this.search(key) != -1;
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



    public int search(T x) {
        for (int i = 0; i < this.n; i++) {

            if (this.objects[i].equals(x)) {
                return i;
            }
        }
        return -1;
    }

    public void addAll(SeqList<? extends T> list) {
        for (int i = 0; i < list.n; i++) {
            this.insert(list.get(i));
        }
    }

   public SeqList<T> union(SeqList<? extends T> list) {

        for (int i = 0; i < list.n; i++) {
            int index = this.search(list.get(i));
            if (index >= 0) {
                this.remove(index);
            }
        }
        this.addAll(list);
        return this;
    }


}
