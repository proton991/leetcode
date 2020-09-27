package TreeProblems;

/**
 * @Auther: 99615
 * @Date: 2020/9/5 20:03
 * @Description:
 */
public class judgeBST {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.left);
        if (lh == -1 || rh == -1 || Math.abs(lh-rh) > 1) {
            return -1;
        } else {
            return Math.max(lh, rh) + 1;
        }
    }
}
