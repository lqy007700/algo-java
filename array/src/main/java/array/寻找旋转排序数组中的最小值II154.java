package array;

public class 寻找旋转排序数组中的最小值II154 {
    public static void main(String[] args) {

    }

    // 7891123456
    // 781112
    // 7
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int m = (l + r) / 2;

            if (nums[m] < nums[r]) {
                r = m;
            } else if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r--;
            }
        }

        return nums[l];
    }
}
