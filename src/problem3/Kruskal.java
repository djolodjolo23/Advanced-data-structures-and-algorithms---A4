package problem3;

import problem1.Edge;
import problem1.Graph;
import problem1.Vertex;
import problem4.BinaryHeap;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Kruskal {

    private ComponentFinder componentFinder;

    List<List<Vertex>> connectedComponents;

    public Kruskal(Graph g) {
        componentFinder = new ComponentFinder(g, 0);
        connectedComponents = componentFinder.findComponents(g);
    }


    private List<Edge> findMinSpanningTree(List<Vertex> connectedComponent, List<Edge> edges, int numVertices) {
        PCUnionFind ds = new PCUnionFind();
        Vertex max = componentFinder.getMaxVertex(connectedComponent);
        int[] vertices = new int[max.element + 1];
        // get the biggest vertex from connectedComponent, by element value
        for (Vertex v : connectedComponent) {
            vertices[v.element] = v.element;
        }
        ds.initWithSpecificNums(vertices);
        //ds.init(numVertices);
        List<Edge> mst = new ArrayList<>();
        BinaryHeap<Edge> bh = new BinaryHeap<>(edges.toArray(new Edge[0]));
        while (mst.size() != numVertices - 1) {
            Edge e = bh.findMin();
            assert e != null;
            if (!Objects.equals(e.sourceVertex.element, e.targetVertex.element)) {
                mst.add(e);
                ds.makeUnion(e.sourceVertex.element, e.targetVertex.element);
            }
            bh.deleteMin();
        }
        return mst;
    }

    private List<Edge> getEdgesOfComponents(List<Vertex> vertices) {
        List<Edge> allEdges = new ArrayList<>();
        for (Vertex v : vertices) {
            for (Edge e : v.al) {
                allEdges.addLast(e);
            }
        }
        return allEdges;
    }


    public void createMinSpanningForest() {
        if (!connectedComponents.isEmpty()) {
            if (connectedComponents.size() == 1) {
                System.out.println("Minimum Spanning Tree:");
            } else {
                System.out.println("Minimum Spanning Forest:");
            }
            int componentCount = 1;
            for (List<Vertex> connectedComponent : connectedComponents) {
                System.out.println("Tree " + componentCount++ + ": ");
                if (connectedComponent.size() == 1) {
                    System.out.println(connectedComponent.get(0).element);
                    System.out.println();
                    continue;
                }
                List<Edge> edges = getEdgesOfComponents(connectedComponent);
                List<Edge> minSpanningTree = findMinSpanningTree(connectedComponent, edges, connectedComponent.size());
                for (Edge e : minSpanningTree) {
                    System.out.println(e.targetVertex.element + "--" + e.sourceVertex.element);
                }
                System.out.println();
            }
        } else {
            System.out.println("There are no components, cannot create a tree or a forest.");
        }
    }

}
