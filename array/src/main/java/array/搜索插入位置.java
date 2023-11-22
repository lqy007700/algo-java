package array;

//35. 搜索插入位置
public class 搜索插入位置 {
    public static void main(String[] args) {
        搜索插入位置 a = new 搜索插入位置();
    }

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;

        // 1,3,4     2
        int l = 0, r = n - 1, ans = n;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target <= nums[mid]) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
