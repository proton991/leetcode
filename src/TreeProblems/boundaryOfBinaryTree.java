package TreeProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: 99615
 * @Date: 2020/9/15 16:34
 * @Description:
 */
public class boundaryOfBinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        if (!isLeaf(root)) res.add(root.val);   // 根节点就是上边界
        TreeNode t = root.left;
        // 如果有左子树，那么就存在左边界，否则没有左边界
        while (t != null) {
            // 不是叶子节点，即为左边界
            if (!isLeaf(t)) res.add(t.val);
            if (t.left != null) {
                t = t.left;
            } else { // 当走到某一层的左边界节点没有左子节点，则拿它的右子节点继续遍历
                t = t.right;
            }
        }
        // 添加下边界
        addLeaves(res, root);
        // 添加右边界，定义一个栈来最后调转顺序
        Stack<Integer> s = new Stack<>();
        t = root.right;
        while (t != null) {
            if (!isLeaf(t)) {
                s.push(t.val);
            }
            if (t.right != null) {
                t = t.right;
            } else {
                t = t.left;
            }
        }
        while (!s.empty()) {
            res.add(s.pop());
        }
        return res;
    }

    public boolean isLeaf(TreeNode t) {
        return t.left == null && t.right == null;
    }

    public void addLeaves(List<Integer> res, TreeNode root) {
        if (isLeaf(root)) {
            res.add(root.val);
        } else {
            // 左子树的叶子节点加入 res
            if (root.left != null) addLeaves(res, root.left);
            // 右子树的叶子节点加入 res
            if (root.right != null) addLeaves(res, root.right);
        }
    }

}
