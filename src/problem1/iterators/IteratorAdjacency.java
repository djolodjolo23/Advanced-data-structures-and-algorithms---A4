package problem1.iterators;

import problem1.MyLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorAdjacency<AnyType> implements Iterator<AnyType>{

    private MyLinkedList<AnyType> adjacency;
    private MyLinkedList.Node<AnyType> currentNode;

    public IteratorAdjacency(MyLinkedList<AnyType> adjacency) {
        this.adjacency = adjacency;
        this.currentNode = this.adjacency.head.next;
    }

    @Override
    public boolean hasNext() {
        return currentNode != adjacency.tail;
    }

    @Override
    public AnyType next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        AnyType data = currentNode.data;
        currentNode = currentNode.next;
        return data;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}


