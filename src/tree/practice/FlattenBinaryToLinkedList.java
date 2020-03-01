package tree.practice;

import java.util.Stack;

public class FlattenBinaryToLinkedList {
    TreeNode root;

    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root.right);
        stack.push(root.left);
        TreeNode current = root;
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();

            if(temp.right != null) stack.push(temp.right);
            if(temp.left != null) stack.push(temp.left);


            current.left = null;
            current.right = temp;
            current = current.right;
        }
    }


    public static void main(String[] args){
        FlattenBinaryToLinkedList tree = new FlattenBinaryToLinkedList();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(2);
        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(4);
        tree.root.right.left = new TreeNode(4);
        tree.root.right.right = new TreeNode(3);
    }
}
