package problem3;

import problem1.Edge;
import problem1.Vertex;
import problem4.BinaryHeap;

import java.util.ArrayList;
import java.util.List;

public class Kruskal {


    public List<Edge> findMinSpanningTree(List<Edge> edges, int numVertices) {
        PCUnionFind ds = new PCUnionFind();
        ds.init(numVertices);
        List<Edge> mst = new ArrayList<>();
        BinaryHeap<Edge> bh = new BinaryHeap<>(edges.toArray(new Edge[0]));
        while (mst.size() != numVertices - 1) {
            Edge e = bh.findMin();
            assert e != null;
            int uSet = ds.findRoot(e.sourceVertex.element);
            int vSet = ds.findRoot(e.targetVertex.element);
            if (uSet != vSet) {
                mst.add(e);
                ds.makeUnion(uSet, vSet);
            }
            bh.deleteMin();
        }
        return mst;
    }

    public List<Edge> getEdgesOfComponents(List<Vertex> vertices) {
        List<Edge> allEdges = new ArrayList<>();
        for (Vertex v : vertices) {
            for (Edge e : v.al) {
                allEdges.addLast(e);
            }
        }
        return allEdges;
    }


    public void createMinSpanningForest(List<List<Vertex>>connectedComponents) {
        System.out.println("Minimum Spanning Forest: ");
        int componentCount = 1;
        for (List<Vertex> connectedComponent: connectedComponents) {
            System.out.println("Component " + componentCount++ + ": ");
            if (connectedComponent.size() == 1) {
                System.out.println(connectedComponent.get(0).element);
                System.out.println();
                continue;
            }
            List<Edge> edges = getEdgesOfComponents(connectedComponent);
            List<Edge> minSpanningTree = findMinSpanningTree(edges, connectedComponent.size());
            for (Edge e : minSpanningTree) {
                System.out.println(e.targetVertex.element + "--" + e.sourceVertex.element);
            }
            System.out.println();
        }
    }

}
