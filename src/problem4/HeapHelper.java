package problem4;

import problem1.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/*
    * The HeapHelper class is used to create a heap array from a list of vertices.
 */
public class HeapHelper {

    public static Graph.Vertex[] createHeapArray(List<Graph.Vertex> vertices, int startIndex) {
        List<Graph.Vertex> heapList = new ArrayList<>();
        Set<Graph.Vertex> visited = new HashSet<>();

        traverseVertex(vertices.get(startIndex), heapList, visited);
        Graph.Vertex[] heapArray = new Graph.Vertex[heapList.size()];
        for (int i = 0; i < heapList.size(); i++) {
            heapArray[i] = heapList.get(i);
        }

        return heapArray;
    }

    private static void traverseVertex(Graph.Vertex vertex, List<Graph.Vertex> heapList, Set<Graph.Vertex> visited) {
        if (vertex != null && !visited.contains(vertex)) {
            heapList.add(vertex);
            visited.add(vertex);
            for (Graph.Edge edge : vertex.al) {
                traverseVertex(edge.targetVertex, heapList, visited);
            }
        }

    }

}
