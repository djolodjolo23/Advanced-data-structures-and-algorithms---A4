package problem1;

import helpers.VertexPair;

import java.util.ArrayList;
import java.util.List;

public abstract class Graph {

    public List<Vertex> vertices;

    public Graph(int numVertices) {
        vertices = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            vertices.add(new Vertex(i));
        }
    }

    public int getVertexCount() {
        return vertices.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex vertex : vertices) {
            count += vertex.al.size();
        }
        if (this instanceof UndirectedGraph) {
            return count / 2;
        } else if (this instanceof DirectedGraph) {
            return count;
        } else {
            throw new IllegalStateException("Graph is neither directed nor undirected");
        }
    }



    public static class Edge implements Comparable<Edge> {
        public Vertex sourceVertex;
        public Vertex targetVertex;
        public int weight;

        Edge(Vertex targetVertex, int weight, Vertex sourceVertex) {
            this.targetVertex = targetVertex;
            this.weight = weight;
            this.sourceVertex = sourceVertex;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static class Vertex {
        public Integer element;
        public MyLinkedList<Edge> al;

        Vertex(int vertex) {
            this.element = vertex;
            al = new MyLinkedList<>();
        }

    }

    public List<Edge> getEdges(int v) {
        List<Edge> edges = new ArrayList<>();
        Vertex vx = vertices.get(v);
        if (!vx.al.isEmpty()) {
            for (Edge e : vx.al) {
                edges.add(e);
            }
        }
        return edges;
    }

    public List<Edge> getAllEdges() {
        List<Edge> edges = new ArrayList<>();
        for (Vertex v : vertices) {
            if (!v.al.isEmpty()) {
                for (Edge e : v.al) {
                    edges.add(e);
                }
            }
        }
        return edges;
    }

    public abstract void addEdge(int v, int w);

    public abstract void addWeightedEdge(int v, int w, int weight);

    public abstract void removeEdge(int v, int w);

    public abstract int getDegree(int v);

}
