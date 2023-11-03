package problem1;

import java.util.List;

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

    }

    /*
    @Override
    public void removeEdge(int from, int to) {
        if (from < al.size() && to < al.size()) {
            al.get(from).edges.remove(e -> e.targetVertex == to);
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
    public void addEdge(int v, int w) {
        if (v < al.size() && w < al.size()) {
            al.get(v).edges.addLast(new Edge(w, 1));
        }
    }


}
