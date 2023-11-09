package problem4;

import problem1.Graph;
import problem1.Vertex;
import problem2.DepthFirstSearch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/*
 * The HeapHelper class is used to create a heap array from a list of vertices.
 */
public class HeapHelper{

    private final Graph g;

    public HeapHelper(Graph g) {
        this.g = g;
    }


    public Vertex[] createHeapArray(List<Vertex> vertices, int startIndex) {
        DepthFirstSearch dfs = new DepthFirstSearch(g);
        List<Vertex> heapList = new ArrayList<>();
        dfs.dfs(vertices.get(startIndex));
        for (int i = 0; i < vertices.size(); i++) {
            if (dfs.visitedAt[i] != 0) {
                heapList.add(vertices.get(i));
            }
        }
        heapList.sort(Comparator.comparingInt(o -> dfs.visitedAt[o.element]));
        Vertex[] heapArray = new Vertex[heapList.size()];
        for (int i = 0; i < heapList.size(); i++) {
            heapArray[i] = heapList.get(i);
        }
        return heapArray;
    }


}
