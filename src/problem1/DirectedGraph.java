package problem1;

public class DirectedGraph extends Graph{
    public DirectedGraph(int numVertices) {
        super(numVertices);
    }

    @Override
    public void addWeightedEdge(int v, int w, int weight) {
        if (v < al.size() && w < al.size()) {
            al.get(v).add(new Edge(w, weight));
        }
    }

    @Override
    public void addEdge(int v, int w) {
        if (v < al.size() && w < al.size()) {
            al.get(v).add(new Edge(w, 1));
        }
    }
}
