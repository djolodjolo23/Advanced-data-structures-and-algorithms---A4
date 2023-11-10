package problem3;



public class PCUnionFind{
    private int[] parent;
    private int[] size;


    public PCUnionFind() {
    }


    public int[] getParent() {
        return parent;
    }

    public int[] getSize() {
        return size;
    }

    public boolean connected(int a, int b) {
        return parent[a] == parent[b];
    }

    public int findRoot (int element) {
        while (element != parent[element]) {
            parent[element] = parent[parent[element]];
            element = parent[element];
        }
        return element;
    }

    public void makeUnion(int element_a, int element_b) {
        int root_a = findRoot(element_a);
        int root_b = findRoot(element_b);

        if (size[root_a] < size[root_b]) {
            parent[root_a] = root_b;
            size[root_b] += size[root_a];
        } else {
            parent[root_b] = root_a;
            size[root_a] += size[root_b];
        }
    }

    public void initWithSpecificNums(int[] parent) {
        this.parent = parent;
        this.size = new int[parent.length];
        for (int i = 0; i < parent.length; i++) {
            this.size[i] = 1;
        }
    }

    public void init(int num) {
        this.parent = new int[num];
        this.size = new int[parent.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
}