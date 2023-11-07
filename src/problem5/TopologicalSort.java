package problem5;

import problem1.Graph;
import problem1.MyLinkedList;

import java.util.Queue;

public class TopologicalSort {

    private final Graph g;

    public TopologicalSort(Graph g) {
        this.g = g;
    }

    public void topsort()  {
        MyLinkedList<Graph.Vertex> q = new MyLinkedList<>();
        int counter = 0;

        for (Graph.Vertex v : g.vertices) {
            if (v.indegree == 0) {
                q.addLast(v);
            }
        }
        while (!q.isEmpty()) {
            Graph.Vertex v = q.removeAndReturnFirst();
            v.topNum = ++counter;
            for (Graph.Edge ew : v.al) {
                Graph.Vertex w = ew.targetVertex;
                if (--w.indegree == 0) {
                    q.addLast(w);
                }
            }
        }


    }
}
