package problem1;

/**
 * A pair of vertices used to represent an edge, used in the IteratorForPrinting.
 */
public class VertexPair {
    private final int first;
    private final int second;

    public VertexPair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Edge from " +
                first +
                " to " + second +
                '.';
    }
}
