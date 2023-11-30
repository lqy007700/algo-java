package array;

import java.util.ArrayList;
import java.util.List;

// 54
public class 螺旋矩阵 {
    public static void main(String[] args) {
        int[][] nums = {{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12}};
        螺旋矩阵 a = new 螺旋矩阵();
        List<Integer> res = a.spiralOrder(nums);
        System.out.println(res);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int l = 0, r = matrix[0].length - 1;
        int t = 0, b = matrix.length - 1;

        int count = matrix[0].length * matrix.length;

        while (true) {
            // 左 -》 右
            for (int i = l; i <= r; i++) {
                res.add(matrix[t][i]);
            }
            t++;
            if (res.size() >= count) {
                break;
            }

            // 上 -》 下
            for (int i = t; i <= b; i++) {
                res.add(matrix[i][r]);
            }
            r--;
            if (res.size() >= count) {
                break;
            }

            // 右 -》 左
            for (int i = r; i >= l; i--) {
                res.add(matrix[b][i]);
            }
            b--;
            if (res.size() >= count) {
                break;
            }
            // 下 -》上
            for (int i = b; i >= t; i--) {
                res.add(matrix[i][l]);
            }
            l++;
            if (res.size() >= count) {
                break;
            }
        }

        return res;
    }
}
