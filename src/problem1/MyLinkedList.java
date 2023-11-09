package problem1;

import problem1.iterators.IteratorAdjacency;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<AnyType> implements Iterable<AnyType>{

    @Override
    public Iterator<AnyType> iterator() {
        return new IteratorAdjacency<>(this);
    }

    public static class Node<AnyType> {
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

    public Node<AnyType> head;
    public Node<AnyType> tail;

    public MyLinkedList() {
        head = new Node<>(null, null, null);
        tail = new Node<>(null, head, null);
        head.next = tail;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
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


    public AnyType removeAndReturnFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("The linked list is empty, nothing to remove!");
        } else {
            AnyType data = head.next.data;
            head.next = head.next.next;
            head.next.prev = head;
            theSize--;
            modCount++;
            return data;
        }
    }

    public AnyType removeAndReturnLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("The linked list is empty, nothing to remove!");
        } else {
            AnyType data = tail.prev.data;
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
            theSize--;
            modCount++;
            return data;
        }
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

}
