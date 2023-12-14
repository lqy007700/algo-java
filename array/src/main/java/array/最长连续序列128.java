package array;

import java.util.HashSet;
import java.util.Set;

public class 最长连续序列128 {
    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }
        int res = 0;
        for (Integer i : s) {
            if (!s.contains(i - 1)) {
                int curNum = i;
                int curLen = 1;

                while (s.contains(curNum + 1)) {
                    curLen++;
                    curNum++;
                }
                res = Math.max(res, curLen);
            }
        }
        return res;
    }
}
