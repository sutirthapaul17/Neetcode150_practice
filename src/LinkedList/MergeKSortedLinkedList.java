package LinkedList;
//
//public class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}


public class MergeKSortedLinkedList {

    //Wrong
//    private ListNode merger(ListNode l1,ListNode l2){
//        // If either list is empty
//        if (l1 == null) return l2;
//        if (l2 == null) return l1;
//        // Head of the merged List
//        ListNode p = l1;
//        ListNode current = l2;
//        while(current != null){
//            ListNode q = l2;
//            if(l1.next.val > q.val){
//                while(l1.next.val > l2.next.val) {
//                    l2 = l2.next;
//                }
//                ListNode x = l2;
//                l2 = l2.next;
//                x.next = l1.next;
//                l1.next = q;
//                l1 = x.next;
//            }else{
//                l1=l1.next;
//            }
//        }
//        l1.next = l2;
//        return p;
//    }

    private ListNode merger(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(-1);
        ListNode c = dummy;

        while(l1 != null && l2 != null){

            if(l1.val <= l2.val){
                c.next = l1;
                l1=l1.next;
            }else {
                c.next=l2;
                l2=l2.next;
            }
            c=c.next;
        }

        if(l1!=null){
            c.next=l1;
        }else {
            c.next=l2;
        }
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int interval = 1;

        while (interval < lists.length) {

            for (int i = 0; i + interval < lists.length; i += interval * 2) {

                lists[i] = merger(
                        lists[i],
                        lists[i + interval]
                );
            }

            interval *= 2;
        }

        return lists[0];
    }
}
