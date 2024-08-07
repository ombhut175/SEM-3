package LEETCODE;


import java.util.Scanner;

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode save1 = headA;
        ListNode save2 = headB;
        int count1=0;
        int count2=0;
        if(intersectVal==0){
            System.out.println("No intersection");
            return null;
        }
        while(save1.next!=null && save1.val!=intersectVal){
                count1++;
                save1=save1.next;
        }
        while(save2.next!=null && save2.val!=intersectVal){
            count2++;
            save2=save2.next;
        }
        if(save1.next==null && save1.val!=intersectVal){
//            if(save1.val!=intersectVal){
                System.out.println("No intersection");
                return null;
//            }
        }
        System.out.println("Intersected at "+save1.val);
        System.out.println("skipA = "+count1);
        System.out.println("skipB = "+count2);
        return save1;
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
