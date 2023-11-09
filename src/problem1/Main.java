package problem1;

import problem1.iterators.IteratorAdjacency;
import problem1.iterators.IteratorEdges;
import problem1.iterators.IteratorVertices;

public class Main {

    public static void main(String[] args) {

        UndirectedGraph ug = new UndirectedGraph(5);

        DirectedGraph dg = new DirectedGraph(5);

        ug.addEdge(0, 1);
        ug.addEdge(0, 2);
        //ug.addEdge(0, 3);

        //ug.removeEdge(0, 1);




       // I//teratorEdges<Graph.Edge> ie = new IteratorEdges<>(ug);




        dg.addEdge(0, 1);
        dg.addEdge(0, 2);
        dg.addEdge(0, 3);
        dg.addEdge(2, 0);

        /*
        for (Graph.Vertex v : dg.al) {
            List<Integer> edges = dg.getEdges(v.vertex);
            ie = new IteratorEdgesForPrinting<>(v.edges, v, edges);
            while (ie.hasNext()) {
                System.out.println(ie.next().toString());
            }
        }

         */


        IteratorEdges ie = new IteratorEdges(dg);
        while (ie.hasNext()) {
            System.out.println(ie.next().toString());
        }
        System.out.println();


        IteratorVertices iv = new IteratorVertices(dg);
        while (iv.hasNext()) {
            System.out.println(iv.next().element.toString());
        }
        System.out.println();

        IteratorAdjacency<Edge> iea = new IteratorAdjacency<>(dg.vertices.get(0).al);

        while (iea.hasNext()) {
            System.out.println(iea.next().targetVertex.element.toString());
        }
        System.out.println();






    }
}
