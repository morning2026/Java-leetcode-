package hot100;

import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {

    static class Node{
        int key,val;
        Node prev;
        Node next;
        Node(int key,int val){
            this.key =key;
            this.val =val;
        }
    }
    int size,capacity;
    Node head;
    Node tail;

    Map<Integer,Node> map; // 灵魂之处，注意存node不是存val

    public LRUCache146(int capacity) {
        this.capacity = capacity;
        head = new Node(0,0);// 初始化全放这里,先new
        tail  = new Node(0,0);
        head.next = tail;
        tail.prev = head;//头尾不要忘
        map = new HashMap<>(); // 空集合
        size = 0;
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null)
            return -1;
        remove(node);
        addToTop(node);
        return node.val;// 看题
    }

    public void put(int key, int value) {
        Node node;
        if(map.containsKey(key)){//功能实现
            node = map.get(key); //存的是地址，不用改
            node.val =value;
            remove(node);
            addToTop(node);//更新
            return;
        }
        node = new Node(key,value);
        addToTop(node);
        size++;
        map.put(key,node);//放入map
        if(size>capacity){
            Node p = tail.prev;
            remove(p);// 封装
            map.remove(p.key);
            size--;//扣大小
        }
    }

    private void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    private void addToTop(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
    }
}
