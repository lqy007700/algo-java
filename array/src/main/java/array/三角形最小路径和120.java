package array;

import java.util.List;

//triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
public class 三角形最小路径和120 {
    public static void main(String[] args) {

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        /**
         [2]
         [3,4]
         [6,5,7]
         [4,1,8,3]
         */
        // 第i行第j列的最小和
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }

        int res = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }

        return res;
    }
}
