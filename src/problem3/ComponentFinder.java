package problem3;

import helpers.Tuple;
import problem1.Edge;
import problem1.Graph;
import problem1.Vertex;
import problem2.DepthFirstSearch;

import java.util.*;

public class ComponentFinder extends DepthFirstSearch {

    public ComponentFinder(Graph g) {
        super(g);
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
        return allComponents;
    }

    public Vertex getMaxVertex(List<Vertex> connectedComponent) {
        Vertex max = connectedComponent.get(0);
        for (Vertex v : connectedComponent) {
            if (v.element > max.element) {
                max = v;
            }
        }
        return max;
    }
}
