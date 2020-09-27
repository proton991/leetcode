package LinkedListProblems;

/**
 * @Auther: 99615
 * @Date: 2020/9/6 16:14
 * @Description:
 */
public class reverseList {
    public static ListNode reverseOrder(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        head.next = null;
        return pre;
    }
}
