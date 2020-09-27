package TreeProblems;

/**
 * @Auther: 99615
 * @Date: 2020/9/5 14:13
 * @Description:
 */
public class maxDepth {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int ld = 0, rd = 0;
        ld = maxDepth(root.left);
        rd = maxDepth(root.right);
        return (ld > rd) ? (ld + 1) : (rd + 1);
    }
}
