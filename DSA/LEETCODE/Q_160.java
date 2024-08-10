package LEETCODE;

public class Q_160 {
    public static void main(String[] args) {

    }
}
public class Solution {
    Node headA;
    Node headB;
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode save1 = headA;
        ListNode save2 = headB;
        int count1=0;
        int count2=0;
        while(save1.next!=null){
            count1++;
            count2=0;
            save2=headB;
            while (save2.next!=null){
                count2++;
                if(save2.next==save1.next){
                    break;
                }
                save2=save2.next;
            }
            save1=save1.next;
        }
        System.out.println("Intersected at "+save1.next.val);
        System.out.println("skipA = "+count1);
        System.out.println("skipB = "+count2);
    }
}


  class ListNode {
      int val;
      ListNode next;
     ListNode(int x) {
          val = x;
          next = null;
      }
  }
