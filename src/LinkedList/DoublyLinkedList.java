package LinkedList;

public class DoublyLinkedList {

    Node head;

    static class Node {
        int val;
        Node next, prev;
        Node(int val){
            this.val = val;
            next = prev = null;
        }
    }

    /**
     * Reverses the given Doubly linked LinkedList
     * @return The head of the new LinkedList created after reversal.
     */
    Node reverseLinkedList(){

        Node current = head;

        /*
           2 -> 5 -> 8 -> 1 -> 0
         */
        while(current != null){
            Node temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            if(temp == null) return current;
            current = temp;
        }


        return current;
    }



    void insert(int val) {

        Node current = head;

        while(current.next != null){
            current = current.next;
        }

        Node newNode = new Node(val);

        current.next = newNode;
        newNode.prev = current;
    }

    public static void main(String[] args){
        /*
        2 -> 5 -> 8 -> 1 -> 0
          <-   <-   <-   <-

        head
        tail
         */

        DoublyLinkedList dll = new DoublyLinkedList();
        dll.head = new Node(2);
        dll.insert(5);
        dll.insert(8);
        dll.insert(8);
        dll.insert(1);
        dll.insert(0);

        System.out.println(dll.head.next.val);
        System.out.println(dll.head.next.next.val);
        System.out.println(dll.head.next.prev.val);

        Node newHead = dll.reverseLinkedList();
        System.out.println("After reversing....");
        System.out.println(newHead.val);
        System.out.println(newHead.next.val);
        System.out.println(newHead.next.next.val);
        System.out.println(newHead.next.prev.val);
    }
}
