package newTreePackage;

public class FloorAndCeilOfBST extends BinaryTree {

    // Find floor and Ceil of a BST https://www.techiedelight.com/floor-ceil-bst-iterative-recursive/
    void findFloorAndCeil(TreeNode root, int key){
        int floor = Integer.MAX_VALUE;

        int ceil = Integer.MIN_VALUE;

        findFloorAndCeil(root, key, floor, ceil);
    }

    void findFloorAndCeil(TreeNode root, int key, int floor, int ceil){

        if(root == null){
            if(floor != Integer.MAX_VALUE) {
                System.out.println("Floor is: " + floor);}
            if( ceil != Integer.MIN_VALUE) {
                System.out.println("Ceil is: " + ceil);
            }
            return;
        }

        if(root.val > key){
            ceil = root.val;
            findFloorAndCeil(root.left, key, floor, ceil);
        }
        else if(root.val < key){
            floor = root.val;
            findFloorAndCeil(root.right, key, floor, ceil);
        }
        else if(root.val == key){
            System.out.println("Floor and ceil are both: " + root.val);
        }
    }

    public static void main(String[] args){
        FloorAndCeilOfBST tree = new FloorAndCeilOfBST();
        tree.root = new TreeNode(5);
        tree.root.left = new TreeNode(3);
        tree.root.right = new TreeNode(10);
        tree.root.left.left = new TreeNode(2);
        tree.root.left.right = new TreeNode(4);
        tree.root.right.left = new TreeNode(7);
        tree.root.right.right = new TreeNode(15);

        int key = 7;
        tree.findFloorAndCeil(tree.root, 6);
    }
}
