package array;

import java.util.Arrays;

public class 轮转数组189 {
    public static void main(String[] args) {
        轮转数组189 a = new 轮转数组189();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        a.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 1, 2, 3, 4, 5, 6, 7
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[(i + k) % n] = nums[i];
        }

        System.arraycopy(res, 0, nums, 0, res.length);
    }
}
