package tree;

import tree.BinaryTree;


public class checkBinaryTree {
    Node root;

    /*
Check whether a binary tree is a full binary tree or not.
A full binary tree is defined as a binary tree in which all nodes have either zero or two child nodes.
*/
    boolean isFull(){ return isFull(root);}

    boolean isFull(Node root){
        if(root.left == null && root.right == null) return true;
        if((root.left != null && root.right == null) || (root.left == null && root.right != null)) return false;
        return isFull(root.left) && isFull(root.right);
    }

    // Check whether a binary tree is a complete tree or not.
    //A complete Binary tree is a tree in which all the levels except the last level are completely filled and leaves
    // in the last level are to be on the left side.

    boolean isComplete(){
        return isComplete( root);
    }

    boolean isComplete(Node root){
        return false;
    }
    public static void main(String[] args) {
        checkBinaryTree tree = new checkBinaryTree();
        tree.root = new Node (1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node (5);
        //tree.root.left.right.right = new Node(6);

        System.out.println(tree.isFull());
    }
}
