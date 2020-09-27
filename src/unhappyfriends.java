import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 99615
 * @Date: 2020/9/13 11:16
 * @Description:
 */
public class unhappyfriends {
    public static int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int rows = pairs.length;
        int ans = 0;
        Map<String, Integer> pref = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                String key = i + "-" + preferences[i][j];
                int val = n - j;
                pref.put(key, val);
            }
        }
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        for (int i = 0; i < rows; i++) {
            int x = pairs[i][0];
            int y = pairs[i][1];
            for (int j = i+1; j < rows; j++) {
                int u = pairs[j][0];
                int v = pairs[j][1];
                int ansX = 0, ansY = 0, ansU = 0, ansV = 0;
                if (!visited[x] && pref.get(x+"-"+u) > pref.get(x+"-"+y) && pref.get(u+"-"+x) > pref.get(u+"-"+v)) {
                    ansX++;
                    visited[x] = true;
                }

                if (!visited[x] && pref.get(x+"-"+v) > pref.get(x+"-"+y) && pref.get(v+"-"+x) > pref.get(v+"-"+u)) {
                    ansX++;
                    visited[x] = true;
                }

                if (!visited[y] && pref.get(y+"-"+u) > pref.get(y+"-"+x) && pref.get(u+"-"+y) > pref.get(u+"-"+v)) {
                    ansY++;
                    visited[y] = true;
                }

                if (!visited[y] && pref.get(y+"-"+v) > pref.get(y+"-"+x) && pref.get(v+"-"+y) > pref.get(v+"-"+u)) {
                    ansY++;
                    visited[y] = true;
                }

                if (!visited[u] && pref.get(u+"-"+x) > pref.get(u+"-"+v) && pref.get(x+"-"+u) > pref.get(x+"-"+y)) {
                    ansU++;
                    visited[u] = true;
                }

                if (!visited[u] && pref.get(u+"-"+y) > pref.get(u+"-"+v) && pref.get(y+"-"+u) > pref.get(y+"-"+x)) {
                    ansU++;
                    visited[u] = true;
                }

                if (!visited[v] && pref.get(v+"-"+x) > pref.get(v+"-"+u) && pref.get(x+"-"+v) > pref.get(x+"-"+y)) {
                    ansV++;
                    visited[v] = true;
                }

                if (!visited[v] && pref.get(v+"-"+y) > pref.get(v+"-"+u) && pref.get(y+"-"+v) > pref.get(y+"-"+x)) {
                    ansV++;
                    visited[v] = true;
                }


                ans += Math.min(1, ansX) + Math.min(1, ansY) + Math.min(1, ansU) + Math.min(1, ansV);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] pref =  {{1,3,2},{2,3,0},{1,0,3},{1,0,2}};
        int[][] pairs = {{2,1},{3,0}};
        int n = 4;
        unhappyFriends(n, pref, pairs);
    }
}
