package tree;

import java.util.*;

public class TreeProperties {
    Node root;

    //Minimum Depth of a Binary Tree is the number of nodes along the shortest path from root node to the nearest leaf node.
    int minimumDepth(){
        return minimumDepth(root);
    }

    int minimumDepth(Node root){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }

        if(root.left == null){
            return minimumDepth(root.right)+1;
        }

        if(root.right == null){
            return minimumDepth(root.left) +1;
        }

        return 1 + Math.min(minimumDepth(root.left), minimumDepth(root.right));
    }

    //MAXIMUM DEPTH or the HEIGHT of the Binary Tree is the Number of nodes along the longest path from the root node to the leaf nodes.
    //Finding the Height of the Tree.
    int maximumDepth(){
        return maximumDepth(root);
    }

    int maximumDepth(Node root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(maximumDepth(root.left), maximumDepth(root.right));
    }

    //https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
    //DIAMETER of the tree is the number of nodes in the longest path between two leaf nodes in the tree.
    //The diameter of a tree T is the largest of the following quantities:
    //* the diameter of T’s left subtree
    //* the diameter of T’s right subtree
    //* the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T).

    int diameter(){
        return diameter(root);
    }

    int diameter(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = maximumDepth(root.left);
        int rightHeight = maximumDepth(root.right);

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        return Math.max(leftHeight+ rightHeight+1, Math.max(leftDiameter, rightDiameter));
    }

    public static void main(String[] args){
        TreeProperties tree = new TreeProperties();
        tree.root = new Node(5);
        tree.root.left = new Node(3);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(4);
        tree.root.left.left.left = new Node(0);

        tree.root.right = new Node(10);
        tree.root.right.left = new Node(8);
        tree.root.right.right = new Node(11);
        tree.root.right.right.right = new Node(15);
        tree.root.right.right.right.left = new Node(12);
        tree.root.right.right.right.left.right = new Node(13);

        System.out.println("Minimum depth is: " + tree.minimumDepth());
        System.out.println("Maximum depth is: " + tree.maximumDepth());
        System.out.println("Diameter is : "+ tree.diameter());
    }
}
