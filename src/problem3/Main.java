package problem3;

import problem1.DirectedGraph;
import problem1.Graph;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        DirectedGraph directedGraph = new DirectedGraph(5);

        directedGraph.addWeightedEdge(0, 1, 3);
        directedGraph.addWeightedEdge(1, 2, 5);
        directedGraph.addEdge(2, 3);
        directedGraph.addEdge(3, 4);
        directedGraph.addWeightedEdge(4, 0, 2);

        List<Graph.Edge> minSpanningTree = Kruskal.kruskal(directedGraph.getAllEdges(), 5);

        minSpanningTree.sort(Comparator.comparingInt(o -> o.sourceVertex.element));

        for (Graph.Edge edge : minSpanningTree) {
            System.out.println(edge.sourceVertex.element + "-" + edge.targetVertex.element);
        }

    }
}
