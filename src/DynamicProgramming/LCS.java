package DynamicProgramming;

/**
 * @Auther: 99615
 * @Date: 2020/9/10 14:28
 * @Description:
 */
public class LCS {
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        if (m == 0 || n == 0)
            return 0;
        dp[0][0] = (text1.charAt(0) == text2.charAt(0)) ? 1 : 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = (text1.charAt(i) == text2.charAt(0)) ? 1 : dp[i-1][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = (text2.charAt(j) == text1.charAt(0)) ? 1 : dp[0][j-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }

            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        String text1 = "abc", text2 = "abc";
        System.out.println(longestCommonSubsequence(text1, text2));
    }
}
