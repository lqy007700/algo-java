package array;

public class 寻找峰值162 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(nums.length);
        寻找峰值162 a = new 寻找峰值162();
        int b = a.findPeakElement(nums);
        System.out.println(b);
    }

    public int findPeakElement(int[] nums) {
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }

        return idx;
    }
}
