package array;

import javafx.scene.control.Slider;

// 11
public class 盛最多水的容器 {
    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        盛最多水的容器 s = new 盛最多水的容器();
        int res = s.maxArea(nums);
        System.out.println(res);
    }

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;

        while (l < r) {
            int minHeight = getMinHeight(height[l], height[r]);
            int tmpArea = minHeight * (r - l);
            if (tmpArea > max) {
                max = tmpArea;
            }

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

    private int getMinHeight(int i, int i1) {
        return Math.min(i, i1);
    }
}
