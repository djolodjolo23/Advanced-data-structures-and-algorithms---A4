package problem1.iterators;

import problem1.Edge;
import problem1.Graph;
import helpers.VertexPair;
import problem1.Vertex;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorEdges implements Iterator<VertexPair> {

    private Iterator<Vertex> vertexIterator;
    private Iterator<Edge> edgeIterator;
    private int currentVertexId;

    public IteratorEdges(Graph graph) {
        this.vertexIterator = graph.vertices.iterator();
        if (vertexIterator.hasNext()) {
            this.edgeIterator = vertexIterator.next().al.iterator();
            this.currentVertexId = 0;
        }
    }

    @Override
    public boolean hasNext() {
        while (edgeIterator != null && !edgeIterator.hasNext() && vertexIterator.hasNext()) {
            // Move to the next vertex and its linked list of edges.
            Vertex vertex = vertexIterator.next();
            edgeIterator = vertex.al.iterator();
            currentVertexId++;
        }
        return edgeIterator != null && edgeIterator.hasNext();
    }

    @Override
    public VertexPair next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        Edge edge = edgeIterator.next();
        return new VertexPair(currentVertexId, edge.targetVertex.element);
    }
}


