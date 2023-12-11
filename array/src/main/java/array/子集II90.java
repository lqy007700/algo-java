package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集II90 {
    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 2};
        子集II90 a = new 子集II90();
        List<List<Integer>> res = a.subsetsWithDup(nums);
        System.out.println(res);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        Arrays.sort(nums);
        dfs(res, path, used, nums, 0, nums.length);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, boolean[] used, int[] nums, int idx, int n) {
        res.add(new ArrayList<>(path));

        for (int i = idx; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(res, path, used, nums, i + 1, n);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
