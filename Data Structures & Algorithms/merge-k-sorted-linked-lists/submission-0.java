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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> {
                return Integer.compare(a.val, b.val);
            });
        for (int i = 0; i < lists.length; i++) {
            pq.add(lists[i]);
        }
        ListNode res = new ListNode();
        ListNode itr = res;
        while(pq.size() > 0) {
            ListNode p = pq.poll();
            itr.next = new ListNode(p.val);
            itr = itr.next;
            if (p.next != null){
                pq.add(p.next);
            }
        }
        return res.next;
    }
}
