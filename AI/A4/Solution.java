import java.util.*;

class Graph1 {
    Vertex vertices[];
    Edge edges[];

    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            weight = w;
        }

        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    };

    private class Vertex {
        int vertex, rank, parent;

        Vertex(int v, int r, int p) {
            vertex = v;
            rank = r;
            parent = p;
        }
    }

    int findRootParent(Vertex v[], int index) {
        if (v[index].parent != index)
            findRootParent(v, v[index].parent);

        return v[index].parent;
    }

    void Union(Vertex[] v, int s, int d) {
        int s_parent = findRootParent(v, s);
        int d_parent = findRootParent(v, d);

        if (v[s_parent].rank > v[d_parent].rank) {
            v[d_parent].parent = s_parent;
            v[s_parent].rank++;
        } else if (v[s_parent].rank < v[d_parent].rank) {
            v[s_parent].parent = d_parent;
            v[d_parent].rank++;
        } else {
            v[d_parent].parent = s_parent;
            v[s_parent].rank++;
        }
    }

    Graph1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices and edges : ");
        int v = sc.nextInt();
        int e = sc.nextInt();

        edges = new Edge[e];
        vertices = new Vertex[v];

        for (int i = 0; i < v; i++) {
            vertices[i] = new Vertex(i, 0, i);
        }
        for (int i = 0; i < e; i++) {
            System.out.print("Enter the source, destination and weight : ");
            int s = sc.nextInt();
            int d = sc.nextInt();
            int w = sc.nextInt();
            edges[i] = new Edge(s, d, w);
        }

        sc.close();
    }

    void MST() {
        int v = vertices.length;
        Edge result[] = new Edge[v - 1];
        int e_cnt = 0; // An index variable, used for result[]
        int r_cnt = 0; // An index variable, used for sorted edges
        for (int i = 0; i < v; ++i)
            result[i] = new Edge(i, 0, i);

        Arrays.sort(edges);
        int res = 0;
        while (e_cnt < v - 1) {
            Edge next_Edge = edges[e_cnt];

            int s_parent = findRootParent(vertices, next_Edge.src);
            int d_parent = findRootParent(vertices, next_Edge.dest);

            if (s_parent != d_parent) {
                result[r_cnt] = next_Edge;
                Union(vertices, s_parent, d_parent);
                r_cnt++;
                res += next_Edge.weight;
            }

            e_cnt++;
        }

        printEdges(result);
        System.out.println("The weight of MST is :" + res);
    }

    public static void main(String[] args) {
        Graph1 g = new Graph1();
        g.MST();
    }

    void printEdges(Edge e[]) {
        for (int i = 0; i < e.length; i++) {
            System.out.print("Source : " + e[i].src + " Destination :" + e[i].dest + " Weight :" + e[i].weight + "\n");
        }

    }
}