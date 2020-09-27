package Stack_and_Queue;

import java.util.*;

/**
 * @Auther: 99615
 * @Date: 2020/9/7 17:19
 * @Description:
 */
public class cloneGraph {
    Map<Node, Node> visited = new HashMap<>();
    public Node cloneGraph_Solution(Node node) {
        if (node == null)
            return null;

        Node cNode = new Node(node.val, new ArrayList<>());
        if (visited.containsKey(node))
            return visited.get(node);
        visited.put(node, cNode);
        for (Node n : node.neighbors) {
            cNode.neighbors.add(cloneGraph_Solution(n));
        }
        return cNode;
    }
}
