package problem5;


import problem1.DirectedGraph;
import problem1.Graph;
import problem1.MyLinkedList;
import problem1.Vertex;
import problem2.DepthFirstSearch;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {


        GraphCreator graphCreator = new GraphCreator();


        Graph directedGraph = graphCreator.createGraph("src/problem5/data.txt");

        Map<String, Integer> courseIdToNumber = graphCreator.getCourseIdToNumber();

        TopologicalSort topologicalSort = new TopologicalSort(directedGraph);

        topologicalSort.topsort();

        directedGraph.vertices.sort((o1, o2) -> o2.topNum - o1.topNum);

        System.out.println();

        System.out.println("Courses sorted by topological sort:");
        for (Vertex v : directedGraph.vertices) {
            for (Map.Entry<String, Integer> entry : courseIdToNumber.entrySet()) {
                if (entry.getValue().equals(v.element)) {
                    System.out.println(entry.getKey());
                }
            }
        }
    }
}
