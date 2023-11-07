package problem1;


public class DirectedGraph extends Graph{
    public DirectedGraph(int numVertices) {
        super(numVertices);
    }

    @Override
    public void addWeightedEdge(int v, int w, int weight) {
        if (v < vertices.size() && w < vertices.size()) {
            Vertex from = vertices.get(v);
            Vertex to = vertices.get(w);
            from.al.addLast(new Edge(to, weight, from));
            from.outdegree++;to.indegree++;
        }
    }

    @Override
    public void removeEdge(int v, int w) {
        if (v < vertices.size() && w < vertices.size()) {
            Vertex from = vertices.get(v);
            Vertex to = vertices.get(w);
            for (Edge e : from.al) {
                if (e.targetVertex == to) {
                    from.al.remove(e);
                    from.outdegree--;to.indegree--;
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
            Vertex from = vertices.get(v);
            Vertex to = vertices.get(w);
            from.al.addLast(new Edge(to, 1, from));
            from.outdegree++;to.indegree++;
        }
    }

}
