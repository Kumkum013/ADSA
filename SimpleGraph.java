
import java.util.*;

public class SimpleGraph {

    int n;             // number of vertices
    int[][] cost;      // adjacency matrix

    public SimpleGraph(int n) {
        this.n = n;
        cost = new int[n][n];
    }

    // Add edge
    public void addEdge(int u, int v, int w) {
        cost[u][v] = w;
        cost[v][u] = w;
    }

    // Prim's Algorithm
    public void prims() {
        int[] parent = new int[n];
        int[] key = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(key, 9999);
        key[0] = 0;
        parent[0] = -1;

        for (int c = 0; c < n - 1; c++) {
            int u = minKey(key, visited);
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (cost[u][v] != 0 && !visited[v] && cost[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = cost[u][v];
                }
            }
        }

        System.out.println("\nPrim's Minimum Spanning Tree:");
        System.out.println("Edge \tWeight");
        for (int i = 1; i < n; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + cost[i][parent[i]]);
        }
    }

    private int minKey(int[] key, boolean[] visited) {
        int min = 9999, idx = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && key[i] < min) {
                min = key[i];
                idx = i;
            }
        }
        return idx;
    }

    // BFS
    public void bfs(int start) {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        enqueue(q, start);

        System.out.print("\nBFS Traversal: ");
        while (!q.isEmpty()) {
            int u = dequeue(q);
            System.out.print(u + " ");

            for (int v = 0; v < n; v++) {
                if (cost[u][v] != 0 && !visited[v]) {
                    visited[v] = true;
                    enqueue(q, v);
                }
            }
        }
        System.out.println();
    }

    // Enqueue
    private void enqueue(Queue<Integer> q, int val) {
        q.add(val);
    }

    // Dequeue
    private int dequeue(Queue<Integer> q) {
        return q.poll();
    }

    // Main Program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();
        SimpleGraph g = new SimpleGraph(v);

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        System.out.println("Enter edges (u v weight):");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            int wt = sc.nextInt();
            g.addEdge(u, w, wt);
        }

        g.prims();

        System.out.print("\nEnter start vertex for BFS: ");
        int start = sc.nextInt();
        g.bfs(start);
    }
}

