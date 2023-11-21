package array;

import java.util.Arrays;

public class 下一个排列 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6, 5};
        下一个排列 a = new 下一个排列();
        a.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }

        int i = n - 2, j = n - 1, k = n - 1;

//        123465
        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }

        if (i >= 0) {
            while (nums[i] >= nums[k]) {
                k--;
            }

            nums[i] = nums[i] + nums[k];
            nums[k] = nums[i] - nums[k];
            nums[i] = nums[i] - nums[k];
        }

        // j - end 升序
        for (int a = j, b = n - 1; a < b; a++, b--) {
            int t = nums[b];
            nums[b] = nums[a];
            nums[a] = t;
        }
    }
}
