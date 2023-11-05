package problem4;

import problem1.DirectedGraph;
import problem1.Graph;

public class Main {

    public static void main(String[] args) {

        Integer [] array = {8, 2, 5, 1, 3, 0, 9};

        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>(array);



        DirectedGraph ug = new DirectedGraph(7);

        ug.addWeightedEdge(0, 1, 2);
        ug.addWeightedEdge(0, 3, 1);
        ug.addWeightedEdge(1, 3, 3);
        ug.addWeightedEdge(1, 4, 10);
        ug.addWeightedEdge(2, 0, 4);
        ug.addWeightedEdge(2, 5, 5);
        ug.addWeightedEdge(3, 2, 2);
        ug.addWeightedEdge(3, 4, 2);
        ug.addWeightedEdge(3, 5, 8);
        ug.addWeightedEdge(3, 6, 4);
        ug.addWeightedEdge(4, 6, 6);
        ug.addWeightedEdge(6, 5, 1);

        Graph.Vertex[] vertices = new Graph.Vertex[ug.vertices.size()];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = ug.vertices.get(i);
        }

        BinaryHeap<Graph.Vertex> bh = new BinaryHeap<>(vertices);

        Dijkstra dijkstra = new Dijkstra(bh);

        dijkstra.findShortestPath(ug, 0);



    }
}
