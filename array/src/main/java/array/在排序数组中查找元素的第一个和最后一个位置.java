package array;

import java.util.Arrays;

//34
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] nums = {2, 2};
        在排序数组中查找元素的第一个和最后一个位置 a = new 在排序数组中查找元素的第一个和最后一个位置();
        int[] b = a.searchRange(nums, 2);
        System.out.println(Arrays.toString(b));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target) {
            return new int[]{0, 0};
        }

        int l = search(nums, target, true);
        int r = search(nums, target, false) - 1;
        if (l <= r && r < nums.length && nums[l] == target && nums[r] == target) {
            return new int[]{l, r};
        }
        return new int[]{-1, -1};
    }

    public int search(int[] nums, int target, boolean lower) {
        // 1 2 3 4 4 5 6 7
        int l = 0, r = nums.length - 1;
        int ans = nums.length;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
