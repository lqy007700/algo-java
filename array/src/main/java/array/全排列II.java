package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//47. 全排列 II
public class 全排列II {
    public static void main(String[] args) {
        全排列II a = new 全排列II();
        int[] nums = {1, 1, 2};
        List<List<Integer>> res = a.permuteUnique(nums);
        System.out.println(res);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        HashMap<Integer, Boolean> m = new HashMap<>();
        dfs(nums, nums.length, res, path, m);
        return res;
    }

    public void dfs(int[] nums, int len, List<List<Integer>> res, List<Integer> path, HashMap<Integer, Boolean> m) {
        if (path.size() == len) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

//        1,1,1,2,3
        for (int i = 0; i < len; i++) {
            if (m.get(i) != null || (i > 0 && nums[i] == nums[i - 1] && m.get(i - 1) == null)) {
                continue;
            }
            m.put(i, true);
            path.add(nums[i]);
            dfs(nums, len, res, path, m);
            path.remove(path.size() - 1);
            m.remove(i);
        }
    }
}
