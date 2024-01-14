package problem2;

import problem1.DirectedGraph;
import problem1.UndirectedGraph;

import java.util.Arrays;

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

        UndirectedGraph undirectedGraph = new UndirectedGraph(15);

        undirectedGraph.addEdge(0, 2);
        undirectedGraph.addEdge(1, 3);
        undirectedGraph.addEdge(2, 3);
        undirectedGraph.addEdge(3, 4);
        undirectedGraph.addEdge(4, 5);
        undirectedGraph.addEdge(4, 6);
        undirectedGraph.addEdge(5, 6);
        undirectedGraph.addEdge(6, 7);
        undirectedGraph.addEdge(6, 10);
        undirectedGraph.addEdge(7, 8);
        undirectedGraph.addEdge(8, 9);
        undirectedGraph.addEdge(9, 10);
        undirectedGraph.addEdge(11, 12);
        undirectedGraph.addEdge(12, 13);
        undirectedGraph.addEdge(12, 14);



        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(undirectedGraph, 3);

        //System.out.println(depthFirstSearch.hasPathTo(2));

        System.out.println("Depth first search path to: " + depthFirstSearch.pathTo(8));

        //BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(undirectedGraph);
        //breadthFirstSearch.bfs(undirectedGraph.vertices.get(3));

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(undirectedGraph, 3);

        System.out.println("Breadth first search has path to: " + breadthFirstSearch.hasPathTo(5));

        System.out.println("Breadth first search path to: " + breadthFirstSearch.pathTo(8));

        System.out.println(Arrays.toString(breadthFirstSearch.edgeTo));


        //Results for dfs and bfs are exactly the same as the ones in the lecture slides.(Graphs lecture, page 48)
        // slide results for bfs:
        // [3, 4, 6, 7, 8]
        //[  2 3 3 0 3 4 4 6 7 10 6 0 0 0 0]
        // my results for bfs:
        // [3, 4, 6, 7, 8]
        //[2, 3, 3, 0, 3, 4, 4, 6, 7, 10, 6, 0, 0, 0, 0]


    }
}
