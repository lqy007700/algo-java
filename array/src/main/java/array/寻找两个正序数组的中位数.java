package array;

//4
public class 寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        寻找两个正序数组的中位数 s = new 寻找两个正序数组的中位数();
        int[] a = {1, 3};
        int[] b = {2};
        double res = s.findMedianSortedArrays(a, b);
        System.out.println(res);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int l = -1, r = -1;
        int n1 = 0, n2 = 0;

        for (int i = 0; i <= len / 2; i++) {
            l = r;
            if (n1 < m && (n2 >= n || nums1[n1] < nums2[n2])) {
                r = nums1[n1];
                n1++;
            } else {
                r = nums2[n2];
                n2++;
            }
        }

        if (len % 2 == 0) {
            return (double) (l + r) / 2;
        } else {
            return r;
        }
    }
}
