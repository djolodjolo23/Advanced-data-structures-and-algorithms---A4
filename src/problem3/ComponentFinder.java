package problem3;

import problem1.Edge;
import problem1.Graph;
import problem1.Vertex;
import problem2.DepthFirstSearch;

import java.util.*;

public class ComponentFinder extends DepthFirstSearch {

    public ComponentFinder(Graph g, int start) {
        super(g, start);
    }


    /**
     * Depth-First Search for finding connected components.
     * @param g Graph to search in.
     * @return List of connected components.
     */
    public List<List<Vertex>> findComponents(Graph g) {
        List<List<Vertex>> allComponents = new ArrayList<>();
        boolean[] visitedHere = new boolean[g.vertices.size()];
        Arrays.fill(visitedHere, false);
        for (Vertex v : g.vertices) {
            if (!visited[v.element]) {
                List<Vertex> components = new ArrayList<>();
                dfs(v);
                for (int i = 0; i < visited.length; i++) {
                    if (visited[i] && !visitedHere[i]) {
                        components.add(g.vertices.get(i));
                        visitedHere[i] = true;
                    }
                }
                allComponents.add(components);
            }
        }
        removeDoubleEdges(allComponents);
        return allComponents;
    }


    /*
    Removing edges that are in both directions
     */
    public void removeDoubleEdges(List<List<Vertex>> allComponents) {
        List<Tuple> tuples = new ArrayList<>();
        for (List<Vertex> component : allComponents) {
            for (Vertex v : component) {
                for (Edge e : v.al) {
                    Tuple t = new Tuple(e.sourceVertex.element, e.targetVertex.element);
                    if (!tuples.contains(t)) {
                        tuples.add(t);
                    } else {
                        v.al.remove(e);
                    }
                }
            }
        }
    }
}
