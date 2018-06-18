package LinkedList;

public class LinkedListUnionIntersection {
    protected Node head;
    protected Node tail;
    static class Node{
        int value;
        Node next = null;
        Node(int value){
            this.value = value;
        }
    }

    private void addToBack(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
        }
        else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void printList(Node headNode){
        Node current = headNode;
        while(current!= null){
            if(current == headNode){
                System.out.print(headNode.value);
                current = current.next;
            }
            System.out.print( " --> " + current.value);
            current = current.next;
        }
        System.out.println(" ");
    }

    private boolean contains(int value){
        Node current = head;
        while(current!=null){
            if(current.value == value) return true;
            else{
                current = current.next;
            }
        }
        return false;
    }

    public static void union(Node headA, Node headB){
        LinkedListUnionIntersection newList = new LinkedListUnionIntersection();
        Node currentA = headA;
        Node currentB = headB;
        while(currentA!=null){
            if(!newList.contains(currentA.value)){
                newList.addToBack(currentA.value);
            }
            currentA = currentA.next;
        }

        while(currentB!=null){
            if(!newList.contains(currentB.value)){
                newList.addToBack(currentB.value);
            }
            currentB = currentB.next;
        }
        newList.printList(newList.head);
    }

    public static void intersection(Node headA, Node headB){
        LinkedListUnionIntersection newList = new LinkedListUnionIntersection();
        Node currentA = headA;
        while(currentA!=null){
            if(!newList.contains(currentA.value)){
                Node currentB = headB;
                while(currentB!=null){
                    if(currentB.value == currentA.value) newList.addToBack(currentA.value);
                    currentB = currentB.next;
                }
            }
            currentA = currentA.next;
        }
        newList.printList(newList.head);
    }

    public static void main(String[] args){
        LinkedListUnionIntersection list1 = new LinkedListUnionIntersection();
        list1.addToBack(1);
        list1.addToBack(2);
        list1.addToBack(3);
        Node head = new Node(1);
        list1.printList(list1.head);

        LinkedListUnionIntersection list2 = new LinkedListUnionIntersection();
        list2.addToBack(4);
        list2.addToBack(5);
        list2.addToBack(2);
        list2.addToBack(6);
        list2.addToBack(3);
        list2.printList(list2.head);

        union(list1.head, list2.head);
        intersection(list1.head, list2.head);


    }
}
