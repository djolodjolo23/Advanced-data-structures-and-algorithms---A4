package problem1;


public class UndirectedGraph extends Graph{

    public UndirectedGraph(int numVertices) {
        super(numVertices);
    }


    @Override
    public void addWeightedEdge(int from, int to, int weight) {
        if (from < vertices.size() && to < vertices.size()) {
            vertices.get(from).al.addLast(new Edge(to, weight));
            vertices.get(to).al.addLast(new Edge(from, weight));
        }
    }

    @Override
    public void removeEdge(int v, int w) {
        if (v < vertices.size() && w < vertices.size()) {
            Vertex from = vertices.get(v);
            Vertex to = vertices.get(w);
            for (Edge e : from.al) {
                if (e.targetVertex == w) {
                    from.al.remove(e);
                    break;
                }
            }
            for (Edge e : to.al) {
                if (e.targetVertex == v) {
                    to.al.remove(e);
                    break;
                }
            }
        }
    }

    @Override
    public int getDegree(int v) {
        if (v < vertices.size()) {
            return vertices.get(v).al.size();
        }
        return 0;
    }


    @Override
    public void addEdge(int from, int to) {
        if (from < vertices.size() && to < vertices.size()) {
            vertices.get(from).al.addLast(new Edge(to, 1));
            vertices.get(to).al.addLast(new Edge(from, 1));
        }
    }


}
