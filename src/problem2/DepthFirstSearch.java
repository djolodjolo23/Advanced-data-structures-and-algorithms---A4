package problem2;

import problem1.Edge;
import problem1.Graph;
import problem1.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepthFirstSearch {

    Vertex start;
    public boolean[] visited;

    public int[] visitedAt;
    protected final int[] edgeTo;

    private int visitedCounter = 0;


    /**
     * Starts the Depth-First Search right away.
     * @param g Graph to search in.
     * @param start Start vertex.
     */
    public DepthFirstSearch(Graph g, int start) {
        this.start = g.vertices.get(start);
        visited = new boolean[g.vertices.size()];
        visitedAt = new int[g.vertices.size()];
        edgeTo = new int[g.vertices.size()];
        dfs(this.start);
    }

    /**
     * Does not start the Depth-First Search right away, but can be started manually.
     * @param g Graph to search in.
     */
    public DepthFirstSearch(Graph g) {
        this.start = null;
        visited = new boolean[g.vertices.size()];
        visitedAt = new int[g.vertices.size()];
        edgeTo = new int[g.vertices.size()];
    }


    public void dfs(Vertex v) {
        if (start == null) {
            start = v;
        }
        visited[v.element] = true;
        visitedAt[v.element] = ++visitedCounter;
        for (Edge ew : v.al) {
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
