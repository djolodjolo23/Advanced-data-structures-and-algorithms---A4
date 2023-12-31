package problem1;


public class UndirectedGraph extends Graph{

    public UndirectedGraph(int numVertices) {
        super(numVertices);
    }


    @Override
    public void addWeightedEdge(int from, int to, int weight) {
        if (from < vertices.size() && to < vertices.size()) {
            Vertex fr = vertices.get(from);
            Vertex t = vertices.get(to);
            fr.al.addLast(new Edge(t, weight, fr));
            t.al.addLast(new Edge(fr, weight, t));
            fr.degree++; t.degree++;
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
                    break;
                }
            }
            for (Edge e : to.al) {
                if (e.targetVertex == from) {
                    to.al.remove(e);
                    break;
                }
            }
            from.degree--; to.degree--;
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
            Vertex fr = vertices.get(from);
            Vertex t = vertices.get(to);
            vertices.get(from).al.addLast(new Edge(vertices.get(to), 1, vertices.get(from)));
            vertices.get(to).al.addLast(new Edge(vertices.get(from), 1, vertices.get(to)));
            fr.degree++; t.degree++;
        }
    }


}
