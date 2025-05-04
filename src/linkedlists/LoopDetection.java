package linkedlists;

import java.util.HashMap;

public class LoopDetection {

    public static void main(String[] args) {
        LinkedList a = new LinkedList();
        a.insert(5);
        a.insert(10);
        a.insert(12);
        a.insert(20);
        a.head.next.next.next = a.head; // form a cycle
        HashMap<Node, Number> map = new HashMap<>();
        Node temp = a.head;
        while (temp != null) {
            if (map.containsKey(temp)) {
                System.out.println("Cycle found!");
                return;
            }
            map.put(temp, 1);
            temp = temp.next;
        }
        System.out.println("No Cycle found!");

    }

}
