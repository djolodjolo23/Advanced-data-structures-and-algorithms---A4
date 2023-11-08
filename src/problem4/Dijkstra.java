package problem4;

import problem1.Edge;
import problem1.Graph;
import problem1.Vertex;

public class Dijkstra {

    private final BinaryHeap<Vertex> bh;


    public Dijkstra(BinaryHeap<Vertex> bh) {
        this.bh = bh;
    }


    public void findShortestPath(Graph g, int start) {
        Vertex[] vertices = new Vertex[g.vertices.size()];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = g.vertices.get(i);
        }
        vertices[start].distance = 0;
        for (int i = 0; i < vertices.length; i++) {
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
            System.out.println("Vertex: " + i + " Distance: " + vertices[i].distance);
        }
    }
}
