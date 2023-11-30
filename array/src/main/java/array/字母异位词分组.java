package array;

import java.util.*;

// 49
public class 字母异位词分组 {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            List<String> list = m.getOrDefault(s, new ArrayList<String>());
            list.add(str);
            m.put(s, list);
        }

        return new ArrayList<>(m.values());
    }
}
