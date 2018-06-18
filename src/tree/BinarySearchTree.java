package tree;

class BinarySearchTree{
    Node root;
    class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    void insert(int data){
        insert(root, data);
    }

    void insert(Node root, int data){
        Node newNode = new Node(data);
        if(root == null) root = newNode;
        if(root.data > newNode.data){
            insert(root.left, data);
        }
        else insert(root.right, data);
    }

    boolean search(int data){

        return false;
    }

    void inOrder(Node root){
        inOrder(root.left);
        System.out.println(root.data+ " ");
        inOrder(root.right);
    }

    //Check whether the given Binary Tree is a Binary Search Tree.
    boolean isValidBST(){
        return isValidBST(root);
    }

    boolean isValidBST(Node root){
        if(root.left == null && root.right == null) return true;
        if(root.left == null && root.right.data < root.data) return false;
        if(root.left.data >= root.data && root.right == null) return false;
        if(root.left.data >= root.data || root.right.data<root.data){
            return false;
        }

        return true;
    }

    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(6);
        tree.insert(8);
        tree.insert(9);
        tree.insert(10);
        tree.insert(4);
        tree.insert(2);

        tree.inOrder(tree.root);




    }
}