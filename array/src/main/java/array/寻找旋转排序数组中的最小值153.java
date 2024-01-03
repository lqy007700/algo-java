package array;

public class 寻找旋转排序数组中的最小值153 {
    public static void main(String[] args) {

    }


    // 6,7,8,9,1,2,3,4,5
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] < nums[r]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }
}
