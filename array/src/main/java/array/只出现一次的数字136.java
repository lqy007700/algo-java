package array;

public class 只出现一次的数字136 {
    public static void main(String[] args) {
    }

    /**
     * 异或
     * a ^ b ^ a = a ^ a ^ b = b
     */
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }
}
