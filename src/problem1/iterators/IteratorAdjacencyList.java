package problem1.iterators;

import problem1.MyLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorAdjacencyList<AnyType> implements Iterator<AnyType>{

    private MyLinkedList<AnyType> linky;
    private MyLinkedList.Node<AnyType> currentNode;

    public IteratorAdjacencyList(MyLinkedList<AnyType> myLinkedList) {
        linky = myLinkedList;
        this.currentNode = linky.head.next;
    }

    @Override
    public boolean hasNext() {
        return currentNode != linky.tail;
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


