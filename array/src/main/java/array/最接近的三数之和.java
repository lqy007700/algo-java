package array;

import java.util.Arrays;

public class 最接近的三数之和 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};
        最接近的三数之和 a = new 最接近的三数之和();
        int res = a.threeSumClosest(nums, 4);
        System.out.println(res);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;

        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                }

                if (Math.abs(res - target) > Math.abs(sum - target)) {
                    res = sum;
                }

                if (sum > target) {
                    int k0 = k - 1;
                    while (k0 > j && nums[k0] == nums[k]) {
                        k0--;
                    }
                    k = k0;
                } else {
                    int j0 = j + 1;
                    while (j0 < k && nums[j0] == nums[j]) {
                        j0++;
                    }
                    j = j0;
                }
            }
        }
        return res;
    }
}
