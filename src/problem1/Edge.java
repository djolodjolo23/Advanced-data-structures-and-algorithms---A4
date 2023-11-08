package problem1;

import java.util.Objects;

public class Edge implements Comparable<Edge>{

    public Vertex sourceVertex;

    public Vertex targetVertex;
    public int weight;

    Edge(Vertex targetVertex, int weight, Vertex sourceVertex) {
        this.targetVertex = targetVertex;
        this.weight = weight;
        this.sourceVertex = sourceVertex;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Edge edge = (Edge) object;
        return weight == edge.weight && Objects.equals(sourceVertex, edge.sourceVertex) && Objects.equals(targetVertex, edge.targetVertex);
    }

    public boolean equalsInUndirected(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Edge edge = (Edge) object;
        return weight == edge.weight && (
                (sourceVertex.equals(edge.sourceVertex) && targetVertex.equals(edge.targetVertex)) ||
                        (sourceVertex.equals(edge.targetVertex) && targetVertex.equals(edge.sourceVertex))
        );
    }



    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}
