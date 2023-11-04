package problem1;


public class DirectedGraph extends Graph{
    public DirectedGraph(int numVertices) {
        super(numVertices);
    }

    @Override
    public void addWeightedEdge(int v, int w, int weight) {
        if (v < vertices.size() && w < vertices.size()) {
            vertices.get(v).al.addLast(new Edge(vertices.get(w), weight, vertices.get(v)));
        }
    }

    @Override
    public void removeEdge(int v, int w) {
        if (v < vertices.size() && w < vertices.size()) {
            Vertex from = vertices.get(v);
            for (Edge e : from.al) {
                if (e.targetVertex == vertices.get(w)) {
                    from.al.remove(e);
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
    public void addEdge(int v, int w) {
        if (v < vertices.size() && w < vertices.size()) {
            vertices.get(v).al.addLast(new Edge(vertices.get(w), 1, vertices.get(v)));
        }
    }


}
