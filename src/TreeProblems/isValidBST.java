package TreeProblems;

import java.util.Stack;

/**
 * @Auther: 99615
 * @Date: 2020/9/6 13:12
 * @Description:
 */
public class isValidBST {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double  val = -Double.MAX_VALUE;
        if (root == null)
            return true;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= val)
                return false;
            val = root.val;
            root = root.right;
        }
        return true;
    }
}
