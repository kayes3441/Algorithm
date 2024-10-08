/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class QuickUnioinLazyApproach {
    private int[] parent;

    public QuickUnioinLazyApproach(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
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
            parent[rootP] = rootQ;
        }
    }

    public static void main(String[] args) {
        QuickUnioinLazyApproach qu = new QuickUnioinLazyApproach(10);

        qu.union(0, 1);
        qu.union(1, 2);
        qu.union(3, 4);
        qu.union(4, 5);
        qu.union(0, 5);

        System.out.println(qu.find(3));
        System.out.println(qu.find(0));
    }
}
