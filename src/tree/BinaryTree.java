package tree;

class Node{
    int data ;
    Node left, right;
    public Node(int item){
        this.data = item;
        left = right = null;
    }
}

class BinaryTree{
    Node root;

    int minimumDepth(){ //Wrapper functionfor the recursion
        return minimumDepth(root);
    }

    int minimumDepth(Node root){
        if(root == null){
            return 0;
        }
        else if(root.left == null && root.right== null){
            return 1;
        }
        else if (root.left != null && root.right == null){
            return minimumDepth(root.left)+1;
        }
        else if (root.left == null && root.right != null){
            return minimumDepth(root.right)+1;
        }
        else return 1 + Math.min(minimumDepth(root.left), minimumDepth(root.right));
    }

    void inOrder() { inOrder(root);} //Wrappers for the recursive functions;
    void preOrder() { preOrder(root); }
    void postOrder() { postOrder(root); }

    void inOrder(Node root){ //Recursive Functions
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    void postOrder(Node root){
        if(root ==null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");

    }

    //Driver Method
    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.root = new Node (1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node (5);
        tree.root.left.right.right = new Node(6);
        System.out.println("Depth is : " + tree.minimumDepth(tree.root));
        tree.inOrder();
        System.out.println(" ");
        tree.preOrder();
        System.out.println(" ");
        tree.postOrder();
    }
}