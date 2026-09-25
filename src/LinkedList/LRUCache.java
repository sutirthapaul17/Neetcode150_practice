package LinkedList;

import java.util.HashMap;
import java.util.Map;

// using hashmap to solve it, but get and put function takes 0(n) time -> remove function
//class LRUCache {
//
//    int capacity;
//    Map<Integer,Integer> map = new HashMap<>();
//    List<Integer> usage = new ArrayList<>();
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        if(!map.containsKey(key)){
//            return -1;
//        }
//        if(!usage.isEmpty())
//            usage.remove((Integer)key);
//        usage.add(key);
//        return map.get(key);
//
//    }
//
//    public void put(int key, int value) {
//
//        if(map.containsKey(key)){
//            map.put(key,value);
//
//            usage.remove((Integer) key);
//            usage.add(key);
//            return;
//        }
//        map.put(key,value);
//        usage.add(key);
//        if(map.size()>capacity){
//            int lruKey = usage.removeFirst();
//            map.remove(lruKey);
//        }
//    }
//}

class Node1{
    int key;
    int val;
    Node1 next;
    Node1 prev;
    Node1(int key,int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

public class LRUCache {
    Map<Integer,Node1> map = new HashMap<>();
    int capacity;
    Node1 head,tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node1 node = map.get(key);
        if (node == null){
            return -1;
        }
        moveNodeToLast(node);

        return node.val;
    }

    private void moveNodeToLast(Node1 node) {
        //Already the most recently used
        if(node == tail){
            return;
        }
        if (node == head) {
            head = node.next;
        }
        //this is not the first node
        if(node.prev != null){
            node.prev.next = node.next;
        }
        //this is not the last node
        if(node.next != null){
            node.next.prev = node.prev;
        }

        node.prev = tail;
        node.next = null;
        tail.next = node;
        tail = node;
    }

    public void put(int key, int value) {
        if(!map.containsKey(key)){
            Node1 p = new Node1(key,value);
            if(head == null){
                head = tail = p;
            }else{
                p.prev = tail;
                tail.next = p;
                tail = p;
            }
            map.put(key,p);
        }
        Node1 n = map.get(key);
        n.val = value;
        moveNodeToLast(n);
        if(map.size() > capacity){
            Node1 lru = head;
            head = head.next;
            //if head was not the only node
            if(head != null){
                head.prev = null;
            }
            map.remove(lru.key);
        }
    }
}