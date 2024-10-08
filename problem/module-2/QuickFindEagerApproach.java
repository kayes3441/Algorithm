public class QuickFindEagerApproach {
    private int[] id;

    public QuickFindEagerApproach(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[p] == pid) {
                id[i] = qid;
            }

        }
    }

    public static void main(String[] args) {
        QuickFindEagerApproach qf = new QuickFindEagerApproach(10);
        qf.union(1, 2);
        qf.union(3, 4);
        qf.union(4, 5);
        qf.union(2, 5);

        System.out.println(qf.connected(1, 5));
        System.out.println(qf.connected(3, 6));
    }
}
