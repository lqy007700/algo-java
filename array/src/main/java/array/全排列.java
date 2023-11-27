package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 46
public class 全排列 {
    public static void main(String[] args) {
        全排列 a = new 全排列();
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = a.permute(nums);
        System.out.println(res);
    }

    public List<List<Integer>> permute(int[] nums) {
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

        for (int i = 0; i < len; i++) {
            if (m.get(nums[i]) == null) {
                m.put(nums[i], true);
                path.add(nums[i]);
                dfs(nums, len, res, path, m);
                path.remove(path.size() - 1);
                m.remove(nums[i]);
            }
        }
    }
}
