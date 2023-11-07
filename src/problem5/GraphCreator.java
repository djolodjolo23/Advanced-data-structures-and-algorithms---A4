package problem5;

import problem1.DirectedGraph;
import problem1.Graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphCreator {

    private Map<String, Integer> courseIdToHashCode; // Map course IDs to hashcodes
    private DirectedGraph graph;

    public GraphCreator() {
        courseIdToHashCode = new HashMap<>();
        graph = new DirectedGraph(0);
    }

    public Graph createGraph(String text) {
        List<Graph.Vertex> vertices = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(text))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(";");
                String sourceCourse = split[0];
                String targetCourse = split[1];

                // Check if the source course is already in the map, and assign a hashcode if not
                int sourceHashCode = courseIdToHashCode.computeIfAbsent(sourceCourse, String::hashCode);

                // Check if the target course is already in the map, and assign a hashcode if not
                int targetHashCode = courseIdToHashCode.computeIfAbsent(targetCourse, String::hashCode);

                Graph.Vertex source = new Graph.Vertex(split[0].hashCode());
                Graph.Vertex target = new Graph.Vertex(split[1].hashCode());
                if (!vertices.contains(source)) {
                    vertices.add(source);
                }
                if (!vertices.contains(target)) {
                    vertices.add(target);
                }
                graph.addEdge(sourceHashCode, targetHashCode);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return graph;
    }
}
