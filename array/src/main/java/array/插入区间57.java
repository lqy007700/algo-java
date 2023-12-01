package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 插入区间57 {
    public static void main(String[] args) {

//        intervals = [[1,3],[6,9]], newInterval = [2,5]
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        插入区间57 a = new 插入区间57();
        int[][] insert = a.insert(intervals, newInterval);

        System.out.println(Arrays.deepToString(insert));
    }


    public int[][] insert(int[][] intervals, int[] newInterval) {
        int l = newInterval[0], r = newInterval[1];

        List<int[]> res = new ArrayList<>();
        boolean flag = false;

        for (int[] interval : intervals) {
            if (interval[0] > r) {
                if (!flag) {
                    res.add(new int[]{l, r});
                    flag = true;
                }
                res.add(interval);
            } else if (interval[1] < l) {
                res.add(interval);
            } else {
                l = Math.min(l, interval[0]);
                r = Math.max(r, interval[1]);
            }
        }

        if (!flag) {
            res.add(new int[]{l, r});
        }

        return res.toArray(new int[][]{});
    }
}
