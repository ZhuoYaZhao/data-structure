package main.tree;

public abstract class BinaryTree<T> {
    abstract boolean isEmpty();

    abstract int size();

    abstract int height();

    abstract void preorder();

    abstract void inorder();

    abstract void postorder();

    abstract void leveorder();

    abstract BinaryNode<T> insert(T x);

    abstract BinaryNode<T> insert(BinaryNode<T> p, T x, boolean leftChild);

    abstract void remove(BinaryNode<T> parent, boolean leftChild);

    abstract void clear();

    abstract BinaryNode<T> search(T key);

    abstract boolean contains(T key);

    abstract int level(T key);
}
