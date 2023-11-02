package problem1;

import java.util.ArrayList;
import java.util.List;

public abstract class Graph {

    List<List<Edge>> al;


    public Graph(int numVertices) {
        al = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            al.add(new ArrayList<>());
        }
    }

    public int getVertexCount() {
        return al.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (List<Edge> l : al) {
            count += l.size();
        }
        if (this instanceof UndirectedGraph) {
            return count / 2;
        } else if (this instanceof DirectedGraph) {
            return count;
        } else {
            throw new IllegalStateException("Graph is neither directed nor undirected");
        }
    }

    static class Edge {
        int targetVertex;
        int weight;

        Edge(int targetVertex, int weight) {
            this.targetVertex = targetVertex;
            this.weight = weight;
        }
    }

    public abstract void addEdge(int v, int w);

    public abstract void addWeightedEdge(int v, int w, int weight);

}
