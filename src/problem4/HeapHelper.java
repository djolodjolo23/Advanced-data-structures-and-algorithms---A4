package problem4;

import problem1.Edge;
import problem1.Graph;
import problem1.Vertex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/*
 * The HeapHelper class is used to create a heap array from a list of vertices.
 */
public class HeapHelper {

    public static Vertex[] createHeapArray(List<Vertex> vertices, int startIndex) {
        List<Vertex> heapList = new ArrayList<>();
        Set<Vertex> visited = new HashSet<>();

        traverseVertex(vertices.get(startIndex), heapList, visited);
        Vertex[] heapArray = new Vertex[heapList.size()];
        for (int i = 0; i < heapList.size(); i++) {
            heapArray[i] = heapList.get(i);
        }

        return heapArray;
    }

    private static void traverseVertex(Vertex vertex, List<Vertex> heapList, Set<Vertex> visited) {
        if (vertex != null && !visited.contains(vertex)) {
            heapList.add(vertex);
            visited.add(vertex);
            for (Edge edge : vertex.al) {
                traverseVertex(edge.targetVertex, heapList, visited);
            }
        }

    }

}
