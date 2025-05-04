package linkedlists;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    void print() {
        if (head == null) {
            System.out.println("Head is empty!");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("\b\b\b  ");
        System.out.println("");
    }
}

public class LinkedListImplementation {

    public static void main(String[] args) {
        LinkedList a = new LinkedList();
        a.insert(5);
        a.insert(10);
        a.insert(12);
        a.insert(20);
        a.print();
    }

}
