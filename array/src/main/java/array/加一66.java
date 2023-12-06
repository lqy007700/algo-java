package array;

import java.util.Arrays;

public class 加一66 {
    public static void main(String[] args) {
        加一66 a = new 加一66();
        int[] num = new int[]{9};
        int[] res = a.plusOne(num);
        System.out.println(Arrays.toString(res));
    }

    public int[] plusOne(int[] digits) {
        int tag = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            tag += digits[i];
            if (tag >= 10) {
                digits[i] = tag % 10;
                tag /= 10;
            } else {
                digits[i] = tag;
                tag = 0;
            }
        }

        if (tag > 0) {
            int[] res = new int[digits.length + 1];
            res[0] = tag;
            for (int i = 1; i < res.length; i++) {
                res[i] = digits[i - 1];
            }
            return res;
        }
        return digits;
    }
}
