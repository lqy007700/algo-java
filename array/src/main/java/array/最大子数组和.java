package array;

import java.util.Arrays;
import java.util.Map;

// 53
public class 最大子数组和 {
    public static void main(String[] args) {
        最大子数组和 a = new 最大子数组和();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        a.maxSubArray(nums);
    }

    public int maxSubArray(int[] nums) {
        // -2,1,-3,4,-1,2,1,-5,4

        int pre = 0;
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }
}
