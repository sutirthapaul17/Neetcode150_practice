package LinkedList;

import java.util.HashMap;
import java.util.Map;

class Node{
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}



public class CopyLLWithRandomPointer {

    //Solution 1(using HaskMap) -> t.c-0(n),A.S-0(n)
//    public Node copyRandomList(Node head) {
//        if (head == null) {
//            return null;
//        }
//        Map<Node,Node> map = new HashMap<>();
//        Node t = head;
//
//        //create copies using hashmap
//        while(t != null){
//            Node p = new Node(t.val);
//            map.put(t,p);
//            t = t.next;
//        }
//
//        t = head;
//        //connect pointers
//        while(t != null){
//            Node  r = map.get(t);
//            r.next = map.get(t.next);
//            r.random = map.get((t.random));
//            t = t.next;
//        }
//
//        return map.get(head);
//    }

    //Solution 2 - optimal
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node t = head;

        //create copy nodes insert them in between i.e A->A'->B->B'.......
        while(t != null){
            Node p = new Node(t.val);
            p.next = t.next;
            t.next = p;
            t = p.next;
        }

        Node p = head.next;

        t = head;
        Node newList = head.next;
        //connect pointers
        while(t != null){
            if(t.random != null){
                newList.random = t.random.next;
            }else{
                newList.random = null;
            }
            t= newList.next;
            if(t!=null){
                newList=t.next;
            }
        }

        t = head;
        newList = p;
        //separate List
        while (t !=null){
            t.next = newList.next;
            t = t.next;
            if(t!=null) {
                newList.next = t.next;
                newList= newList.next;
            }
        }
        return p;
    }
}
