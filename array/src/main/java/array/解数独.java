package array;

import java.util.ArrayList;
import java.util.List;

// 37
public class 解数独 {

    private boolean[][] rows = new boolean[9][9];
    private boolean[][] columns = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    private List<int[]> spaces = new ArrayList<>();
    private boolean valid = false;

    public void solveSudoku(char[][] board) {
        /**
         * 1/ 标记当前数独中存在的数据
         * 2/ 将要填写的位置记录
         * 3/ 回溯填写
         */

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int addr = board[i][j] - '0' - 1;
                    rows[i][addr] = columns[j][addr] = block[i / 3][j / 3][addr] = true;
                }
            }
        }
        dfs(board, 0);
    }

    public void dfs(char[][] board, int n) {
        if (n == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(n);
        int i = space[0], j = space[1];

        for (int k = 0; k < 9 && !valid; k++) {
            if (!rows[i][k] && !columns[j][k] && !block[i / 3][j / 3][k]) {
                rows[i][k] = columns[j][k] = block[i / 3][j / 3][k] = true;
                board[i][j] = (char) (k + '0' + 1);
                dfs(board, n + 1);
                rows[i][k] = columns[j][k] = block[i / 3][j / 3][k] = false;
            }
        }
    }
}
