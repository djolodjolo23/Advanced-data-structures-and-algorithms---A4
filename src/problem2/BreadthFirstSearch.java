package problem2;

import problem1.Edge;
import problem1.Graph;
import problem1.MyLinkedList;
import problem1.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BreadthFirstSearch {

    final Vertex start;
    protected boolean[] visited;

    protected int[] visitedAt;
    protected final int[] edgeTo;

    private int visitedCounter = 0;


    public BreadthFirstSearch(Graph g, int start) {
        this.start = g.vertices.get(start);
        visited = new boolean[g.vertices.size()];
        visitedAt = new int[g.vertices.size()];
        edgeTo = new int[g.vertices.size()];
    }

    protected void bfs(Vertex v) {
        MyLinkedList<Vertex> q = new MyLinkedList<>();
        q.addLast(v);
        visited[v.element] = true;
        visitedAt[v.element] = ++visitedCounter;
        while (!q.isEmpty()) {
            Vertex vertex = q.removeAndReturnFirst();
            for (Edge ew : vertex.al) {
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
