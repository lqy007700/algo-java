package array;

public class 柱状图中最大的矩形84 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 5, 6, 2, 3};
        柱状图中最大的矩形84 a = new 柱状图中最大的矩形84();
        int res = a.largestRectangleAreaH(nums);
        System.out.println(res);
    }

    // 枚举宽
    public int largestRectangleAreaW(int[] heights) {
        int n = heights.length;
        int ans = 0;

        for (int l = 0; l < n; l++) {
            int minH = heights[l];
            for (int r = l; r < n; r++) {
                minH = Math.min(minH, heights[r]);
                ans = Math.max(ans, (r - l + 1) * minH);
            }
        }
        return ans;
    }

    //    枚举高
    public int largestRectangleAreaH(int[] heights) {
        int n = heights.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int h = heights[i];
            int l = i, r = i;
            while (l - 1 >= 0 && heights[l - 1] >= h) {
                l--;
            }

            while (r + 1 < n && heights[r + 1] >= h) {
                r++;
            }

            ans = Math.max(ans, (r - l + 1) * h);
        }

        return ans;
    }

}
