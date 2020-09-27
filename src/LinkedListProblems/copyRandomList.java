package LinkedListProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 99615
 * @Date: 2020/9/6 18:22
 * @Description:
 */
public class copyRandomList {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList_MapSolution(Node head) {
        Map<Node, Node> map = new HashMap<>();
        if (head == null)
            return null;
        Node dummy = new Node(-1);
        Node res = dummy;
        Node p = head;
        while (p != null) {
            Node tmp = new Node(p.val);
            dummy.next = tmp;
            dummy = dummy.next;
            map.put(p, tmp);
            p = p.next;
        }
        Node n = res.next;
        p = head;
        while (n != null) {
            if (p.random != null) {
                n.random = map.get(p.random);
            }
            else
                n.random = null;
            n = n.next;
            p = p.next;
        }
        return res.next;
    }
}
