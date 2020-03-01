package tree.practice;


import java.util.Stack;

public class FindGreaterTree {
    TreeNode root;
    int max = 0;
//    TreeNode current = root;
//    Stack<Integer> stack = new Stack<>();

//    void reverseInOrderTraversal(TreeNode root){
//        if(root != null){
//            reverseInOrderTraversal(root.right);
//            stack.push(root.val);
//            root.val += stack.pop();
//
//            reverseInOrderTraversal(root.left);
//        }
//    }


    public TreeNode convertBST(TreeNode root) {
        if(root != null){
           convertBST(root.right);
            max += root.val;
            root.val = max;
           convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args){
        FindGreaterTree tree = new FindGreaterTree();
        tree.root = new TreeNode(5);
        tree.root.left = new TreeNode(3);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(4);

        tree.root.right = new TreeNode(9);
        tree.root.right.left = new TreeNode(7);
        tree.root.right.right = new TreeNode(11);

        System.out.println(tree.convertBST(tree.root));
    }
}
