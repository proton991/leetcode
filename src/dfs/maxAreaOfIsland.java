package dfs;

/**
 * @Auther: 99615
 * @Date: 2020/9/14 11:43
 * @Description:
 */
public class maxAreaOfIsland {
    static int R = 0, C = 0;
    public static int maxAreaOfIsland(int[][] grid) {
        R = grid.length;
        C = grid[0].length;
        int ans = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] != 0) {
                    int tmp = dfs(grid, i, j);
                    ans = Math.max(ans, tmp);
                }
            }
        }
        return ans;
    }
    public static int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= R || j < 0 || j >= C || grid[i][j] != 1) {
            return 0;
        }
        int curArea = 0;
        grid[i][j] = 0;
        curArea++;
        curArea += dfs(grid, i+1, j);
        curArea += dfs(grid, i-1, j);
        curArea += dfs(grid, i, j+1);
        curArea += dfs(grid, i, j-1);

        return curArea;
    }

    public static void main(String[] args) {
        int[][] grid = {{1}};
        maxAreaOfIsland(grid);
    }
}
