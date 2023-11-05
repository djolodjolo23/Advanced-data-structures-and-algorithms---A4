package problem4;

import problem1.Graph;

public class Dijkstra {

    private BinaryHeap<Graph.Vertex> bh;


    public Dijkstra(BinaryHeap<Graph.Vertex> bh) {
        this.bh = bh;
    }


    public void findShortestPath(Graph g, int start) {
        Graph.Vertex[] vertices = new Graph.Vertex[g.vertices.size()];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = g.vertices.get(i);
        }
        vertices[start].distance = 0;
        for (int i = 0; i < vertices.length; i++) {
            Graph.Vertex v = bh.findMin();
            v.known = true;
            for (Graph.Edge e : v.al) {
                if (!vertices[e.targetVertex.element].known) {
                    if (v.distance + e.weight < vertices[e.targetVertex.element].distance) {
                        vertices[e.targetVertex.element].distance = v.distance + e.weight;
                        vertices[e.targetVertex.element].path = v;
                    }
                }
            }
            bh.deleteMin();
        }
        for (int i = 0; i < vertices.length; i++) {
            System.out.println("Vertex: " + i + " Distance: " + vertices[i].distance);
        }
    }
}
