package array;

//45
public class 跳跃游戏II {
    public static void main(String[] args) {

    }

    public int jump(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int maxPosition = 0;
        int end = 0;

//        2,3,1,1,4
        for (int i = 0; i < n - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                ans++;
            }
        }

        return ans;
    }
}
