package array;

import java.util.Arrays;

public class 删除有序数组中的重复项II80 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3, 4, 4};
        删除有序数组中的重复项II80 a = new 删除有序数组中的重复项II80();
        int i = a.removeDuplicates(nums);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int s = 2, f = 2;
        // 1,1,2,2,3,3,4,4
        while (f < n) {
            if (nums[s - 2] != nums[f]) {
                nums[s] = nums[f];
                s++;
            }
            f++;
        }
        return s;
    }
}
