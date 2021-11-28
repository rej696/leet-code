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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return addTwoNumbers(l1, l2, 0);
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
    if (l1 == null || l2 == null) {
      return singleNumber((l1 == null ? l2 : l1), carry);
    }
    int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
    carry = sum / 10;
    sum = sum % 10;
    
    return new ListNode(sum, addTwoNumbers(l1.next, l2.next, carry));
  }
                        
  private ListNode singleNumber(ListNode lx, int carry) {
    if (lx == null) {
      if (carry != 0) {
        return new ListNode(carry);
      } else {
        return null;
      }
    }
      
    int sum = lx.val + carry;
    carry = sum / 10;
    sum = sum % 10;
    
    return new ListNode(sum, singleNumber(lx.next, carry));
  }
                        
}