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
        visited = new boolean[g.vertices.size()];
        edgeTo = new int[g.vertices.size()];
        dfs(start);

    }


    private void dfs(int v) {
        visited[v] = true;
        for (Graph.Vertex w : graph.vertices) {
            if (!visited[w.element]) {
                dfs(w.element);
            }
            edgeTo[w.element] = v;
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
