package helpers;

public class Tuple {

    int first;

    int second;

    public Tuple(int first, int second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Used to compare edges in both directions.
     * @param object Edge to compare to.
     * @return True if edges are equal in both directions.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Tuple tuple)) return false;
        return (first == tuple.first && second == tuple.second) || (first == tuple.second && second == tuple.first);
    }
}
