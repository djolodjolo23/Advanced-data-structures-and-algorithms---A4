package problem5;

import problem1.DirectedGraph;
import problem1.Graph;
import problem1.Vertex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class GraphCreator {

    private final Map<String, Integer> courseIdToNumber;
    private final DirectedGraph graph;

    public GraphCreator() {
        courseIdToNumber = new HashMap<>();
        graph = new DirectedGraph(0); // empty graph initially
    }

    /**
     * Creates a graph from a text file.
     * @param text the text file.
     * @return the graph.
     */
    public Graph createGraph(String text) {
        AtomicInteger courseNumber = new AtomicInteger();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(text))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] split = line.split(";");
                String sourceCourse = split[0];
                String targetCourse = split[1];

                int sourceNumber = courseIdToNumber.computeIfAbsent(sourceCourse, s -> courseNumber.getAndIncrement());
                int targetNumber = courseIdToNumber.computeIfAbsent(targetCourse, t -> courseNumber.getAndIncrement());

                Vertex source = new Vertex(sourceNumber);
                Vertex target = new Vertex(targetNumber);

                if (!graph.vertices.contains(source)) {
                    graph.vertices.add(source);
                }
                if (!graph.vertices.contains(target)) {
                    graph.vertices.add(target);
                }
                graph.addEdge(targetNumber, sourceNumber);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return graph;
    }

    public Map<String, Integer> getCourseIdToNumber() {
        return courseIdToNumber;
    }
}
