package problem3;

import problem1.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        UndirectedGraph undirectedGraph = new UndirectedGraph(20);

        undirectedGraph.addWeightedEdge(0, 1, 3);
        undirectedGraph.addWeightedEdge(1, 2, 5);
        undirectedGraph.addWeightedEdge(2, 0, 1);
        //undirectedGraph.addWeightedEdge(3, 4, 1);
        undirectedGraph.addWeightedEdge(4, 0, 2);
        undirectedGraph.addWeightedEdge(25, 18, 2);


        Kruskal kruskal = new Kruskal(undirectedGraph);

        kruskal.createMinSpanningForest(); // prints trees in the terminal





    }
}
