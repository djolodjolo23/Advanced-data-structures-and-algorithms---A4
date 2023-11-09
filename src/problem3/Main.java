package problem3;

import problem1.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        UndirectedGraph undirectedGraph = new UndirectedGraph(5);

        undirectedGraph.addWeightedEdge(0, 1, 3);
        undirectedGraph.addWeightedEdge(1, 2, 5);
        undirectedGraph.addEdge(2, 0);
        undirectedGraph.addEdge(3, 4);
        undirectedGraph.addWeightedEdge(4, 0, 2);


        Kruskal kruskal = new Kruskal(undirectedGraph);

        kruskal.createMinSpanningForest();





    }
}
