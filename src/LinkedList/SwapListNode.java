package LinkedList;

public class SwapListNode {
    ListNode head = null;

    void insert(ListNode node){
        if(head == null){
            head = node;
        } else {
            ListNode current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = node;
        }
    }

    void printList(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.println(current.val);
            current = current.next;
        }
    }

    ListNode swapPairs(ListNode head){
        if(head == null) return head;

        ListNode current = head;
        while(current.next != null) {
            ListNode temp = current.next;
            current.next = current.next.next;
            temp.next = current;
            current = temp;
        }

        return head; //How do I iterate till the end of list and still return the head, when the head has been modified?
    }

    public static void main(String[] args){
        SwapListNode list = new SwapListNode();
        list.insert(new ListNode(1));
        list.insert(new ListNode(4));
        list.insert(new ListNode(5));
        list.insert(new ListNode(6));



        list.printList(list.head);

        ListNode new_head = list.swapPairs(list.head);
        list.printList(new_head);

    }
}
