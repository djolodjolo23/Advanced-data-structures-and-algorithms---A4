package problem1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorEdges implements Iterator<VertexPair> {

    private Iterator<Graph.Vertex> vertexIterator;
    private Iterator<Graph.Edge> edgeIterator;
    private int currentVertexId;

    public IteratorEdges(Graph graph) {
        this.vertexIterator = graph.al.iterator();
        if (vertexIterator.hasNext()) {
            this.edgeIterator = vertexIterator.next().edges.iterator();
            this.currentVertexId = 0;
        }
    }

    @Override
    public boolean hasNext() {
        while (edgeIterator != null && !edgeIterator.hasNext() && vertexIterator.hasNext()) {
            // Move to the next vertex and its linked list of edges.
            Graph.Vertex vertex = vertexIterator.next();
            edgeIterator = vertex.edges.iterator();
            currentVertexId++;
        }
        return edgeIterator != null && edgeIterator.hasNext();
    }

    @Override
    public VertexPair next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        Graph.Edge edge = edgeIterator.next();
        return new VertexPair(currentVertexId, edge.targetVertex);
    }
}


