public class LinkedNode<E extends Comparable> { //TODO: complete class definition

    Node<E> rootNode;
    int length;

    private class Node<E extends Comparable> {

        private E item;      // reference to the item stored at this node
        private Node<E> nextNode;    // reference to the subsequent node in the list

        private Node() {
            this(null, null);
        }

        private Node(E element, Node<E> next) {
           item = element;   // creates a node with the given item
           nextNode = next;  // and next mode.
        }

        public E getElement( ) { return item; } // Accessor methods
        public Node<E> getNextNode( ) { return nextNode; }
        public void setElement (E element) { this.item = element; }
        public void setNextNode(Node<E> Node) { this.nextNode = Node; }
    }

    public LinkedNode() {
        this.rootNode = new Node();
        this.length = 0;
    }

    public void insert(E item) {
        Node<E> currentNode = this.rootNode;
        if (currentNode.getElement() == null) {
            currentNode.setElement(item);
            this.length++;
            return;
        }

        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }

        Node<E> newNode = new Node<E>(item, null);
        currentNode.setNextNode(newNode);

        this.length++;
    }

    public boolean contains(E item) {
        Node<E> currentNode = this.rootNode;

        while (!currentNode.getElement().equals(item)) {
            if (currentNode.getNextNode() == null) {
                return false;
            }
            currentNode = currentNode.getNextNode();
        }

        return true;
    }

    public int getLength() {
        return this.length;
    }

    public String toString() {

        Node<E> currentNode = this.rootNode;
        String output = currentNode.getElement().toString();

        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
            output += ", " + currentNode.getElement().toString();
        }
        return output;
    }


    public static void main(String[] args) {
        LinkedNode<Integer> list = new LinkedNode<Integer>();

        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);

        System.out.println(list.toString());
        System.out.println(list.getLength());
    }
}
