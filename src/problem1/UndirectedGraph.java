package problem1;

public class UndirectedGraph extends Graph{

    public UndirectedGraph(int numVertices) {
        super(numVertices);
    }

    @Override
    public void addWeightedEdge(int from, int to, int weight) {
        if (from < al.size() && to < al.size()) {
            al.get(from).edges.addLast(new Edge(to, weight));
            al.get(to).edges.addLast(new Edge(from, weight));
        }
    }

    @Override
    public void removeEdge(int v, int w) {
        if (v < al.size() && w < al.size()) {
            Vertex from = al.get(v);
            Vertex to = al.get(w);
            for (Edge e : from.edges) {
                if (e.targetVertex == w) {
                    from.edges.remove(e);
                    break;
                }
            }
            for (Edge e : to.edges) {
                if (e.targetVertex == v) {
                    to.edges.remove(e);
                    break;
                }
            }
        }
    }

    /*
    @Override
    public void removeEdge(int from, int to) {
        IteratorEdges<Edge> it = new IteratorEdges<>(this);
        // find node with iterator
        while (it.hasNext()) {
            Edge e = it.next();
            if (e.targetVertex == to) {
                al.get(from).edges.remove(e);
            }
        }
        if (from < al.size() && to < al.size()) {
            al.get(from).edges.removeIf(e -> e.targetVertex == to);
            al.get(to).edges.removeIf(e -> e.targetVertex == from);
        }
    }

     */

    @Override
    public int getDegree(int v) {
        if (v < al.size()) {
            return al.get(v).edges.size();
        }
        return 0;
    }


    @Override
    public void addEdge(int from, int to) {
        if (from < al.size() && to < al.size()) {
            al.get(from).edges.addLast(new Edge(to, 1));
            al.get(to).edges.addLast(new Edge(from, 1));
        }
    }


}
