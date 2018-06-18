package LinkedList;


//import java.util.LinkedList;

class LinkedListString { //Was unable to name this class LinkedList as a duplicate class existed in the same package.
    class Node {
        char data;
        Node next = null;

        Node(char data) {
            this.data = data;
        }
    }

    protected Node head = null;
    protected Node tail = null;

    public void addToBack(char alpha){
        Node newNode = new Node(alpha);
        if(tail == null){
            head = newNode;
        }else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    private int size(LinkedListString list){
        if(list.head == null) return 0;
        else{
            Node current = head;
            int i = 1;
            while(current != null){
                if(current.next == null){
                    return i;
                }
                else {
                    current = current.next;
                    i++;
                }
            }
        }
        return 0;
    }

    public static int compare(Node headA, Node headB){
        Node currentA = headA;
        Node currentB = headB;
        while(currentA!=null && currentB!= null){
            if(currentA.next != null && currentB.next == null) return 1;
            else if(currentA.next == null && currentB.next != null) return -1;
            else if (currentA.data != currentB.data) return (currentA.data > currentB.data ? 1 :-1); //Ternary Operator
            else {
                currentA = currentA.next;
                currentB = currentB.next;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        LinkedListString list1 = new LinkedListString();
        LinkedListString list2 = new LinkedListString();

        list1.addToBack('a');
        list1.addToBack('b');
        list1.addToBack('c');
        list1.addToBack('f');
        System.out.println(list1.size(list1));

        list2.addToBack('a');
        list2.addToBack('b');
        list2.addToBack('c');
        list2.addToBack('e');
        list2.addToBack('g');

        System.out.println(compare(list1.head, list2.head));
    }


}

/*

public class compareString {
    class Node{
        int value;
        Node next = null;
        Node(int value){
            this.value = value;
        }
    }

    public static int compare(LinkedList<Character> list1, LinkedList<Character> list2){
        if(list1.size()!=list2.size()){
            if(list1.size()>list2.size()) return 1;
            else return -1;
        }
        Character head1 = list1.getFirst();
        Character head2 = list2.getFirst();
        Character current1 = head1;
            int i = 0;
            while(i<list1.size()){
                if(list1.get(i) > list2.get(i)){
                    return 1;
                }
                else if(list1.get(i) < list2.get(i)){
                    return -1;
                }
                else if(list1.get(i) == list2.get(i) && i==list1.size()-1){
                    return 0;
                }
                else i++;
            }
        return 2;
    }


    public static void main(String[] args){
        LinkedList<Character> list = new LinkedList<>();
        list.add('a');
        list.add('a');
        list.add('c');
        //list.add('d');
        LinkedList<Character> list2 = new LinkedList<>();
        list2.add('a');
        list2.add('b');
        list2.add('d');
        int answer = compare(list, list2);
        System.out.println(answer);

    }
}
*/
