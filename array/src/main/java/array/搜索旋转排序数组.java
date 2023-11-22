package array;

public class 搜索旋转排序数组 {
    public static void main(String[] args) {
        搜索旋转排序数组 a = new 搜索旋转排序数组();
        int[] nums = {1, 3};
        int res = a.search(nums, 3);
        System.out.println(res);
    }


    // 二分搜索
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // 1 2 3 4 5 6 7
            // 5 6 7 1 2 3 4
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
