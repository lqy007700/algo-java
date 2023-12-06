package array;

public class 搜索二维矩阵74 {
    public static void main(String[] args) {
        搜索二维矩阵74 a = new 搜索二维矩阵74();
        int[][] nums = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        boolean res = a.searchMatrix(nums, 3);
        System.out.println(res);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int idx = binarySearchFirstColumn(matrix, target);
        if (idx < 0) {
            return false;
        }

        return binarySearchRow(matrix[idx], target);

    }

    private boolean binarySearchRow(int[] matrix, int target) {
        int l = 0, r = matrix.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (matrix[mid] == target) {
                return true;
            } else if (matrix[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }

    public int binarySearchFirstColumn(int[][] matrix, int target) {
        int l = -1, r = matrix.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (matrix[mid][0] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
