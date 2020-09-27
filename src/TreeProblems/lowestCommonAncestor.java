package TreeProblems;

/**
 * @Auther: 99615
 * @Date: 2020/9/5 23:07
 * @Description:
 */
public class lowestCommonAncestor {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || (root.val == p.val || root.val == q.val) && (lson || rson))
            ans = root;
        return lson || rson || (root.val == p.val || root.val == q.val);
    }
}
