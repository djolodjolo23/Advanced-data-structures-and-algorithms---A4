package problem2;

import problem1.Graph;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

    private Graph graph;
    private int start;

    private boolean[] visited;
    private int[] edgeTo;


    public DepthFirstSearch(Graph g, int start) {
        this.graph = g;
        this.start = start;
        visited = new boolean[g.vertices.size()];
        edgeTo = new int[g.vertices.size()];
        dfs(start);
    }


    private void dfs(Graph.Edge e) { // edges must be used
        v.visited = true;
        for (Graph.Edge ew : v.al) {
            if (!ew.visited) {
                dfs(ew);
            }
        }
    }


    public boolean hasPathTo(int v) {
        return visited[v];
    }

    public List<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        int x = v;
        List<Integer> path = new ArrayList<>();
        while (x != start) {
            path.add(0, x);
            x = edgeTo[x];
        }
        path.add(0, start);
        return path;
    }
}
