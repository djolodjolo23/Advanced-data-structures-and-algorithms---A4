package problem1;

import java.util.List;

public class DirectedGraph extends Graph{
    public DirectedGraph(int numVertices) {
        super(numVertices);
    }

    @Override
    public void addWeightedEdge(int v, int w, int weight) {
        if (v < al.size() && w < al.size()) {
            al.get(v).edges.add(new Edge(w, weight));
        }
    }

    @Override
    public void removeEdge(int from, int to) {
        if (from < al.size() && to < al.size()) {
            al.get(from).edges.removeIf(e -> e.targetVertex == to);
        }
    }

    @Override
    public int getDegree(int v) {
        if (v < al.size()) {
            return al.get(v).edges.size();
        }
        return 0;
    }

    public int getInDegree(int v) {
        if (v < al.size()) {
            int count = 0;
            for (Vertex i : al) {
                for (Edge e : i.edges) {
                    if (e.targetVertex == v) {
                        count++;
                    }
                }
            }
            return count;
        }
        return 0;
    }

    @Override
    public void addEdge(int v, int w) {
        if (v < al.size() && w < al.size()) {
            al.get(v).edges.add(new Edge(w, 1));
        }
    }
}
