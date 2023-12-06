package array;


public class 矩阵置零73 {
    public static void main(String[] args) {
        矩阵置零73 a = new 矩阵置零73();
        int[][] nums = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        a.setZeroes(nums);

        /**
         * 0, 1, 2, 0
         * 3, 4, 5, 2
         * 1, 3, 1, 5
         *
         *
         * 0, 0, 0, 0
         * 0, 4, 5, 0
         * 0, 3, 1, 0
         */
    }

    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
