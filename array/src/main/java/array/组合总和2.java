package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 40
public class 组合总和2 {
    public static void main(String[] args) {
        组合总和2 a = new 组合总和2();
        int[] nums = new int[]{10, 1, 2, 7, 6, 1, 5};
        Arrays.sort(nums);
        List<List<Integer>> lists = a.combinationSum2(nums, 8);
        System.out.println(lists);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(candidates, target, 0, candidates.length, res, path);
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
            if (target - candidates[i] < 0) {
                break;
            }

            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, len, res, path);
            path.remove(path.size() - 1);
        }
    }
}
