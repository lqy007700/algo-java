package array;

import java.util.HashMap;
import java.util.Map;

public class 只出现一次的数字II137 {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ret = 0;
        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            Integer key = en.getKey();
            Integer value = en.getValue();
            if (value == 1) {
                ret = key;
                break;
            }
        }
        return ret;
    }

}
