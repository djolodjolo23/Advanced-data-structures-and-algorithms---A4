package problem4;

import problem1.Edge;
import problem1.Graph;
import problem1.Vertex;

public class Dijkstra {

    private final BinaryHeap<Vertex> bh;

    private final Vertex[] heapArray;

    private HeapHelper heapHelper;

    private int start;

    private Graph g;


    public Dijkstra(Graph g, int start) {
        this.g = g;
        this.start = start;
        this.heapHelper = new HeapHelper(g, start);
        this.heapArray = heapHelper.createHeapArray(g.vertices, start);
        this.bh = new BinaryHeap<>(heapArray);
    }


    public void findShortestPath() {
        Vertex[] vertices = new Vertex[g.vertices.size()];
        for (Vertex v : heapArray) {
            vertices[v.element] = v;
        }
        vertices[start].distance = 0;
        int bhSize = bh.size();
        for (int i = 0; i < bhSize; i++) {
            Vertex v = bh.findMin(); // first find to update distances
            v.known = true;
            for (Edge e : v.al) {
                if (!vertices[e.targetVertex.element].known) {
                    if (v.distance + e.weight < vertices[e.targetVertex.element].distance) {
                        vertices[e.targetVertex.element].distance = v.distance + e.weight;
                        vertices[e.targetVertex.element].path = v; // last visited
                    }
                }
            }
            bh.deleteMin(); // now delete to update heap
        }
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] != null) {
                System.out.println("Vertex: " + i + " Distance: " + vertices[i].distance);
            } else {
                System.out.println("Vertex: " + i + " Distance: " + "Infinity");
            }
        }
    }
}
