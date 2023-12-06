package array;

import java.util.Arrays;

public class 不同路径II63 {
    public static void main(String[] args) {
        不同路径II63 a = new 不同路径II63();

        int[][] grid = new int[3][2];
        grid[1][0] = 1;
        grid[1][1] = 1;
        System.out.println(Arrays.deepToString(grid));
        int res = a.uniquePathsWithObstacles(grid);
        System.out.println(res);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        if (obstacleGrid[0][0] == 1) {
            dp[0][0] = 0;
            return 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i > 0 && j > 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else if (j > 0) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][m - 1];

        /**
         * 1,1,1,1,1
         * 0,2,0,2,2
         * 0,3,3,3,3
         */
    }


    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] dp = new int[m];
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[m - 1];

        /**
         * 1,1,1,1,1
         * 0,2,0,2,2
         * 0,3,3,3,3
         */
    }
}