package array;

import java.util.Arrays;

public class 合并两个有序数组88 {
    public static void main(String[] args) {
        合并两个有序数组88 a = new 合并两个有序数组88();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        a.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int m1 = m - 1, n1 = n - 1;
        int l = m + n - 1;
        int c = 0;
        while (m1 >= 0 || n1 >= 0) {
            if (m1 == -1) {
                c = nums2[n1];
                n1--;
            } else if (n1 == -1) {
                c = nums1[m1];
                m1--;
            } else if (nums1[m1] > nums2[n1]) {
                c = nums1[m1];
                m1--;
            } else {
                c = nums2[n1];
                n1--;
            }
            nums1[l] = c;
            l--;
        }
    }
}
