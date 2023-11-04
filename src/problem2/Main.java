package problem2;

import problem1.DirectedGraph;

public class Main {

    public static void main(String[] args) {

        DirectedGraph directedGraph = new DirectedGraph(5);

        directedGraph.addEdge(0, 1);
        directedGraph.addEdge(1, 2);
        directedGraph.addEdge(2, 3);
        directedGraph.addEdge(3, 4);
        directedGraph.addEdge(4, 0);


        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(directedGraph, 4);

        System.out.println(depthFirstSearch.hasPathTo(0));

        System.out.println(depthFirstSearch.pathTo(0));




    }
}
