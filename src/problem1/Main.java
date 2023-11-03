package problem1;

public class Main {

    public static void main(String[] args) {

        UndirectedGraph ug = new UndirectedGraph(5);

        DirectedGraph dg = new DirectedGraph(5);

        ug.addEdge(0, 1);
        ug.addEdge(0, 2);

        IteratorVertex iv = new IteratorVertex(ug);

        IteratorEdges<Graph.Edge> ie = new IteratorEdges<>(ug);

        while (iv.hasNext()) {
            System.out.println(iv.next().vertex);
        }

        ug.removeEdge(0, 1);

        dg.addEdge(0, 1);
        dg.addEdge(0, 2);
        dg.removeEdge(0, 1);

        System.out.println("Edge count: " + ug.getEdgesCount());


        System.out.println("Vertex count: " + ug.getVertexCount());



    }
}
