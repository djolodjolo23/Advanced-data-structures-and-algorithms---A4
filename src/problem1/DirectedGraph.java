package problem1;


public class DirectedGraph extends Graph{
    public DirectedGraph(int numVertices) {
        super(numVertices);
    }

    @Override
    public void addWeightedEdge(int v, int w, int weight) {
        if (v < al.size() && w < al.size()) {
            al.get(v).edges.addLast(new Edge(w, weight));
        }
    }

    @Override
    public void removeEdge(int v, int w) {
        if (v < al.size() && w < al.size()) {
            Vertex from = al.get(v);
            for (Edge e : from.edges) {
                if (e.targetVertex == w) {
                    from.edges.remove(e);
                    break;
                }
            }
        }
    }


    @Override
    public int getDegree(int v) {
        if (v < al.size()) {
            return al.get(v).edges.size();
        }
        return 0;
    }


    @Override
    public void addEdge(int v, int w) {
        if (v < al.size() && w < al.size()) {
            al.get(v).edges.addLast(new Edge(w, 1));
        }
    }


}
