package problem1;

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
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}
