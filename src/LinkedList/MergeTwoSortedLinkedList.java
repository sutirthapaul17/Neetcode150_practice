package LinkedList;

import java.util.LinkedList;

public class MergeTwoSortedLinkedList {

    //wrong solution
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode l1 = list1;
//        ListNode l2  = list2;
//
//        ListNode newList = new ListNode();
//        ListNode head = newList;
//
//        while(l1!=null && l2!=null){
//            ListNode nl = new ListNode();
//            if(l1.val > l2.val){
//                newList.val = l2.val;
//                l2 = l2.next;
//            } else {
//                newList.val = l1.val;
//                l1=l1.next;
//            }
//            newList.next = nl;
//            newList = nl;
//        }
//        while(l2!=null){
//            newList.val = l2.val;
//            l2 = l2.next;
//            assert l2 != null;
//            if(l2.next != null){
//                ListNode nl = new ListNode();
//                newList.next = nl;
//                newList = nl;
//            }
//
//        }
//        while(l1!=null){
//            newList.val = l1.val;
//            l1 = l1.next;
//            assert l1 != null;
//            if(l1.next != null){
//                ListNode nl = new ListNode();
//                newList.next = nl;
//                newList = nl;
//            }
//        }
//        return head;
//    }


    // right solution
//
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode l1 = list1;
//        ListNode l2 = list2;
//
//        ListNode head = new ListNode();
//        ListNode newList = head;
//
//        while (l1 != null && l2 != null) {
//
//            if (l1.val <= l2.val) {
//                newList.val = l1.val;
//                l1 = l1.next;
//            } else {
//                newList.val = l2.val;
//                l2 = l2.next;
//            }
//
//            if (l1 != null || l2 != null) {
//                newList.next = new ListNode();
//                newList = newList.next;
//            }
//        }
//
//        while (l1 != null) {
//            newList.val = l1.val;
//            l1 = l1.next;
//
//            if (l1 != null) {
//                newList.next = new ListNode();
//                newList = newList.next;
//            }
//        }
//
//        while (l2 != null) {
//            newList.val = l2.val;
//            l2 = l2.next;
//
//            if (l2 != null) {
//                newList.next = new ListNode();
//                newList = newList.next;
//            }
//        }
//
//        return head;
//    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }

        return dummy.next;
    }

}
