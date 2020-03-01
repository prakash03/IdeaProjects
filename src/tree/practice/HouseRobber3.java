package tree.practice;

import java.util.Stack;

public class HouseRobber3 {
    TreeNode root;

//    public int rob(TreeNode root) {
//
//    }

    void dfs(TreeNode root){
        Stack<TreeNode> stack =  new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            System.out.println(current.val);

            if(current.left != null) { stack.push(current.left); }
            if(current.right != null) { stack.push(current.right); }
        }
    }

    public static void main(String[] args){
        HouseRobber3 tree = new HouseRobber3();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(2);
        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(4);
        tree.root.right.left = new TreeNode(4);
        tree.root.right.right = new TreeNode(3);

        tree.dfs(tree.root);
    }
}
