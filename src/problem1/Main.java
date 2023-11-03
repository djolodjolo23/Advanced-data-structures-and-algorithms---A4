package problem1;

public class Main {

    public static void main(String[] args) {

        UndirectedGraph ug = new UndirectedGraph(5);

        DirectedGraph dg = new DirectedGraph(5);

        ug.addEdge(0, 1);
        ug.addEdge(0, 2);
        ug.addEdge(0, 3);

        ug.removeEdge(0, 1);



        //IteratorVertex iv = new IteratorVertex(ug);

       // I//teratorEdges<Graph.Edge> ie = new IteratorEdges<>(ug);

        //while (iv.hasNext()) {
       //     System.out.println(iv.next().vertex);
        //}


        dg.addEdge(0, 1);
        dg.addEdge(0, 2);
        dg.addEdge(0, 3);

        System.out.println("Edge count: " + ug.getEdgesCount());


        System.out.println("Vertex count: " + ug.getVertexCount());



    }
}
