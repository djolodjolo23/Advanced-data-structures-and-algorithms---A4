package problem1;

import java.util.Iterator;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {

    static class Node<AnyType> {
        public AnyType data;
        public Node<AnyType> prev;
        public Node<AnyType> next;

        private Node(AnyType data, Node<AnyType> prev, Node<AnyType> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private int theSize;
    private int modCount = 0;

    Node<AnyType> head;
    Node<AnyType> tail;

    public MyLinkedList() {
        head = new Node<AnyType>(null, null, null);
        tail = new Node<AnyType>(null, head, null);
        head.next = tail;
    }

    public int size() {
        return theSize;
    }


    public void addFirst(AnyType x) {
        Node<AnyType> newNode = new Node<>(x, head, head.next);
        head.next.prev = newNode;
        head.next = newNode;

        theSize++;
        modCount++;
    }

    public void addLast(AnyType x) {
        Node<AnyType> newNode = new Node<>(x, tail.prev, tail);
        tail.prev.next = newNode;
        tail.prev = newNode;

        theSize++;
        modCount++;
    }




    public void remove(AnyType x) {
        Node<AnyType> currentNode = head.next;
        while (currentNode != tail) {
            if (currentNode.data.equals(x)) {
                currentNode.prev.next = currentNode.next;
                currentNode.next.prev = currentNode.prev;
                theSize--;
                modCount++;
                return;
            }
            currentNode = currentNode.next;
        }
    }






    @Override
    public Iterator<AnyType> iterator() {
        return new IteratorEdges<>(this);
    }
}
