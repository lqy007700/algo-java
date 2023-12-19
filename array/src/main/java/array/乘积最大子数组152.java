package array;

public class 乘积最大子数组152 {
    public static void main(String[] args) {

    }

    // 动态规划
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxF = new int[n];
        int[] minF = new int[n];

        System.arraycopy(nums, 0, maxF, 0, n);
        System.arraycopy(nums, 0, minF, 0, n);

        for (int i = 1; i < n; i++) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }

        int res = maxF[0];
        for (int i = 1; i < n; i++) {
            res = Math.max(res, maxF[i]);
        }
        return res;
    }
}
