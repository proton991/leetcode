package LinkedListProblems;

/**
 * @Auther: 99615
 * @Date: 2020/9/6 15:22
 * @Description:
 */
public class sortList {
    public ListNode sortList_MergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;
        //cut the list
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;

        ListNode left = sortList_MergeSort(head);
        ListNode right = sortList_MergeSort(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = (left != null) ? left : right;
        return res.next;
    }
}
