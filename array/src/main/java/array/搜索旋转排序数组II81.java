package array;

import java.util.Arrays;

public class 搜索旋转排序数组II81 {
    public static void main(String[] args) {
        搜索旋转排序数组II81 a = new 搜索旋转排序数组II81();
        int[] nums = new int[]{1, 3, 5};
        boolean res = a.search(nums, 1);
        System.out.println(res);
    }

    public boolean search(int[] nums, int target) {
        if (nums.length < 2) {
            for (int num : nums) {
                if (num == target) {
                    return true;
                }
            }
            return false;
        }

        // 找出旋转位
        int pre = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[pre] > nums[i]) {
                break;
            }
            pre++;
        }

        int[] n1 = new int[pre + 1];
        int[] n2 = new int[nums.length - pre - 1];

        System.arraycopy(nums, 0, n1, 0, n1.length);
        System.arraycopy(nums, n1.length, n2, 0, n2.length);

        return binarySearch(n1, target) || binarySearch(n2, target);
    }

    public boolean binarySearch(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
