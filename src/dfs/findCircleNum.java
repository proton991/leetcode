package dfs;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

/**
 * @Auther: 99615
 * @Date: 2020/9/14 15:00
 * @Description:
 */
public class findCircleNum {
    int circleNum = 0;
    int n;
    Map<Integer, List<Integer>> map;
    boolean[] visited;

    public int findCircleNum(int[][] M) {
        n = M.length;
        visited = new boolean[n];
        Arrays.fill(visited, false);
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1 && i != j) {
                    List<Integer> tmp = map.get(i);
                    tmp.add(j);
                    map.put(i, tmp);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                circleNum++;
            }

        }
        return circleNum;

    }

    public void dfs(int i) {
        List<Integer> list = map.get(i);
        visited[i] = true;
        for (int j = 0; j < list.size(); j++) {
            if (!visited[list.get(j)]) {
                visited[list.get(j)] = true;
                dfs(list.get(j));
            }
        }
    }

    public static void main(String[] args) {
        findCircleNum solve = new findCircleNum();
        int[][] M = {{1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}};
        System.out.println(solve.findCircleNum(M));
    }
}
