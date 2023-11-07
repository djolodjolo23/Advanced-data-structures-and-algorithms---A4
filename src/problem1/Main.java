package problem1;

import problem1.iterators.IteratorEdges;

public class Main {

    public static void main(String[] args) {

        UndirectedGraph ug = new UndirectedGraph(5);

        DirectedGraph dg = new DirectedGraph(5);

        ug.addEdge(0, 1);
        ug.addEdge(0, 2);
        //ug.addEdge(0, 3);

        //ug.removeEdge(0, 1);




       // I//teratorEdges<Graph.Edge> ie = new IteratorEdges<>(ug);

        IteratorEdges ie;



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

        Graph.Vertex v1 = dg.vertices.get(0);

        ie = new IteratorEdges(dg);
        while (ie.hasNext()) {
            System.out.println(ie.next().toString());
        }


        for (Graph.Edge e : v1.al) {
            System.out.print(e.targetVertex.element + " ");
        }

        System.out.println();

        System.out.println("Edge count: " + dg.getEdgesCount());


        System.out.println("Vertex count: " + dg.getVertexCount());



    }
}
