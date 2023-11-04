package problem1;

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



    public static class Edge {
        public int targetVertex;
        int weight;

        Edge(int targetVertex, int weight) {
            this.targetVertex = targetVertex;
            this.weight = weight;

        }
    }

    public static class Vertex {
        public Integer vertex;
        public MyLinkedList<Edge> al;

        Vertex(int vertex) {
            this.vertex = vertex;
            al = new MyLinkedList<>();
        }

    }

    public List<Integer> getEdges(int v) {
        List<java.lang.Integer> edges = new ArrayList<>();
        Vertex vx = vertices.get(v);
        if (vx.al.size() != 0) {
            for (Edge e : vx.al) {
                edges.add(e.targetVertex);
            }
        }
        return edges;
    }

    public abstract void addEdge(int v, int w);

    public abstract void addWeightedEdge(int v, int w, int weight);

    public abstract void removeEdge(int v, int w);

    public abstract int getDegree(int v);

}
