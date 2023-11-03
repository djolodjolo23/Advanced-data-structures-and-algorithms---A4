package problem1;

import java.util.Iterator;
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

        /*
        for (Graph.Vertex v : dg.al) {
            List<Integer> edges = dg.getEdges(v.vertex);
            ie = new IteratorEdgesForPrinting<>(v.edges, v, edges);
            while (ie.hasNext()) {
                System.out.println(ie.next().toString());
            }
        }

         */

        Graph.Vertex v1 = dg.al.get(0);

        ie = new IteratorEdgesForPrinting<>(v1.edges, v1, dg.getEdges(v1.vertex));
        while (ie.hasNext()) {
            System.out.println(ie.next().toString());
        }


        for (Graph.Edge e : v1.edges) {
            System.out.println(e.targetVertex);
        }

        System.out.println("Edge count: " + dg.getEdgesCount());


        System.out.println("Vertex count: " + dg.getVertexCount());



    }
}
