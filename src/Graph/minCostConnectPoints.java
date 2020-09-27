package Graph;

/**
 * @Auther: 99615
 * @Date: 2020/9/13 16:25
 * @Description:
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * 输出：20
 * 解释：
 *
 * 我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
 * 注意到任意两个点之间只有唯一一条路径互相到达。
 */
public class minCostConnectPoints {
    static class Edge {
        int src;
        int dst;
        int weight;
        public Edge(int source, int destination, int weight) {
            this.src = source;
            this.dst = destination;
            this.weight = weight;
        }
    }
    int vertices;
    ArrayList<Edge> edges = new ArrayList<>();
    int minCost = 0;

    private int calcWeight(int[] a, int[] b) {
        return Math.abs(a[0]-b[0]) + Math.abs((a[1]-b[1]));
    }
    public int minCostConnectPoints(int[][] points) {
        if (points.length == 1)
            return 0;
        this.vertices = points.length;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int weight = calcWeight(points[i], points[j]);
                edges.add(new Edge(i, j, weight));
            }
        }
        kruskalMST();
        return minCost;
    }
    private void kruskalMST() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(edges.size(), Comparator.comparingInt(o->o.weight));
        pq.addAll(edges);

        int[] parent = new int[vertices];

        makeSet(parent);

        int index = 0;
        while (index < vertices - 1) {
            Edge edge = pq.remove();

            int x_set = find(parent, edge.src);
            int y_set = find(parent, edge.dst);

            if (x_set == y_set) {

            } else {
                minCost += edge.weight;
                index++;
                union(parent, x_set, y_set);
            }
        }

    }

    public void makeSet(int[] parent) {
        //Make set- creating a new element with a parent pointer to itself.
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }
    }

    public int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            return find(parent, parent[vertex]);
        }
        return vertex;
    }

    public void union(int[] parent, int x, int y) {
        int x_set_parent = find(parent, x);
        int y_set_parent = find(parent, y);

        //make x as parent of y
        parent[y_set_parent] = x_set_parent;
    }

    public static void main(String[] args) {
        minCostConnectPoints solve = new minCostConnectPoints();

        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        int res = solve.minCostConnectPoints(points);
        System.out.println(res);
    }
}
