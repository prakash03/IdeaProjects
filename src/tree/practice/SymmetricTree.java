package tree.practice;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    TreeNode root;

    /**
     * Leetcode problem: https://leetcode.com/problems/symmetric-tree/
     *
     */

    /**
     * Iterative Approach
     */
    boolean isSymmetricIterative(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode root1 = queue.poll();
            TreeNode root2 = queue.poll();
            if(root1 == null && root2 == null) { continue; }

            if(root1 == null || root2 == null) { return false; }

            if(root1.val != root2.val) { return false; }

            queue.add(root1.left);
            queue.add(root2.right);
            queue.add(root1.right);
            queue.add(root2.left);

        }

        return true;
    }

    /**
    Recursive Approach
     */
    boolean isSymmetric(TreeNode node1, TreeNode node2){
        if(node1 == null || node2 == null) { return node1 == node2; } //How does equality between 2 objects work?

        return node1.val == node2.val && isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }

    boolean isSymmetric(TreeNode root){

        if (root == null) return true;

        return isSymmetric(root.left , root.right);
    }

    public static void main(String[] args){
        SymmetricTree tree = new SymmetricTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(2);
        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(4);
        tree.root.right.left = new TreeNode(4);
        tree.root.right.right = new TreeNode(3);

        System.out.println(tree.isSymmetric(tree.root));

        System.out.println(tree.isSymmetricIterative(tree.root));
    }
}
