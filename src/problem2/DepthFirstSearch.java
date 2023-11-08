package problem2;

import problem1.Edge;
import problem1.Graph;
import problem1.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepthFirstSearch {

    protected final Vertex start;
    protected boolean[] visited;
    protected final int[] edgeTo;


    public DepthFirstSearch(Graph g, int start) {
        this.start = g.vertices.get(start);
        visited = new boolean[g.vertices.size()];
        edgeTo = new int[g.vertices.size()];
    }


    protected void dfs(Vertex v) {
        visited[v.element] = true;
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
