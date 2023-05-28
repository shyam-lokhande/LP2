import java.util.*;

public class Graph3 {
    int V, E;
    int mat[][];
    boolean visited[];
    int parent[];
    Queue<Integer> q = new LinkedList<Integer>();
    Stack<Integer> s = new Stack<Integer>();

    Graph3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices and edges : ");
        V = sc.nextInt();
        E = sc.nextInt();

        mat = new int[V][V];
        visited = new boolean[V];
        parent = new int[V];

        for (int i = 0; i < V; i++) {
            Arrays.fill(mat[i], 0);
            parent[i] = i;
        }
        Arrays.fill(visited, false);

        for (int i = 0; i < E; i++) {
            System.out.print("Enter the source and destination of the edge : ");
            int s = sc.nextInt();
            int d = sc.nextInt();

            mat[s][d] = mat[d][s] = 1;
        }
    }

    void BFS(int target) {
        if (q.isEmpty())
            return;

        int node = q.poll();
        if (node == target) {
            System.out.println("We found the path!!");
        }

        for (int i = 0; i < V; i++) {
            if (mat[node][i] != 0 && visited[i] == false) {
                visited[i] = true;
                q.add(i);
                parent[i] = node;
            }
        }

        BFS(target);
    }

    void printPath(int target) {
        if (parent[target] != target) {
            printPath(parent[target]);
        }
        System.out.print(target + "-->");
    }
}
