package problem3;

import problem1.Graph;
import problem4.BinaryHeap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Kruskal {

    public static ArrayList<Graph.Edge> kruskal(List<Graph.Edge> edges, int numVertices) {
        PCUnionFind ds = new PCUnionFind();
        ds.init(numVertices);
        ArrayList<Graph.Edge> mst = new ArrayList<>();
        BinaryHeap<Graph.Edge> bh = new BinaryHeap<>(edges.toArray(new Graph.Edge[0]));
        while (mst.size() != numVertices - 1) {
            Graph.Edge e = bh.findMin();
            assert e != null;
            int uset = ds.findRoot(e.sourceVertex.element);
            int vset = ds.findRoot(e.targetVertex.element);
            if (uset != vset) {
                mst.add(e);
                ds.makeUnion(uset, vset);
            }
            bh.deleteMin();
        }
        return mst;
    }
}
