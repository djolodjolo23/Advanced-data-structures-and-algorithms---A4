package problem6;

import problem1.Graph;
import problem1.UndirectedGraph;
import problem2.BreadthFirstSearch;
import problem2.DepthFirstSearch;

public class BridgeFinder extends DepthFirstSearch {// Or BreadthFirstSearch. It works with both.


    public BridgeFinder(UndirectedGraph g, int start) {
        super(g, start);
    }


    public boolean isBridge(Graph g, int from, int to) {
        g.removeEdge(from, to);
        super.visited = new boolean[g.vertices.size()];
        super.dfs(g.vertices.get(from)); // or super.bfs(g.vertices.get(from));
        boolean isBridge = !visited[to];
        g.addEdge(from, to);
        return isBridge;
    }
}
