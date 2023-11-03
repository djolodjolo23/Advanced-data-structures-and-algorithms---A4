package problem1;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        UndirectedGraph ug = new UndirectedGraph(5);

        DirectedGraph dg = new DirectedGraph(5);

        ug.addEdge(0, 1);
        ug.addEdge(0, 2);
        //ug.addEdge(0, 3);

        //ug.removeEdge(0, 1);




       // I//teratorEdges<Graph.Edge> ie = new IteratorEdges<>(ug);

        IteratorEdgesForPrinting<Graph.Edge> ie;



        dg.addEdge(0, 1);
        dg.addEdge(0, 2);
        dg.addEdge(0, 3);

        for (Graph.Vertex v : dg.al) {
            List<Integer> edges = dg.getEdges(v.vertex);
            ie = new IteratorEdgesForPrinting<>(v.edges, v, edges);
            while (ie.hasNext()) {
                System.out.println(ie.next().toString());
            }
        }

        System.out.println("Edge count: " + ug.getEdgesCount());


        System.out.println("Vertex count: " + ug.getVertexCount());



    }
}
