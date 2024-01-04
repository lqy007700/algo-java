package array;

import java.util.HashMap;
import java.util.Map;

public class 多数元素169 {
    public static void main(String[] args) {
        多数元素169 a = new 多数元素169();
        int[] nums = new int[]{1, 2, 2, 2, 1};
        a.majorityElement(nums);

    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int num : nums) {
            if (!m.containsKey(num)) {
                m.put(num, 1);
            } else {
                m.put(num, m.get(num) + 1);
            }
        }

        Map.Entry<Integer, Integer> a = null;

        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            if (a == null || entry.getValue() > a.getValue()) {
                a = entry;
            }
        }

        return a.getKey();
    }

}
