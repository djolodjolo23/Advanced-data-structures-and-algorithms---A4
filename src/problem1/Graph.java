package problem1;

import java.util.ArrayList;
import java.util.List;

public abstract class Graph {

    public List<Vertex> al;

    public Graph(int numVertices) {
        al = new ArrayList<>();
        for (int i = 1; i <= numVertices; i++) {
            al.add(new Vertex(i));
        }
    }

    public int getVertexCount() {
        return al.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex vertex : al) {
            count += vertex.edges.size();
        }
        if (this instanceof UndirectedGraph) {
            return count / 2;
        } else if (this instanceof DirectedGraph) {
            return count;
        } else {
            throw new IllegalStateException("Graph is neither directed nor undirected");
        }
    }

    static class Edge {
        int targetVertex;
        int weight;

        Edge(int targetVertex, int weight) {
            this.targetVertex = targetVertex;
            this.weight = weight;

        }
    }

    static class Vertex {
        int vertex;
        MyLinkedList<Edge> edges;

        Vertex(int vertex) {
            this.vertex = vertex;
            edges = new MyLinkedList<>();
        }
    }

    public abstract void addEdge(int v, int w);

    public abstract void addWeightedEdge(int v, int w, int weight);

    public abstract void removeEdge(int v, int w);

    public abstract int getDegree(int v);

}
