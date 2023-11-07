package problem2;

import problem1.Graph;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

    private final Graph.Vertex start;
    private final boolean[] visited;
    private final int[] edgeTo;

    private List<Integer> prerequisites = new ArrayList<>(); // used in a problem 5


    public DepthFirstSearch(Graph g, int start) {
        this.start = g.vertices.get(start);
        visited = new boolean[g.vertices.size()];
        edgeTo = new int[g.vertices.size()];
        exploreGraph(g);
    }


    private void exploreGraph(Graph g) {
        for (Graph.Vertex v : g.vertices) {
            dfs(v);
        }
    }

    private void dfs(Graph.Vertex v) {
        visited[v.element] = true;
        for (Graph.Edge ew : v.al) {
            if (!visited[ew.targetVertex.element]) {
                edgeTo[ew.targetVertex.element] = v.element;
                dfs(ew.targetVertex);
            }
            if (!prerequisites.contains(ew.targetVertex.element)) { // used in a problem 5
                prerequisites.add(ew.targetVertex.element);
            }
        }
    }

    public List<Integer> getPrerequisites() {
        return prerequisites;
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
