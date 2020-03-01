package newTreePackage;

public class InOrderPredecessor extends BinaryTree {

    void findInOrderPredecessor(TreeNode root, TreeNode key){
        int predecessor = key.val;
        findInorderPredecessor(root, key, predecessor);
    }

    void findInorderPredecessor(TreeNode root, TreeNode key, int predecessor) {
        if(root == null) {
            System.out.println("InOrder predecessor is: " + predecessor);
            return;
        }

        if(root.val >= key.val) {
            findInorderPredecessor(root.left, key, predecessor);
        }
        else if(root.val < key.val){
            predecessor = root.val;
            findInorderPredecessor(root.right, key, predecessor);
        }
    }


    public static void main(String[] args) {
        InOrderPredecessor tree = new InOrderPredecessor();
        tree.root = new TreeNode(5);
        tree.root.left = new TreeNode(3);
        tree.root.right = new TreeNode(10);
        tree.root.left.left = new TreeNode(2);
        tree.root.left.right = new TreeNode(4);
        tree.root.right.left = new TreeNode(7);
        tree.root.right.right = new TreeNode(15);

        TreeNode key = new TreeNode(2);
        tree.findInOrderPredecessor(tree.root, key);
    }
}
