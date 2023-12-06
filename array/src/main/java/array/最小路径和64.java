package array;

public class 最小路径和64 {
    public static void main(String[] args) {

        int[][] nums = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        最小路径和64 a = new 最小路径和64();
        int res = a.minPathSum(nums);
        System.out.println(res);
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] dp = new int[m];
        dp[0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }

        for (int i = 1; i < n; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < m; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }

        return dp[m - 1];
    }
}
