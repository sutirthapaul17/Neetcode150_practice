package LinkedList;



public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next==null) return head;
        ListNode p,q,r;
        p = head;
        q = head.next;
        r = q.next;
        p.next = null;
        while(r != null){
            q.next = p;
            p = q;
            q = r;
            r = r.next;
        }
        q.next = p;
        p = q;
        q = null;
        return p;
    }
}

//short solution t.c-> same i.e o(n)
//public ListNode reverseList(ListNode head) {
//    ListNode prev = null;
//    ListNode curr = head;
//
//    while (curr != null) {
//        ListNode next = curr.next;
//        curr.next = prev;
//        prev = curr;
//        curr = next;
//    }
//
//    return prev;
//}
