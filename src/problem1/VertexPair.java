package problem1;

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
