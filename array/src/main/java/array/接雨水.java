package array;

import java.util.Deque;
import java.util.LinkedList;

// 42
public class 接雨水 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        接雨水 a = new 接雨水();
        int res = a.trapStack(nums);
        System.out.println(res);
    }

    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

//        0,1,0,2,1,0,1,3,2,1,2,1
//   l    0 1 1 2 2 2 2 3 3 3 3 3
//   r    3 3 3 3 3 3 3 3 2 2 2 1
//   ans  0 0 1 0 1 2 1 0 0 1 0 0

        int[] left = new int[n];
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }

        int[] right = new int[n];
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(left[i], right[i]) - height[i];
        }
        return ans;
    }

    public int trapStack(int[] height) {
        int n = height.length;
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();

//        0,1,0,2,1,0,1,3,2,1,2,1
//        1 0
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }

                int left = stack.peek();

                int w = i - left - 1;
                int h = Math.min(height[left], height[i]) - height[top];
                res += w * h;
            }
            stack.push(i);
        }
        return res;
    }
}
