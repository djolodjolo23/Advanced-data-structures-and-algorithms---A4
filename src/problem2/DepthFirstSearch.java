package problem2;

import problem1.Graph;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

    private final Graph.Vertex start;
    private final boolean[] visited;
    private final int[] edgeTo;



    public DepthFirstSearch(Graph g, int start) {
        this.start = g.vertices.get(start);
        visited = new boolean[g.vertices.size()];
        edgeTo = new int[g.vertices.size()];
        run(g);
    }


    private void run(Graph g) {
        for (Graph.Vertex v : g.vertices) {
            if (!visited[v.element]) {
                dfs(v);
            }
        }
    }

    private void dfs(Graph.Vertex v) {
        visited[v.element] = true;
        for (Graph.Edge ew : v.al) {
            if (!visited[ew.targetVertex.element]) {
                edgeTo[ew.targetVertex.element] = v.element;
                dfs(ew.targetVertex);
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
        while (x != start.element) {
            path.add(0, x);
            x = edgeTo[x];
        }
        path.add(0, start.element);
        return path;
    }
}
