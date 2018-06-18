package LinkedList;

//Given a sorted linked list and a value to insert, write a function to insert the value in sorted way.
public class InsertInLinkedList {
    class Node{
        int value;
        Node next = null;
        Node(int value){
            this.value = value;
        }
    }

    protected Node head = null;
    protected Node tail = null;

    public void addToFront(int value){
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        if(newNode.next == null){
            tail = newNode;
        }
    }

    public void addToBack(int value){
        Node newNode = new Node(value);
        if(tail == null){
            head = newNode;
        }else{
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void insertInList(int value){
        Node current = head;
        Node newNode = new Node(value);
        if(head.value> value){

            newNode.next = head;
            head = newNode;
        }
        else {
            while(current!= null){
                if(current.next == null){
                    current.next = newNode;
                    newNode.next = null;
                    System.out.println("it came here");
                    break;
                }

                else if(current.value < value && current.next.value >= value){
                    newNode.next = current.next;
                    current.next = newNode;
                    break;
                }

                else current = current.next;
            }
        }
    }

    public void printList(InsertInLinkedList list){
        Node current = list.head;
        while(current != tail){
            System.out.print(current.value + " --> ");
            current = current.next;
        }
        if(current == tail){
            System.out.print(current.value);
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        InsertInLinkedList list = new InsertInLinkedList();
        list.addToFront(2);
        list.addToBack(3);
        list.addToBack(4);
        list.addToBack(8);
        list.addToBack(9);
        list.insertInList(5);
        list.insertInList(8);
        list.insertInList(10);
        list.printList(list);
    }
}

