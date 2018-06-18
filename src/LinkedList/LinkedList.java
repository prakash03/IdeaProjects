package LinkedList;

class LinkedList {
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

    public void addAtIndex(int index, int value){
        if(index<0){
            throw new IndexOutOfBoundsException();
        }
        else if(index == 0){
            addToFront(value);
        }
        else {
            Node newNode = new Node(value);
            Node current = head;

            int i = 0;
            while (i <= index-1) {
                if (i == index-1) {
                    current.next = newNode;
                    newNode.next = current.next.next;
                } else {
                    current = current.next;
                    i++;
                }
            }
        }
    }

    public boolean contains(int value){
        Node newNode = new Node(value);
        Node current = head;
        while(current != null){
            if (current == newNode){
                return true;
            }
            else current = current.next;
        }
        return false;
    }

    public int getByIndex(int value){
        int i= 0;
        Node current = head;
        while(current != null){
            if(current.value == value){
                return i;
            }
            else i++;
        }
        return 0;
    }

    public void removeFromFront(){
        if(head != null){
        head = head.next;}
        if(head == null){
            tail = null;
        }
    }

    public void removeFromBack(){
        if(head == null){
            return;
        }
        else if (head.equals(tail)){
            head = null;
            tail = null;
        }
        Node current = head;
        while(current.next != tail){
            current = current.next;
        }
        current = tail;
        current.next = null;
    }

    public void removeAtIndex(int index){
        if(index <0){
            throw new IndexOutOfBoundsException();
        }
        else if (index == 0){
            removeFromFront();
        }
        else {
            int i = 0;
            Node current = head;
            while (i <= index - 1) {
                if (current.next == null) {
                    tail = current;
                } else if (i == index - 1) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                    i++;
                }
            }
        }
    }

    public void removeFromBack(int index){

        int i=0;
        Node current = head;
        if(current == null){
            throw new IndexOutOfBoundsException();
        }
        while(current.next != null){
            i++;
            current = current.next;
        }
        int j = 0;
        System.out.println("Index searching is: " + (i-index));
        current = head;
        System.out.println("Current is : "+ current.value);
        while(j<= i-index){
            if(j == i-index-1){
                current.next = current.next.next;
            }
            else {
                current = current.next;
                j++;

            }
        }
    }

    //This method finds the Middle Element in the LinkedLIst in a single pass i.e. O(1).
    static int findMiddle(Node head){
        Node middleFinder = head;
        Node endFinder = head;
        while(middleFinder.next!=null){
            if(endFinder.next == null || endFinder.next.next == null){
                return middleFinder.value;
            }
            middleFinder = middleFinder.next;
            endFinder = endFinder.next.next;
        }
        return 0;
    }



    public void printList(LinkedList list){
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

    public static void main(String[] args){
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        list1.addToFront(2);
        list1.addToBack(4);
        list1.addToBack(5);
        list1.addToBack(6);
        list1.addToBack(7);
        list1.addToBack(8);
        list2.addToBack(3);
        list1.addToBack(9);
        list1.printList(list1);

        System.out.println("Middle element is: " + findMiddle(list1.head));


//        list1.removeFromBack(4);
//        System.out.println("After removing :");
//        list1.printList(list1);
//        System.out.println(list2.head.value);
//        System.out.println(list2.tail.value);

    }



}
