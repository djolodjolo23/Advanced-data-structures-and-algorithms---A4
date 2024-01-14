package problem3;

import problem1.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        UndirectedGraph undirectedGraph = new UndirectedGraph(7);

        undirectedGraph.addWeightedEdge(0, 1, 2);
        undirectedGraph.addWeightedEdge(0, 3, 1);
        undirectedGraph.addWeightedEdge(1, 3, 3);
        undirectedGraph.addWeightedEdge(1, 4, 10);
        undirectedGraph.addWeightedEdge(2, 0, 4);
        undirectedGraph.addWeightedEdge(2, 5, 5);
        undirectedGraph.addWeightedEdge(3, 2, 2);
        undirectedGraph.addWeightedEdge(3, 4, 2);
        undirectedGraph.addWeightedEdge(3, 5, 8);
        undirectedGraph.addWeightedEdge(3, 6, 4);
        undirectedGraph.addWeightedEdge(4, 6, 6);
        undirectedGraph.addWeightedEdge(6, 5, 1);



        Kruskal kruskal = new Kruskal(undirectedGraph);

        kruskal.createMinSpanningForest(); // prints trees in the terminal





    }
}
