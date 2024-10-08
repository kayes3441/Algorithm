/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class WeightedQuickUnion {
    private int[] parent;
    private int[] size;

    public WeightedQuickUnion(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP != rootQ) {
            if (size[rootP] < size[rootQ]) {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            else {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
        }
    }

    // Test the WeightedQuickUnion algorithm
    public static void main(String[] args) {
        WeightedQuickUnion wqu = new WeightedQuickUnion(10);

        wqu.union(0, 1);
        wqu.union(2, 3);
        wqu.union(0, 2);

        System.out.println(wqu.find(1));  // 0
        System.out.println(wqu.find(3));  // 0
    }
}
