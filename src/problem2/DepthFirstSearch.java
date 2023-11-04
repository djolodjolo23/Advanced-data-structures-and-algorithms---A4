package problem2;

import problem1.Graph;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

    private Graph graph;
    private Graph.Vertex start;
    private boolean[] visited;
    private int[] edgeTo;


    public DepthFirstSearch(Graph g, int start) {
        this.graph = g;
        this.start = g.vertices.get(start);
        visited = new boolean[g.vertices.size()];
        edgeTo = new int[g.vertices.size()];
        dfs(this.start);
    }



    private void dfs(Graph.Vertex v) {
        visited[v.element] = true;
        for (Graph.Edge ew : v.al) {
            if (!visited[ew.targetVertex.element]) {
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
        int x = v; // end
        List<Integer> path = new ArrayList<>(); // list for the path
        while (x != start.element) { // while the end is not the start
            path.add(0, x); // add the end to the list
            x = edgeTo[x]; // set the end to the next element in the path
        }
        path.add(0, start.element);
        return path;
    }
}
