package array;

import java.util.Arrays;

// 41
public class 缺失的第一个正数 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, -1, 1};
        缺失的第一个正数 a = new 缺失的第一个正数();
        int b = a.firstMissingPositive(nums);
        System.out.println(b);
    }

    /**
     * 1/ 将负数变为不在 1-n之内的数
     * 2/ 将<=n对应下标的值改为负数
     * 3/ 第一个整数是缺失的正数
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(num - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

}
