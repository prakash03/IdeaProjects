package tree;

import tree.BinaryTree;
//Check if a binary tree is subtree of another binary tree
public class compareBinaryTrees {
    Node root1, root2;

    boolean areIdentical(Node root1, Node root2){
        if(root1 == null && root2 ==null) return true;
        if(root1 == null || root2 == null) return false;
        return(root1.data == root2.data && areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right));
        //return false;
    }

    boolean isSubtree(Node root1, Node root2){
        if(root2 == null) return true;
        if(root1 == null) return false;
        if(areIdentical(root1, root2)) return true;
        return (isSubtree(root1.left, root2) || isSubtree(root1.right, root2));
    }

    public static void main(String[] args) {
        compareBinaryTrees tree1  = new compareBinaryTrees();
        tree1.root1 = new Node (1);
        tree1.root1.left = new Node(2);
        tree1.root1.right = new Node(3);
        tree1.root1.left.left = new Node(4);
        tree1.root1.left.right = new Node (5);
        tree1.root1.left.right.left = new Node(6);
        tree1.root1.left.right.right = new Node(7);

        tree1.root2 = new Node(2);
        tree1.root2.left = new Node(4);
        tree1.root2.right = new Node(5);
        tree1.root2.right.left = new Node(6);
        tree1.root2.right.right = new Node(7);

        System.out.println(tree1.isSubtree(tree1.root1, tree1.root2));

    }

}
