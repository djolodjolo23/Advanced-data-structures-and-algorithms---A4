package problem1;

import helpers.VertexPair;
import problem4.Dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public static class Vertex implements Comparable<Vertex> {

        public Integer element;
        public MyLinkedList<Edge> al;
        public int distance;
        public Vertex path;
        public boolean known;

        public int degree;
        public int indegree; // used for topological sort
        public int outdegree; // not used but might be useful in some cases
        public int topNum; // used for topological sort


        public Vertex(int vertex) {
            this.element = vertex;
            al = new MyLinkedList<>();
            distance = Integer.MAX_VALUE;
            known = false;
            degree = 0;
            indegree = 0;
            outdegree = 0;
            topNum = 0;
        }

        public int getMinWeight() {
            int min = Integer.MAX_VALUE;
            for (Edge e : al) {
                if (e.weight < min) {
                    min = e.weight;
                }
            }
            return min;
        }


        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.distance, o.distance);
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            Vertex vertex = (Vertex) object;
            return Objects.equals(element, vertex.element);
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
