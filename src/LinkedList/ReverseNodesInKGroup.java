package LinkedList;

public class ReverseNodesInKGroup {
    private ListNode reverseNodes(ListNode l1,int k){
        int length =0;
        ListNode p = l1;
        while(p!=null){
            length++;
            p=p.next;
        }
        if(k>length) return l1;



        return l1;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return head;
        }
        ListNode tail;
        ListNode d1 = head;
        ListNode d2 = d1;
        for(int i=0;i<k;i++){
            d1 = d1.next;
        }
        d2=d1.next;
        d1.next = null;
        head = reverseNodes(head,k);
        while(){
            d1 = d2;
            for(int i=0;i<k;i++){
                d2= d2.next;
            }
            ListNode d3 = d2.next;
            d2.next = null;
            reverseNodes(d1,k);
        }
    }
}
