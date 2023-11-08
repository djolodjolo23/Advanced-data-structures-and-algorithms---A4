package problem5;

import problem1.Edge;
import problem1.Graph;
import problem1.MyLinkedList;
import problem1.Vertex;

import java.util.Queue;

public class TopologicalSort {

    private final Graph g;

    public TopologicalSort(Graph g) {
        this.g = g;
    }

    public void topsort()  {
        MyLinkedList<Vertex> q = new MyLinkedList<>();
        int counter = 0;

        for (Vertex v : g.vertices) {
            if (v.indegree == 0) {
                q.addLast(v);
            }
        }
        while (!q.isEmpty()) {
            Vertex v = q.removeAndReturnFirst();
            v.topNum = ++counter;
            for (Edge ew : v.al) {
                Vertex w = ew.targetVertex;
                if (--w.indegree == 0) {
                    q.addLast(w);
                }
            }
        }


    }
}
