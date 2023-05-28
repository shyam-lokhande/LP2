
public class Solution {
    public static void main(String[] args) {
        Graph3 g = new Graph3();
        g.q.add(1);
        g.visited[1] = true;
        g.BFS(5);
        g.printPath(5);
    }
}
