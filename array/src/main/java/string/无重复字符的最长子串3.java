package string;

import java.util.HashMap;
import java.util.Map;

public class 无重复字符的最长子串3 {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> m = new HashMap<>();
        int max = 0;

        // abacb

        //
        int slow = 0, fast = 0;
        while (fast < s.length()) {
            if (m.containsKey(s.charAt(fast))) {
                slow = Math.max(slow, m.get(s.charAt(fast)) + 1);
            }
            m.put(s.charAt(fast), fast);

            max = Math.max(max, fast - slow + 1);
            fast++;
        }
        return max;
    }
}
