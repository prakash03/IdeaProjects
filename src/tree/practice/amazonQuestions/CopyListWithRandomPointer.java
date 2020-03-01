package tree.practice.amazonQuestions;

import java.util.*;

public class CopyListWithRandomPointer {

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        for (Node curr = head; curr != null; curr = curr.next) {
            map.put(curr, new Node(curr.val));
        }
        for (Node curr = head; curr != null; curr= curr.next) {
            Node clonedCurr = map.get(curr);
            clonedCurr.next = map.get(curr.next);
            clonedCurr.random = map.get(curr.random);
        }
        return map.get(head);
    }
}
