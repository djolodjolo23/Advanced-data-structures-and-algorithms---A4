package problem1;

import java.util.Objects;

/**
 * The Vertex class represents a vertex in a graph.
 * It contains a list of edges that are adjacent to the vertex.
 * It also contains fields that are used in Dijkstra's algorithm and topological sort.
 */
public class Vertex implements Comparable<Vertex> {

    public Integer element;

    public MyLinkedList<Edge> al; // adjacency list of edges
    public int distance; // used in Dijkstra's algorithm
    public Vertex path; // used in Dijkstra's algorithm
    public boolean known; // used in Dijkstra's algorithm
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
