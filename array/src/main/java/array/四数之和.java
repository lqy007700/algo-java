package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 18
public class 四数之和 {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
//        [,[-3,0,1,2],,[-2,-1,1,2],]
        四数之和 a = new 四数之和();
        List<List<Integer>> res = a.fourSum(nums, 0);
//        -2, -1, 0, 0, 1, 2
        System.out.println(res);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }

            if ((long) nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }

                if ((long) nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }


                int l = j + 1, r = n - 1;

                int tmpTarget = target - nums[i] - nums[j];
                while (l < r) {
                    long sum = (long) nums[l] + nums[r];

                    if (sum == tmpTarget) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[l]);
                        tmp.add(nums[r]);
                        res.add(tmp);
                    }

                    if (sum > tmpTarget) {
                        int r0 = r - 1;
                        while (r0 > l && nums[r0] == nums[r]) {
                            r0--;
                        }
                        r = r0;
                    } else {
                        int l0 = l + 1;
                        while (l0 < r && nums[l0] == nums[l]) {
                            l0++;
                        }
                        l = l0;
                    }
                }
            }
        }
        return res;
    }
}