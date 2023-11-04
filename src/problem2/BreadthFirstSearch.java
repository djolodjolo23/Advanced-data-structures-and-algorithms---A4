package problem2;

import problem1.Graph;
import problem1.MyLinkedList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BreadthFirstSearch {

    private final Graph.Vertex start;
    private final boolean[] visited;
    private final int[] edgeTo;

    public BreadthFirstSearch(Graph g, int start) {
        this.start = g.vertices.get(start);
        visited = new boolean[g.vertices.size()];
        edgeTo = new int[g.vertices.size()];
        bfs(this.start);
    }

    private void bfs(Graph.Vertex v) {
        MyLinkedList<Graph.Vertex> q = new MyLinkedList<>();
        q.addLast(v);
        visited[v.element] = true;
        while (!q.isEmpty()) {
            Graph.Vertex vertex = q.removeAndReturnFirst();
            for (Graph.Edge ew : vertex.al) {
                if (!visited[ew.targetVertex.element]) {
                    q.addLast(ew.targetVertex);
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
