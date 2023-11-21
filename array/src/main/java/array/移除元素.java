package array;

public class 移除元素 {
    public static void main(String[] args) {
        移除元素 a = new 移除元素();
        int[] nums = {1, 2, 3, 4, 5, 1, 1};
        int res = a.removeElement(nums, 1);
        System.out.println(res);
    }

    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if (n == 0) {
            return n;
        }

        int f = 0, s = 0;
        while (f < n) {
            if (nums[f] != val) {
                nums[s] = nums[f];
                s++;
            }
            f++;
        }
        return s;
    }
}
