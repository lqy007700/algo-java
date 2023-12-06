package array;

import java.util.Arrays;

public class 螺旋矩阵II59 {
    public static void main(String[] args) {
        螺旋矩阵II59 a = new 螺旋矩阵II59();

        int[][] ints = a.generateMatrix(2);
        System.out.println(Arrays.deepToString(ints));

    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int num = 1;
        int end = n * n;

        int l = 0, r = n - 1;
        int t = 0, b = n - 1;

        while (num <= end) {
            // 左右
            for (int i = l; i <= r && num <= end; i++, num++) {
                System.out.println(t +"--"+i);
                res[t][i] = num;
            }
            t++;

            // 上下
            for (int i = t; i <= b && num <= end; i++, num++) {
                res[i][r] = num;
            }
            r--;

            // 右左
            for (int i = r; i >= l && num <= end; i--, num++) {
                res[b][i] = num;
            }
            b--;

            for (int i = b; i >= t && num <= end; i--, num++) {
                res[i][l] = num;
            }
            l++;
        }

        return res;
    }
}
