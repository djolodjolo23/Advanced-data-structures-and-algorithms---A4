package helpers;

/**
 * A pair of vertices used to represent an edge, used in the IteratorForPrinting.
 */
public record VertexPair(int first, int second) {

    @Override
    public String toString() {
        return "Edge from " +
                first +
                " to " + second +
                '.';
    }
}
