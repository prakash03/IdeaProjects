package tree.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ChildLinkedListsProblem {

    static LinkedList<Node> createChildLinkedList(LinkedList<Node> list){
        LinkedList<Node> childLinkedList = new LinkedList<>();
        for(Node current: list){
            if(current.left != null) { childLinkedList.add(current.left); }
            if(current.right != null) { childLinkedList.add(current.right); }
        }

        return childLinkedList;
    }

    static List<LinkedList<Node>> createLists(Node root){
        List<LinkedList<Node>> lists = new ArrayList<>();

        LinkedList<Node> currentLevel = new LinkedList<>();
        currentLevel.add(root);
        while(!currentLevel.isEmpty()){
            LinkedList<Node> nextLevel = createChildLinkedList(currentLevel);
            if(!nextLevel.isEmpty()) { lists.add(nextLevel); }
            currentLevel = nextLevel;
        }

        return lists;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node('p');
        tree.root.left = new Node('r');
        tree.root.left.left = new Node('k');
        tree.root.left.right = new Node('a');
        tree.root.right = new Node('a');
        tree.root.right.left = new Node('s');
        tree.root.right.right = new Node('h');

        List<LinkedList<Node>> result = createLists(tree.root);
        for(LinkedList<Node> list: result){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
