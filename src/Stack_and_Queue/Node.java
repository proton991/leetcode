package Stack_and_Queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 99615
 * @Date: 2020/9/7 17:18
 * @Description:
 */
class Node {
    public int val;

    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
