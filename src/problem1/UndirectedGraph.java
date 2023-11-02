package problem1;

public class UndirectedGraph extends Graph{

    public UndirectedGraph(int numVertices) {
        super(numVertices);
    }

    @Override
    public void addWeightedEdge(int from, int to, int weight) {
        if (from < al.size() && to < al.size()) {
            al.get(from).add(new Edge(to, weight));
            al.get(to).add(new Edge(from, weight));
        }
    }


    @Override
    public void addEdge(int from, int to) {
        if (from < al.size() && to < al.size()) {
            al.get(from).add(new Edge(to, 1));
            al.get(to).add(new Edge(from, 1));
        }
    }
}
