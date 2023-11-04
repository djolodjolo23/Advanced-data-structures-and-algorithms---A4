package problem2;

import problem1.Graph;

import java.util.ArrayList;
import java.util.List;

import java.util.*;

public class BreadthFirstSearch {

    private Graph graph;
    private Graph.Vertex start;

    private boolean[] visited;
    private int[] edgeTo;

    public BreadthFirstSearch(Graph g, int start) {
        this.graph = g;
        this.start = g.vertices.get(start);
        visited = new boolean[g.vertices.size()];
        edgeTo = new int[g.vertices.size()];
        bfs(this.start);
    }

    private void bfs(Graph.Vertex v) {
        Queue<Graph.Vertex> queue = new LinkedList<>();
        queue.add(v);
        visited[v.element] = true;
        while (!queue.isEmpty()) {
            Graph.Vertex vertex = queue.remove();
            for (Graph.Edge ew : vertex.al) {
                if (!visited[ew.targetVertex.element]) {
                    queue.add(ew.targetVertex);
                    visited[ew.targetVertex.element] = true;
                    edgeTo[ew.targetVertex.element] = vertex.element;
                }
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
        List<Integer> path = new ArrayList<>();
        for (int x = v; x != start.element; x = edgeTo[x]) {
            path.add(x);
        }
        path.add(start.element);
        Collections.reverse(path);
        return path;
    }

}
