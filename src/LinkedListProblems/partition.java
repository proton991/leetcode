package LinkedListProblems;

/**
 * @Auther: 99615
 * @Date: 2020/9/6 14:57
 * @Description:
 */

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 */
public class partition {
    public ListNode partition_solution(ListNode head, int x) {
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                before.next = p;
                before = before.next;
            } else {
                after.next = p;
                after = after.next;
            }
            p = p.next;
        }
        after.next = null;
        before.next = after_head.next;
        return before_head.next;
    }

}
