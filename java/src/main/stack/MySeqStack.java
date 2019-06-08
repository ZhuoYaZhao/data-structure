package main.stack;

import main.seqlist.SeqList;

import java.util.Stack;

public final class MySeqStack<T> extends Stack<T> {
    private SeqList<T> list;

    public MySeqStack(int length) {
        this.list = new SeqList<T>();

    }

    public MySeqStack() {
        this(64);
    }

    @Override
    public synchronized boolean isEmpty() {

        return this.list.isEmpty();
    }


    @Override
    public synchronized T pop() {
        return super.pop();
    }

    @Override
    public synchronized T peek() {
        return super.peek();
    }
}
