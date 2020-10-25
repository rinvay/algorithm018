/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        

        ListNode point = new ListNode();
        ListNode temp = point;
        ListNode pl1 = l1;
        ListNode pl2 = l2;
        while(pl1 != null && pl2 != null) {
            if(pl1.val <= pl2.val) {
                temp.next = pl1;
                pl1 = pl1.next;
            } else {
                temp.next = pl2;
                pl2 = pl2.next;
            }
            temp = temp.next;
        }

        if (pl1 == null) {
            temp.next = pl2;
        }
        if (pl2 == null) {
            temp.next = pl1;
        }
        return point.next;
    }
}