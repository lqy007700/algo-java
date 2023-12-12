package array;

import java.util.HashMap;
import java.util.Map;

public class 从中序与后序遍历序列构造106 {
    public static void main(String[] args) {
        从中序与后序遍历序列构造106 a = new 从中序与后序遍历序列构造106();
        int[] inorder = {9, 3, 15, 20, 7}, postorder = {9, 15, 7, 20, 3};

        TreeNode res = a.buildTree(inorder, postorder);
        从前序与中序遍历序列构造二叉树105 b = new 从前序与中序遍历序列构造二叉树105();
        b.printTree(res);
    }

    Map<Integer, Integer> idxMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        idxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxMap.put(inorder[i], i);
        }

        return build(postorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode build(int[] postorder, int il, int ir, int pl, int pr) {
        if (il > ir) {
            return null;
        }

        // 中序遍历中的root下标
        Integer iRootIdx = idxMap.get(postorder[pr]);

        // 左树长度
        int leftSize = iRootIdx - il;
        TreeNode root = new TreeNode(postorder[pr]);

        root.left = build(postorder, il, iRootIdx - 1, pl, pl + leftSize - 1);
        root.right = build(postorder, iRootIdx + 1, ir, pl + leftSize, pr - 1);

        return root;
    }
}


