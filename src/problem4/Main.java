package problem4;

import helpers.CSVExporter;
import helpers.Timer;
import problem1.DirectedGraph;
import problem1.Graph;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {




        DirectedGraph dg = new DirectedGraph(7);





        dg.addWeightedEdge(0, 1, 2);
        dg.addWeightedEdge(0, 3, 1);
        dg.addWeightedEdge(1, 3, -3);
        dg.addWeightedEdge(1, 4, 10);
        dg.addWeightedEdge(2, 0, 4);
        dg.addWeightedEdge(2, 5, 5);
        dg.addWeightedEdge(3, 2, 2);
        dg.addWeightedEdge(3, 4, 2);
        dg.addWeightedEdge(3, 5, 8);
        dg.addWeightedEdge(3, 6, 4);
        dg.addWeightedEdge(4, 6, 6);
        dg.addWeightedEdge(6, 5, 1);

        List<Graph.Vertex> vertices = new ArrayList<>(dg.vertices);


        Graph.Vertex[] heapArray = HeapHelper.createHeapArray(vertices, 0);

        Dijkstra dijkstra = new Dijkstra(new BinaryHeap<>(heapArray));


        dijkstra.findShortestPath(dg, 0);

        System.out.println();

        BellmanFord bellmanFord = new BellmanFord();

        bellmanFord.findShortestPath(dg, 0);




        //DirectedGraph dg = new DirectedGraph(5);

        Timer timer = new Timer();

        CSVExporter<Long> csvExporter = new CSVExporter<>();

        /*
        Graph.Vertex[] vertices = new Graph.Vertex[dg.vertices.size()];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = dg.vertices.get(i);
        }



        List<List<Long>> dijkstraAllTimes = new ArrayList<>();
        List<List<Long>> bellmanFordAllTimes = new ArrayList<>();

        for (int k = 0; k < 50; k++) {
            List<Long> dijkstraTimes = new ArrayList<>();
            List<Long> bellmanFordTimes = new ArrayList<>();
            for (int i = 20; i <= 2000; i += 20) {
                DirectedGraph directedGraph = new DirectedGraph(i);
                Graph.Vertex[] vertices = new Graph.Vertex[directedGraph.vertices.size()];
                for (int v = 0; v < vertices.length; v++) {
                    vertices[v] = directedGraph.vertices.get(v);
                }
                Dijkstra dijkstra = new Dijkstra(new BinaryHeap<>(vertices));
                BellmanFord bellmanFord = new BellmanFord();
                for (int j = 0; j < i; j++) {
                    directedGraph.addWeightedEdge(j, (j + 1) % i, 1);
                    directedGraph.addWeightedEdge(j, (j + 2) % i, 2);
                    directedGraph.addWeightedEdge(j, (j + 3) % i, 3);
                }
                dijkstraTimes.add(timer.timeItNanoTime(() -> dijkstra.findShortestPath(directedGraph, 0)));
                bellmanFordTimes.add(timer.timeItNanoTime(() -> bellmanFord.findShortestPath(directedGraph, 0)));
            }
            dijkstraAllTimes.add(dijkstraTimes);
            bellmanFordAllTimes.add(bellmanFordTimes);
        }

        List<Long> averageDijkstraTimes = timer.findAverageRunningTimeLong(dijkstraAllTimes);
        List<Long> averageBellmanFordTimes = timer.findAverageRunningTimeLong(bellmanFordAllTimes);

        csvExporter.exportDataToCSV(averageDijkstraTimes, "dijkstra.csv");
        csvExporter.exportDataToCSV(averageBellmanFordTimes, "bellmanFord.csv");

        /*
        ug.addWeightedEdge(0, 1, -1);
        ug.addWeightedEdge(0, 2, 4);
        ug.addWeightedEdge(1, 2, 3);
        ug.addWeightedEdge(1, 3, 2);
        ug.addWeightedEdge(1, 4, 2);
        ug.addWeightedEdge(3, 2, 5);
        ug.addWeightedEdge(3, 1, 1);
        ug.addWeightedEdge(4, 3, -3);





        BinaryHeap<Graph.Vertex> bh = new BinaryHeap<>(vertices);

        Dijkstra dijkstra = new Dijkstra(bh);

        BellmanFord bellmanFord = new BellmanFord();

        bellmanFord.findShortestPath(dg, 0);

        System.out.println();

        dijkstra.findShortestPath(dg, 0);

         */



    }
}
