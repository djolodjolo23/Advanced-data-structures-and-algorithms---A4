package problem1;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class IteratorEdgesForPrinting<AnyType> implements Iterator<VertexPair> {

    private MyLinkedList<AnyType> linky;

    private Graph.Vertex vertex;

    private int counter = 0;

    private List<Integer> edges;
    private MyLinkedList.Node<AnyType> currentNode;

    public IteratorEdgesForPrinting(MyLinkedList<AnyType> myLinkedList, Graph.Vertex vertex, List<Integer> edges) {
        linky = myLinkedList;
        this.currentNode = linky.head.next;
        this.vertex = vertex;
        this.edges = edges;
    }

    @Override
    public boolean hasNext() {
        return currentNode != linky.tail;
    }

    @Override
    public VertexPair next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (!edges.isEmpty()) {
            currentNode = currentNode.next;
            int vertexId = Integer.parseInt(String.valueOf(vertex.vertex));
            return new VertexPair(vertexId, edges.get(counter++));
        } else {
            currentNode = currentNode.next;
            return null;
        }
    }

}
