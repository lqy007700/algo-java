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
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(candidates, 0, candidates.length, target, path, res);

        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, List<Integer> path, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            path.add(candidates[i]);
            dfs(candidates, i, len, target - candidates[i], path, res);
            path.remove(path.size() - 1);
        }
    }
}
