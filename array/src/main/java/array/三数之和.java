package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 15
public class 三数之和 {
    public static void main(String[] args) {
        List<List<Integer>> nestedList = new ArrayList<>();

        // 创建第一个子列表
        List<Integer> sublist1 = new ArrayList<>();
        sublist1.add(1);
        sublist1.add(2);
        sublist1.add(3);

        // 创建第二个子列表
        List<Integer> sublist2 = new ArrayList<>();
        sublist2.add(4);
        sublist2.add(5);

        // 将子列表添加到嵌套列表中
        nestedList.add(sublist1);
        nestedList.add(sublist2);

    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > 0) {
                break;
            }

            int k = n - 1;
            int target = -nums[i];
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                if (nums[i] + nums[j] > 0) {
                    break;
                }

                while (j < k && nums[j] + nums[k] > target) {
                    k--;
                }

                if (j == k) {
                    break;
                }

                if (nums[j] + nums[k] == target) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);

                    res.add(tmp);
                }
            }
        }
        return res;
    }
}
