package problem4;

import problem1.Graph;

public class Dijkstra {



    public static Graph.Vertex getMin(Graph.Vertex[] vertices) {
        Graph.Vertex min = null;
        for (Graph.Vertex v : vertices) {
            if (!v.known) {
                if (min == null) {
                    min = v;
                } else if (v.distance < min.distance) {
                    min = v;
                }
            }
        }
        return min;
    }

    public static void dijkstra(Graph g, int start) {
        Graph.Vertex[] vertices = new Graph.Vertex[g.vertices.size()];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = g.vertices.get(i);
        }
        vertices[start].distance = 0;
        for (int i = 0; i < vertices.length; i++) {
            Graph.Vertex v = getMin(vertices);
            v.known = true;
            for (Graph.Edge e : v.al) {
                if (!vertices[e.targetVertex.element].known) {
                    if (v.distance + e.weight < vertices[e.targetVertex.element].distance) {
                        vertices[e.targetVertex.element].distance = v.distance + e.weight;
                        vertices[e.targetVertex.element].path = v;
                    }
                }
            }
        }
        for (int i = 0; i < vertices.length; i++) {
            System.out.println("Vertex: " + i + " Distance: " + vertices[i].distance);
        }
    }
}
