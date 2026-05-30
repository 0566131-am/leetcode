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
    public void reorderList(ListNode head) {

          ListNode slow=head;
          ListNode fast=head;
          while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
          }
          ListNode prev=null;
          ListNode temp=slow;
          ListNode t3;
             while(temp!=null){
                t3=temp.next;
                temp.next=prev;
                prev=temp;
                temp=t3;
             }
            ListNode t1=head;
            ListNode t2 =prev;
            while(t2.next!=null){
                t3=t1.next;
                ListNode t4=t2.next;
                t1.next=t2;
                t2.next=t3;
                t1=t3;
                t2=t4;
            } 

        
    }
}