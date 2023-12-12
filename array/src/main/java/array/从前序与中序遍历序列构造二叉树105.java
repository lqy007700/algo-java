package array;

import java.util.HashMap;
import java.util.Map;

public class 从前序与中序遍历序列构造二叉树105 {
    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7}, inorder = new int[]{9, 3, 15, 20, 7};
        从前序与中序遍历序列构造二叉树105 a = new 从前序与中序遍历序列构造二叉树105();
        TreeNode treeNode = a.buildTree(preorder, inorder);
        a.printTree(treeNode);

    }

    public void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    public Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;

        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }

        return build(preorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode build(int[] preorder, int pl, int pr, int il, int ir) {
        if (pl > pr) {
            return null;
        }
        // 找到中序遍历的根节点
        Integer iRootIdx = indexMap.get(preorder[pl]);

        TreeNode root = new TreeNode(preorder[pl]);

        int leftSize = iRootIdx - il;

        root.left = build(preorder, pl + 1, pl + leftSize, il, iRootIdx - 1);
        root.right = build(preorder, pl + leftSize + 1, pr, iRootIdx + 1, ir);
        return root;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}