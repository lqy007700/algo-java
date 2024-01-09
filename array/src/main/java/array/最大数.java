package array;

import java.util.Arrays;

public class 最大数 {
    public static void main(String[] args) {
        最大数 a = new 最大数();

        String b = a.largestNumber(new int[]{3, 30, 34, 5, 9});
        System.out.println(Arrays.toString(b.toCharArray()));
    }

    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, (x, y) -> (y + x).compareTo(x + y));

        if (str[0].equals("0")) {
            return "0";
        }

        StringBuilder res = new StringBuilder();

        for (String s : str) {
            res.append(s);
        }

        return res.toString();
    }
}