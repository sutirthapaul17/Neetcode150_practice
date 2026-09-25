package LinkedList;

import java.util.List;

public class ReorderLinkedList {

    public void reorderList(ListNode head) {
        ListNode t = head;
        int size = 0;
        while(t!= null){
            size++;
            t=t.next;
        }
        t = head;
        int[] arr = new int[size];
        int i=0;
        while(t!=null){
            arr[i]=t.val;
            i++;
            t=t.next;
        }

        int l=1,r=size-1;
        i=1;
        int[] newArr = new int[size];
        newArr[0] = arr[0];
//        while(i < size){
//            if(i%2 == 1 ){
//                newArr[i]= arr[r--];
//            }else if(i%2 == 0){
//                newArr[i] = arr[l++];
//            }
//            i++;
//        }
        boolean right = true;
        while (i < size) {
            if (right)
                newArr[i] = arr[r--];
            else
                newArr[i] = arr[l++];
            right = !right;
            i++;
        }

        t = head;
        i=0;
        while(t != null){
            t.val = newArr[i++];
            t=t.next;
        }



        //instead of using 2nd array , we could have done this directly copy from array to the linked list
//        ListNode curr = head;
//        int l = 0, r = size - 1;
//        boolean takeLeft = true;
//
//        while (curr != null) {
//            if (takeLeft) {
//                curr.val = arr[l++];
//            } else {
//                curr.val = arr[r--];
//            }
//            takeLeft = !takeLeft;
//            curr = curr.next;
//        }
    }
}



//method-2
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
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        ListNode second = slow.next;
        slow.next = null;

        ListNode prev = null;
        while (second != null) {
            ListNode nextNode = second.next;
            second.next = prev;
            prev = second;
            second = nextNode;
        }

        // Step 3: Merge the two halves
        ListNode first = head;
        second = prev;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}