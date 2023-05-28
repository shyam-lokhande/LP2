import java.util.*;

public class Graph3 {
    int V, E;
    Vertex vertices[];
    Edge edges[];

    private class Vertex {
        int rank, parent;
    }

    private class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the source,destinatioon and weight of edge : ");
            src = sc.nextInt();
            dest = sc.nextInt();
            weight = sc.nextInt();
        }

        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }

    Graph3() {
        System.out.print("Enter the number of vertices and edges : ");
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();

        vertices = new Vertex[V];
        edges = new Edge[E];

        for (int i = 0; i < V; i++) {
            vertices[i] = new Vertex();
            vertices[i].rank = 0;
            vertices[i].parent = i;
        }

        for (int i = 0; i < E; i++) {
            edges[i] = new Edge();
        }
    }

    int findParent(Vertex[] v, int index) {
        if (v[index].parent != index)
            findParent(v, v[index].parent);
        return v[index].parent;
    }

    void union(Vertex[] v, int s, int d) {
        int sr = findParent(v, s);
        int dr = findParent(v, d);

        if (v[sr].rank > v[dr].rank) {
            v[dr].parent = sr;
        } else if (v[sr].rank < v[dr].rank) {
            v[sr].parent = dr;
        } else {
            v[dr].parent = sr;
            v[sr].rank++;
        }
    }

    void MST() {
        Edge[] mst = new Edge[V - 1];
        int mst_cnt = 0;
        int e_cnt = 0;

        Arrays.sort(edges);
        int res = 0;

        while (e_cnt < V - 1) {
            Edge next_edge = edges[e_cnt++];

            int sr = findParent(vertices, next_edge.src);
            int dr = findParent(vertices, next_edge.dest);

            if (sr != dr) {
                mst[mst_cnt++] = next_edge;
                union(vertices, sr, dr);
                res += next_edge.weight;
            }
        }

        printEdges(mst);
        System.out.print("Weight of mst is : " + res);
    }

    void printEdges(Edge[] e) {
        for (Edge edge : e) {
            System.out.print("Source : " + edge.src + " Destination :" + edge.dest + " Weight :" + edge.weight + "\n");
        }
    }

    public static void main(String[] args) {
        Graph3 g = new Graph3();
        g.MST();
    }
}