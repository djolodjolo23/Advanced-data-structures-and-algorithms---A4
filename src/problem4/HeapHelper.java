package problem4;

import problem1.Graph;
import problem1.Vertex;
import problem2.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;


/*
 * The HeapHelper class is used to create a heap array from a list of vertices.
 */
public class HeapHelper extends DepthFirstSearch {


    public HeapHelper(Graph g, int start) {
        super(g, start);
    }


    public Vertex[] createHeapArray(List<Vertex> vertices, int startIndex) {
        List<Vertex> heapList = new ArrayList<>();
        dfs(vertices.get(startIndex));
        for (int i = 0; i < vertices.size(); i++) {
            if (visitedAt[i] != 0) {
                heapList.add(vertices.get(i));
            }
        }
        heapList.sort((o1, o2) -> visitedAt[o1.element] - visitedAt[o2.element]);
        Vertex[] heapArray = new Vertex[heapList.size()];
        for (int i = 0; i < heapList.size(); i++) {
            heapArray[i] = heapList.get(i);
        }
        return heapArray;
    }


}
