package main.string;

import java.io.Serializable;

public final class MyString implements Comparable<MyString>, Serializable {

    private final char[] value;

    public MyString() {
        value = new char[0];
    }

    public MyString(String str) {
        this.value = new char[str.length()];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = str.charAt(i);
        }
    }

    public MyString(char[] value, int i, int n) {
        if (i >= 0 && n >= 0 && i + n < value.length) {
            this.value = new char[n];
            for (int j = 0; j < n; j++) {
                this.value[j] = value[i + j];
            }
        }

        throw new StringIndexOutOfBoundsException("i=" + i + ", n=" + n + ", n+i=" + (n + i));
    }

    public MyString(char[] value) {
        this(value, 0, value.length);
    }

    public MyString(MyString str) {

        this(str.value);
    }

    public int length() {
        return this.value.length;
    }

    @Override
    public String toString() {
        return new String(this.value);
    }

    public char charAt(int i) {
        if (i >= 0 && i < this.length()) {
            return this.value[i];
        }

        throw new StringIndexOutOfBoundsException(i);
    }

    public MyString subString(int begin, int end) {
        if (begin == 0 && end == this.length()) {
            return this;
        }
        return new MyString(this.value, begin, end - begin);

    }

    public MyString subString(int begin) {
        return subString(begin, this.value.length);
    }

    public MyString concat(MyString string) {
        if (string == null) {
            string = new MyString("null");
        }
        char[] buffer = new char[this.value.length + string.length()];

        for (int i = 0; i < this.length(); i++) {
            buffer[i] = this.charAt(i);
        }
        for (int i = 0; i < string.length(); i++) {
            buffer[this.length() + i] = string.charAt(i);
        }

        return new MyString(buffer);
    }


    @Override
    public int compareTo(MyString o) {
        return 0;
    }
}
