package array;

public class 买卖股票的最佳时机II122 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int n = prices.length;

        // i,j 第i天 0 持有和 1 没有股票的最大收益
        int[][] dp = new int[n][2];

        // 0 现金
        // 1 股票
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n-1][0];
    }
}

