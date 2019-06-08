package main.tree;

public class BinaryTreeImpl<T> extends BinaryTree<T> {

    public BinaryNode<T> root;


    /**
     * 构造空的二叉树
     */
    public BinaryTreeImpl() {
        this.root = null;
    }


    @Override
    boolean isEmpty() {
        return this.root == null;
    }

    @Override
    int size() {
        return 0;
    }

    @Override
    int height() {
        return 0;
    }

    @Override
    void preorder() {

    }

    @Override
    void inorder() {

    }

    @Override
    void postorder() {

    }

    @Override
    void leveorder() {

    }

    @Override
    BinaryNode<T> insert(T x) {
        BinaryNode<T> node = new BinaryNode<T>(x, this.root, null);
        return node;
    }

    @Override
    BinaryNode<T> insert(BinaryNode<T> p, T x, boolean leftChild) {

        if (x == null) {
            return null;
        }
        if (leftChild) {
            return p.left = new BinaryNode<T>(x, p.left, null);
        }
        return p.right = new BinaryNode<T>(x, null, p.right);

    }

    @Override
    void remove(BinaryNode<T> parent, boolean leftChild) {

    }

    @Override
    void clear() {

    }

    @Override
    BinaryNode<T> search(T key) {
        return null;
    }

    @Override
    boolean contains(T key) {
        return false;
    }

    @Override
    int level(T key) {
        return 0;
    }
}
