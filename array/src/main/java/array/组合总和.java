package array;

import java.util.ArrayList;
import java.util.List;

public class 组合总和 {
    public static void main(String[] args) {
        组合总和 a = new 组合总和();
        int[] nums = new int[]{2, 3, 6, 7};
        List<List<Integer>> res = a.combinationSum(nums, 7);
        System.out.println(res);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(candidates, target, 0, n, res, path);
        return res;
    }

    private void dfs(int[] candidates, int target, int begin, int len, List<List<Integer>> res, List<Integer> path) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, len, res, path);
            path.remove(path.size() - 1);
        }
    }
}
