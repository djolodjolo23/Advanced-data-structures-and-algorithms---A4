package problem4;

import problem1.Edge;
import problem1.Graph;

import java.util.Arrays;
import java.util.List;

public class BellmanFord {

    private Graph g;
    private int start;

    public BellmanFord(Graph g, int start) {
        this.g = g;
        this.start = start;
    }


    public void findShortestPath() {
        int numVertices = g.getVertexCount();
        int[] distance = new int[numVertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        List<Edge> edges = g.getAllEdges();
        for (int i = 1; i < numVertices - 1; i++) {
            for (Edge e : edges) {
                int u = e.sourceVertex.element;
                int v = e.targetVertex.element;
                int w = e.weight;
                if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                }
            }
        }
        for (Edge e : edges) {
            int u = e.sourceVertex.element;
            int v = e.targetVertex.element;
            int w = e.weight;
            if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                throw new IllegalStateException("Graph contains negative weight cycle");
            }
        }
        for (int i = 0; i < g.getVertexCount(); i++) {
            if (distance[i] != Integer.MAX_VALUE) {
                System.out.println("Vertex: " + i + " Distance: " + distance[i]); // table
            } else {
                System.out.println("Vertex: " + i + " Distance: " + "Infinity"); // table
            }
        }
    }
}
