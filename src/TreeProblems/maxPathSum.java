package TreeProblems;

/**
 * @Auther: 99615
 * @Date: 2020/9/5 20:23
 * @Description:
 */
public class maxPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }
    public int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        int curSum = root.val + left + right;
        maxSum = Math.max(curSum, maxSum);
        return root.val + Math.max(left, right);
    }
}
