package problem4;

import problem1.Graph;

import java.util.Arrays;
import java.util.List;

public class BellmanFord {


    public void findShortestPath(Graph g, int source) {
        int numVertices = g.getVertexCount();
        int[] distance = new int[numVertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        List<Graph.Edge> edges = g.getAllEdges();
        for (int i = 1; i < numVertices - 1; i++) {
            for (Graph.Edge e : edges) {
                int u = e.sourceVertex.element;
                int v = e.targetVertex.element;
                int w = e.weight;
                if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                }
            }
        }
        for (Graph.Edge e : edges) {
            int u = e.sourceVertex.element;
            int v = e.targetVertex.element;
            int w = e.weight;
            if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                throw new IllegalStateException("Graph contains negative weight cycle");
            }
        }
        for (int i = 0; i < g.getVertexCount(); i++) {
            System.out.println("Vertex: " + i + " Distance: " + distance[i]); // table
        }
    }
}
