package array;

public class 最大矩形85 {
    public static void main(String[] args) {

    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }

        int m = matrix[0].length;
        int[][] left = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }

                int w = left[i][j];
                int a = w;
                // 模拟高度 以i,j 为右下角的最大面积
                for (int k = i - 1; k >= 0; k--) {
                    // 最小宽度
                    w = Math.min(w, left[k][j]);
                    // 高度
                    int h = (i - k + 1);
                    // 最大面积
                    a = Math.max(a, h * w);
                }
                // 结果
                ret = Math.max(ret, a);
            }
        }
        return ret;
    }
}
