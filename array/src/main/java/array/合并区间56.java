package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并区间56 {
    public static void main(String[] args) {
        合并区间56 a = new 合并区间56();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] nums = a.merge(intervals);
        System.out.println(Arrays.deepToString(nums));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][]{};
        }
        // 按照第一个数排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> stack = new ArrayList<>();
        for (int[] nums : intervals) {

            if (stack.isEmpty() || stack.get(stack.size() - 1)[1] < nums[0]) {
                stack.add(nums);
            } else {
                stack.get(stack.size() - 1)[1] = Math.max(stack.get(stack.size() - 1)[1], nums[1]);
            }
        }
        return stack.toArray(new int[][]{});
    }
}
