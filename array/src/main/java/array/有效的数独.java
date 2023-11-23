package array;

// 36
public class 有效的数独 {
    public static void main(String[] args) {
        char[][] b = new char[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        有效的数独 a = new 有效的数独();
        a.isValidSudoku(b);
    }

    public boolean isValidSudoku(char[][] board) {
        /**
         *   [
         *      [
         *          [1,2,3,4,5,6,7,8,9],[1,2,3,4,5,6,7,8,9],[1,2,3,4,5,6,7,8,9]
         *      ]
         *      [[1,2,3,4,5,6,7,8,9],[1,2,3,4,5,6,7,8,9],[1,2,3,4,5,6,7,8,9]]
         *      [[1,2,3,4,5,6,7,8,9],[1,2,3,4,5,6,7,8,9],[1,2,3,4,5,6,7,8,9]]
         *   ]
         */
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subBox = new int[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];

                if (c != '.') {
                    int idx = c - '0' - 1;
                    rows[i][idx]++;
                    columns[j][idx]++;
                    subBox[i / 3][j / 3][idx]++;
                    if (rows[i][idx] > 1 || columns[j][idx] > 1 || subBox[i / 3][j / 3][idx] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
