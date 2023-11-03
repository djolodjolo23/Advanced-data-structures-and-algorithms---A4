package problem2;

import problem1.Graph;

import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearch {

    private Graph graph;
    private int start;

    private boolean[] visited;
    private int[] edgeTo;


    public BreadthFirstSearch(Graph g, int start) {
        this.graph = g;
        this.start = start;
        visited = new boolean[g.al.size()];
        edgeTo = new int[g.al.size()];
        //dfs(start);

    }

    /*
    private void dfs(int v) {
        visited[v] = true;
        for (int w : graph.al) {
            if (!visited[w]) {
                dfs(w);
            }
            edgeTo[w] = v;
        }
    }

     */

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
