package problem2;

import problem1.DirectedGraph;
import problem1.UndirectedGraph;

public class Main {

    public static void main(String[] args) {

        /*
        DirectedGraph directedGraph = new DirectedGraph(5);

        directedGraph.addEdge(0, 1);
        directedGraph.addEdge(1, 2);
        directedGraph.addEdge(2, 3);
        directedGraph.addEdge(3, 4);
        directedGraph.addEdge(4, 0);


        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(directedGraph, 4);

        System.out.println(depthFirstSearch.hasPathTo(0));

        System.out.println(depthFirstSearch.pathTo(0));

         */

        UndirectedGraph undirectedGraph = new UndirectedGraph(3);

        undirectedGraph.addEdge(0, 1);
        undirectedGraph.addEdge(1, 2);
        undirectedGraph.addEdge(0, 2);


        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(undirectedGraph, 0);

        depthFirstSearch.dfs(depthFirstSearch.start);

        System.out.println(depthFirstSearch.hasPathTo(2));

        System.out.println(depthFirstSearch.pathTo(2));

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(undirectedGraph, 0);

        breadthFirstSearch.bfs(breadthFirstSearch.start);

        System.out.println(breadthFirstSearch.hasPathTo(2));

        System.out.println(breadthFirstSearch.pathTo(2));



    }
}
