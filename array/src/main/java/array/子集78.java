package array;

import java.util.ArrayList;
import java.util.List;

public class 子集78 {
    public static void main(String[] args) {
        子集78 a = new 子集78();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> subsets = a.subsets(nums);
        System.out.println(subsets);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(res, nums, path, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, List<Integer> path, int c) {
        res.add(new ArrayList<>(path));

        for (int i = c; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(res, nums, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
