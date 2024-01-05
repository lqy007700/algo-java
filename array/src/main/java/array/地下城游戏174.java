package array;

public class 地下城游戏174 {
    public static void main(String[] args) {
        地下城游戏174 a = new 地下城游戏174();
        int[][] dungeon = new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int res = a.calculateMinimumHP(dungeon);
        System.out.println(res);

        /**
         {-2, -3, 3},
         {-5, -10, 1},
         {10, 30, -5}
         */

        /**
         {6, 4, 1},
         {5, 10, 4},
         {0, 0, 5}
         */

    }

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }

        int r = dungeon.length;
        int c = dungeon[0].length;
        int[][] dp = new int[r][c];

        dp[r - 1][c - 1] = Math.max(0, -dungeon[r - 1][c - 1]);

        // 最后一行
        for (int i = c - 2; i >= 0; i--) {
            int min = dp[r - 1][i + 1] - dungeon[r - 1][i];
            dp[r - 1][i] = Math.max(0, min);
        }

        // 最后一列
        for (int i = r - 2; i >= 0; i--) {
            int min = dp[i + 1][c - 1] - dungeon[i][c - 1];
            dp[i][c - 1] = Math.max(0, min);
        }

        for (int i = r - 2; i >= 0; --i) {
            for (int j = c - 2; j >= 0; --j) {
                // 从右边和下边选择一个最小值，然后减去当前的 dungeon 值
                int needMin = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = Math.max(0, needMin);
            }
        }

        return dp[0][0] + 1;
    }

    public int calculateMinimumHP1(int[][] dungeon) {
        int r = dungeon.length, c = dungeon[0].length;

        int[][] dp = new int[r][c];

        /**
         {-2, -3, 3},
         {-5, -10, 1},
         {10, 30, -5}
         */
        dp[r - 1][c - 1] = Math.max(0, -dungeon[r - 1][c - 1]);

        // 最后一行
        for (int i = c - 2; i >= 0; i++) {
            int min = dp[r - 1][i + 1] - dungeon[r - 1][i];
            dp[r - 1][i] = Math.max(0, min);
        }

        // 最后一列
        for (int i = r - 2; i >= 0; i++) {
            int min = dp[i + 1][c - 1] - dungeon[i][c - 1];
            dp[i][c - 1] = Math.max(0, min);
        }

        for (int i = r - 2; i >= 0; i--) {
            for (int j = c - 2; j >= 0; j--) {
                int needMin = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = Math.max(0, needMin);
            }
        }
        return dp[0][0] + 1;
    }
}
