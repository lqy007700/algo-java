package array;

public class 删除有序数组中的重复项 {
    public static void main(String[] args) {
        删除有序数组中的重复项 a = new 删除有序数组中的重复项();

    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        // 1,2,3,4,4,5
        int f = 1, s = 1;
        while (f < n) {
            if (nums[f] != nums[f - 1]) {
                nums[s] = nums[f];
                s++;
            }
            f++;
        }
        return s;
    }
}
