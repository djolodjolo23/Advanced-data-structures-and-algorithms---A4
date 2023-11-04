package problem1.iterators;
import problem1.Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorVertices implements Iterator<Graph.Vertex> {
    private int index;
    private final List<Graph.Vertex> list;

    public IteratorVertices(Graph graph) {
        list = new ArrayList<>();
        list.addAll(graph.vertices);
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public Graph.Vertex next() {
        return list.get(index++);
    }
}
