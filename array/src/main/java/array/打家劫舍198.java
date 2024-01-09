package array;

public class 打家劫舍198 {
    public static void main(String[] args) {

    }

    // 1,2,3,1
    // dp = [0,1,2,4,4]

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        /**
         * f(K) 偷 0 - K  房间的最大金额
         * f(0) = 0
         * f(1) = nums[0]
         * f(k) = max(f[k-1], nums[k-1] + f(k-2))
         */

//        int[] dp = new int[n + 1];
        int pre = 0;
        int cur = nums[0];

        for (int i = 2; i <= n; i++) {
            int tmp = Math.max(cur, nums[i - 1] + pre);
            pre = cur;
            cur = tmp;
        }

        return cur;
    }
}
