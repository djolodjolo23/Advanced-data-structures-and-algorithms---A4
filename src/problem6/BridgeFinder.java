package problem6;

import problem1.Graph;
import problem1.UndirectedGraph;
import problem2.DepthFirstSearch;

public class BridgeFinder {



    public boolean isBridge(Graph g, int from, int to) {
        DepthFirstSearch dfs = new DepthFirstSearch(g); // or bfs(g);
        g.removeEdge(from, to);
        dfs.visited = new boolean[g.vertices.size()];
        dfs.dfs(g.vertices.get(from)); // or bfs(g.vertices.get(from));
        boolean isBridge = !dfs.visited[to];
        g.addEdge(from, to);
        return isBridge;
    }
}
