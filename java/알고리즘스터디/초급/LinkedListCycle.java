package 알고리즘스터디.초급;

public class LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(){
        }

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        //처음부터 null인 경우 방지
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
