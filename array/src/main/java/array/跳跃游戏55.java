package array;

public class 跳跃游戏55 {
    public static void main(String[] args) {
        跳跃游戏55 a = new 跳跃游戏55();
        int[] nums = {3, 2, 1, 0, 4};
        boolean b = a.canJump(nums);
        System.out.println(b);
    }

    public boolean canJump(int[] nums) {
        boolean res = true;
        int n = nums.length;

        /**
         * 3, 2, 1, 0, 4
         * 0  1  2  3  4
         */

        int maxPosition = 0;
        for (int i = 0; i < n; i++) {
            if (i > maxPosition) {
                res = false;
                break;
            }
            maxPosition = Math.max(maxPosition, i + nums[i]);
        }
        return res;
    }
}
