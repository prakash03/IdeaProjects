package tree;

import tree.BinaryTree;

import java.util.Arrays;

public class buildTree {
    Node root;

    class Node{
        char data;
        Node left, right;
        Node(char data){
            this.data = data;
            left = right = null;
        }
    }

//    void buildTree(char[] inOrder, char[] preOrder, buildTree tree){
//        int preOrderIndex = 0;
//        Node newNode = new Node(preOrder[preOrderIndex]);
//        int inOrderIndex = 0;
//        for(int i=0; i<inOrder.length; i++){
//            if(inOrder[i] == newNode.data) {
//                inOrderIndex = i;
//                break;
//            }
//        }
//        tree.root = newNode;
//        char[] inOrder_left = Arrays.copyOfRange(0, inOrderIndex);
//        tree.root.left = buildTree();
//    }

    public static void main(String[] args) {
        buildTree tree = new buildTree();
        char inOrder[] = new char[]{'D','B','E','A','F','C'};
        char preOrder[] = new char[]{'A','B','D','E','C','F'};
//        tree.buildTree(inOrder, preOrder, tree);
    }
}
