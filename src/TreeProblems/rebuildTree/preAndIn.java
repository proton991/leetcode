package TreeProblems.rebuildTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 99615
 * @Date: 2020/9/25 10:27
 * @Description:
 */
public class preAndIn {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int pre_idx;
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
        // 如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right) {
            return null;
        }

        // 选择 pre_idx 位置的元素作为当前子树根节点
        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);

        // 根据 root 所在位置分成左右两棵子树
        int index = idx_map.get(root_val);

        // 下标加一
        pre_idx++;
        // 构造左子树
        root.left = helper(in_left, index - 1);
        // 构造右子树
        root.right = helper(index + 1, in_right);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] preorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        // 从前序遍历的第一个元素开始
        pre_idx = 0;

        // 建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }

        return helper(0, inorder.length - 1);
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] preorder = {3,9,20,15,7};
        preAndIn solution = new preAndIn();
        solution.buildTree(inorder, preorder);
    }
}
