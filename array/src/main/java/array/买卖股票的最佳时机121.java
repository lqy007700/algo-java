package array;

public class 买卖股票的最佳时机121 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        // 找出历史的最低点，计算当前卖出的价格
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                // 更新历史最低点
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                // 计算出最高利润
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public int maxProfitA(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > maxProfit) {
                    maxProfit = prices[j] - prices[i];
                }
            }
        }

        return maxProfit;
    }
}
