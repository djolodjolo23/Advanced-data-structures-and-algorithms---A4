package problem5;


import problem1.DirectedGraph;
import problem1.Graph;
import problem2.DepthFirstSearch;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {


        GraphCreator graphCreator = new GraphCreator();


        Graph directedGraph = graphCreator.createGraph("src/problem5/data.txt");

        Map<String, Integer> courseIdToNumber = graphCreator.getCourseIdToNumber();

        DepthFirstSearch dfs = new DepthFirstSearch(directedGraph, 0);

        List<Integer> prerequisites = dfs.getPrerequisites();

        System.out.println("All prerequisite courses: ");
        for (Integer pr : prerequisites) {
            for (Map.Entry<String, Integer> entry : courseIdToNumber.entrySet()) {
                if (entry.getValue().equals(pr)) {
                    System.out.println(entry.getKey());
                }
            }
        }


    }
}
