package LinkedList;

public class RemoveNthNodeFromEnd {
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if(head==null || head.next==null){
//            return null;
//        }
//        ListNode temp = head;
//        int len = 0;
//        while(temp != null){
//            len++;
//            temp = temp.next;
//        }
//
//        temp = head;
//        if(len - n == 0){
//            head = head.next;
//            return head;
//        }
//        for(int i = 0 ; i< (len-n)-1;i++){
//            temp = temp.next;
//        }
//        temp.next = temp.next.next;
//        return head;
//
//    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null){
            return null;
        }

        ListNode f = head;
        for(int i=0;i<n;i++){
            f = f.next;
        }

        if (f == null)
            return head.next;

        ListNode s = head;
        while(f.next != null){
            s=s.next;
            f=f.next;
        }
        s.next = s.next.next;
        return head;
    }
}
