package LinkedListProblems;

/**
 * @Auther: 99615
 * @Date: 2020/9/6 14:15
 * @Description:
 */
public class deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode n = prev;
        while (n.next != null && n.next.next != null) {
            if (n.next.val == n.next.next.val) {
                int dup = n.next.val;
                while (n.next != null && n.next.val == dup) {
                    n.next = n.next.next;
                }
            }
            else {
                n = n.next;
            }
        }
        return prev.next;
    }
}
