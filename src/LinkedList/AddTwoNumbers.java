package LinkedList;

//public class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
public class AddTwoNumbers {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int num1 = extractNum(l1);
//        int num2 = extractNum(l2);
//        int sum = num1 + num2;
//        return createList(sum);
//    }
//
//    private int extractNum(ListNode l) {
//        int i=1;
//        long num = l.val;
//        l = l.next;
//        while(l != null){
//            num= (int) (l.val * Math.pow(10,i) + num);
//            i++;
//            l = l.next;
//        }
//        return Math.toIntExact(num);
//    }
//
//    private ListNode createList(int sum) {
//        ListNode node = new ListNode();
//        ListNode t = node;
//        int val = sum % 10;
//        sum = sum / 10;
//        node.val = val;
//        while(sum != 0){
//            ListNode n = new ListNode();
//            t.next = n;
//            t = n;
//            val = sum % 10;
//            sum = sum / 10;
//            n.val = val;
//        }
//
//        return node;
//    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode();
        ListNode t = l;

        int carry = 0;
        while(l1!=null || l2 != null || carry !=0){
            int sum = carry;

            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;

            t.next = new ListNode(sum %10);
            t = t.next;
        }
        return l.next;
    }



//    private ListNode add(ListNode l1, ListNode l2, int carry) {
//        if (l1 == null && l2 == null && carry == 0) {
//            return null;
//        }
//
//        int sum = carry;
//
//        if (l1 != null) sum += l1.val;
//        if (l2 != null) sum += l2.val;
//
//        ListNode node = new ListNode(sum % 10);
//
//        node.next = add(
//                l1 == null ? null : l1.next,
//                l2 == null ? null : l2.next,
//                sum / 10
//        );
//
//        return node;
//    }
}
