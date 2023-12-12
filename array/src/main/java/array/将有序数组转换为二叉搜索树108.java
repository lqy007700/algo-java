package array;

public class 将有序数组转换为二叉搜索树108 {
    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return help(nums, 0, nums.length - 1);
    }

    public TreeNode help(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int rootIdx = (l + r) / 2;
        TreeNode root = new TreeNode(nums[rootIdx]);
        root.left = help(nums, l, rootIdx - 1);
        root.right = help(nums, rootIdx + 1, r);
        return root;
    }
}
