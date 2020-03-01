package tree.practice;

import java.util.*;

class Node{
    Object data;
    Node left, right;
    public Node(Object data){
        this.data = data;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;
    List<Integer> nodeList = new ArrayList<>();

    void traverseInOrder() { traverseInOrder(root); }

    private void traverseInOrder(Node root){

        if(root != null){
            traverseInOrder(root.left);
            System.out.println(root.data);
            traverseInOrder(root.right);
        }
    }

    List<Integer> inOrderTraversal() {
        inOrderTraversal(root);
        return nodeList;
    }

    void inOrderTraversal(Node root){
        if(root != null){
            inOrderTraversal(root.left);
            nodeList.add(Integer.valueOf(root.data.toString()));
            inOrderTraversal(root.right);
        }
    }

    void traversePreOrder() { traversePreOrder(root); }

    private void traversePreOrder(Node root){
        if(root != null){
            System.out.println(root.data);
            traversePreOrder(root.left);
            traversePreOrder(root.right);
        }
    }

    void traversePostOrder() { traversePostOrder(root); }

    private void traversePostOrder(Node root){
        if(root != null){
            traversePostOrder(root.left);
            traversePostOrder(root.right);
            System.out.println(root.data);
        }
    }

    void breadthFirstTraversal() { breadthFirstTraversal(root);}

    private void breadthFirstTraversal(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            System.out.println(currentNode.data);
            if(currentNode.left != null) { queue.add(currentNode.left); }
            if(currentNode.right != null) { queue.add(currentNode.right); }
        }

    }

    void depthFirstTraversal() { depthFirstTraversal(root); }

    private void depthFirstTraversal(Node root){
        Stack<Node> stack = new Stack<>();

        stack.push(root);
        while(!stack.isEmpty()){
            Node currentNode = stack.pop();
            System.out.println(currentNode.data);
            if(currentNode.left != null) { stack.push(currentNode.left); }
            if(currentNode.right != null) { stack.push(currentNode.right); }
        }

    }


    // TODO: Change the below implementation to an O(logn) solution.
    boolean isBinarySearchTree() { return isBinarySearchTree(root); }

    private boolean isBinarySearchTree(Node root){
        int[] nodesInOrder = inOrderTraversal().stream().mapToInt(i->i).toArray(); //Reference from https://stackoverflow.com/questions/960431/how-to-convert-listinteger-to-int-in-java

        System.out.println(Arrays.toString(nodesInOrder));
        for(int i = 1; i < nodesInOrder.length; i++){
            if(nodesInOrder[i-1] > nodesInOrder[i]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.root = new Node('p');
        tree.root.left = new Node('r');
        tree.root.left.left = new Node('k');
        tree.root.left.right = new Node('a');
        tree.root.right = new Node('a');
        tree.root.right.left = new Node('s');
        tree.root.right.right = new Node('h');


        System.out.println("------- InOrder Traversal --------");
        tree.traverseInOrder();

        System.out.println("------- PreOrder Traversal --------");
        tree.traversePreOrder();

        System.out.println("------- PostOrder Traversal --------");
        tree.traversePostOrder();

        System.out.println("------- Breadth first traversal --------");
        tree.breadthFirstTraversal();

        System.out.println("------- Depth First Traversal ---------");
        tree.depthFirstTraversal();

        BinaryTree tree2 = new BinaryTree();
        tree2.root = new Node(14);
        tree2.root.left = new Node(8);
        tree2.root.left.left = new Node(3);
        tree2.root.left.right = new Node(11);
        tree2.root.right = new Node(20);
        tree2.root.right.left = new Node(16);
//        tree2.root.right.right = new Node(1);

        System.out.println("------------ Inorder traversal -----------");
//        Object[] nodesInOrder = tree2.inOrderTraversal().toArray();
//        System.out.println(Arrays.toString(nodesInOrder));
        System.out.println(tree2.isBinarySearchTree());
    }
}
