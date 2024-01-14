package problem3;

import problem1.Edge;
import problem1.Graph;
import problem1.Vertex;
import problem4.BinaryHeap;

import java.util.*;

public class Kruskal {

    private final ComponentFinder componentFinder;

    List<List<Vertex>> connectedComponents;

    public Kruskal(Graph g) {
        componentFinder = new ComponentFinder(g);
        connectedComponents = componentFinder.findComponents(g);
    }



    private List<Edge> findMinSpanningTree(List<Vertex> connectedComponent, List<Edge> edges, int numVertices) {
        PCUnionFind ds = new PCUnionFind();
        Vertex max = componentFinder.getMaxVertex(connectedComponent);
        int[] vertices = new int[max.element + 1];
        for (Vertex v : connectedComponent) {
            vertices[v.element] = v.element;
        }
        ds.initWithSpecificNums(vertices);
        List<Edge> mst = new ArrayList<>();
        BinaryHeap<Edge> bh = new BinaryHeap<>(edges.toArray(new Edge[0]));
        while (mst.size() != numVertices - 1) {
            Edge e = bh.findMin();
            assert e != null;
            if (ds.findRoot(e.sourceVertex.element) != ds.findRoot(e.targetVertex.element)) {
                mst.add(e);
                ds.makeUnion(e.sourceVertex.element, e.targetVertex.element);
            }
            bh.deleteMin();
        }
        return mst;
    }

    private List<Edge> getEdgesOfComponents(List<Vertex> vertices) {
        Set<String> uniqueEdgeStrings = new HashSet<>();
        List<Edge> uniqueEdges = new ArrayList<>();
        for (Vertex v : vertices) {
            for (Edge e : v.al) {
                String edgeString = getSortedEdgeString(e.sourceVertex.element, e.targetVertex.element);
                if (!uniqueEdgeStrings.contains(edgeString)) {
                    uniqueEdgeStrings.add(edgeString);
                    uniqueEdges.add(e);
                }
            }
        }

        return uniqueEdges;
    }

    private String getSortedEdgeString(int vertex1, int vertex2) {
        return vertex1 < vertex2 ? vertex1 + "-" + vertex2 : vertex2 + "-" + vertex1;
    }

    /**
     * Prints the minimum spanning tree or forest of the graph.
     */
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
