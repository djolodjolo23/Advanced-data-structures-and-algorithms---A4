package problem6;

import problem1.Graph;
import problem1.UndirectedGraph;
import problem2.DepthFirstSearch;

public class Main {

    public static void main(String[] args) {


        UndirectedGraph undirectedGraph = new UndirectedGraph(6);

        undirectedGraph.addEdge(0, 1);
        undirectedGraph.addEdge(1,2);
        undirectedGraph.addEdge(2,0);
        undirectedGraph.addEdge(2,3); // this edge is a bridge
        undirectedGraph.addEdge(3,4);
        undirectedGraph.addEdge(4,5);
        undirectedGraph.addEdge(5,3);


        BridgeFinder bridgeFinder = new BridgeFinder();

        System.out.println(bridgeFinder.isBridge(undirectedGraph, 0, 1));
        System.out.println(bridgeFinder.isBridge(undirectedGraph, 1, 2));
        System.out.println(bridgeFinder.isBridge(undirectedGraph, 2, 0));
        System.out.println(bridgeFinder.isBridge(undirectedGraph, 2, 3));
        System.out.println(bridgeFinder.isBridge(undirectedGraph, 3, 4));
        System.out.println(bridgeFinder.isBridge(undirectedGraph, 4, 5));
        System.out.println(bridgeFinder.isBridge(undirectedGraph, 5, 3));

    }
}
