package TreeProblems;

import java.util.*;

/**
 * @Auther: 99615
 * @Date: 2020/9/6 10:04
 * @Description:
 */
public class levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return ans;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();

                curLevel.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            ans.add(curLevel);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[12][12];
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o2[1]-o1[1];
            else
                return o1[0]-o2[0];
        });
    }
}
