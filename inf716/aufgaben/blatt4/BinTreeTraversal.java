import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

class BinaryTree<T> {
    private T _value;
    private BinaryTree<T> _left;
    private BinaryTree<T> _right;

    public BinaryTree(T value) {
        this._value = value;
    }

    public BinaryTree<T> getLeft() {
        return this._left;
    }

    public BinaryTree<T> getRight() {
        return this._right;
    }

    public BinaryTree<T> setLeft(BinaryTree<T> node) {
        this._left = node;
        return node;
    }

    public BinaryTree<T> setRight(BinaryTree<T> node) {
        this._right = node;
        return node;
    }

    public T getValue() {
        return this._value;
    }

    public T setValue(T value) {
        this._value = value;
        return value;
    }

    public Iterator<T> iterate(Iterable<T> iter) {
        return iter.iterator();
    }
}

class BinTreeTraversal {
    public static void main(String[] args) {
        /*
            Following is an usage example, creating a binary tree and printing out all values in the order of the given iterator
         */

        BinaryTree<Integer> root = new BinaryTree<Integer>(1);

        root.setLeft(new BinaryTree<Integer>(2));
        root.setRight(new BinaryTree<Integer>(3));

        // Your implementation should be able to perform a for each with the given syntax
        for (int item : new InorderIterable<Integer>(root)) {
            System.out.println(item);
        }
    }
}

/*

    Your part starts here implement your chosen traversal strategies e.g. a

        InorderIterable(compliant to the Iterable interface(https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html?is-external=true#iterator--)), which creates an InorderIterator (compliant to the Iterator interface(https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html))

 */
