package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeSearch {
    Node root;

    void bfs(){
        bfs(root);
    }

    void bfs(Node root){
        Queue<Node> queue = new LinkedList<>();
        System.out.println(root.data);
        queue.add(root.left);
        queue.add(root.right);
        bfs(queue);
    }

    void bfs(Queue<Node> queue){
        if(queue.isEmpty())return ;    //Base Case for Recursion.
        Queue<Node> newQueue = new LinkedList<>();
        while(!queue.isEmpty()){
            System.out.print(queue.peek().data);
            if(queue.peek().left !=null) newQueue.add(queue.peek().left);
            if(queue.peek().right !=null)newQueue.add(queue.peek().right);
            queue.remove();
        }
        System.out.println(" ");
        bfs(newQueue);
    }

    void dfs(){
        dfs(root);
    }

    void dfs(Node root){
        Stack<Node> stack = new Stack<>();
        System.out.print(root.data + " ");
        stack.push(root.right);
        stack.push(root.left);
        while(!stack.empty()){
            Node top = stack.pop();
            System.out.print(top.data+ " ");
            if(top.right!= null) stack.push(top.right);
            if(top.left!= null) stack.push(top.left);
        }
    }

    boolean isValidBST(){
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isValidBST(Node root, int min, int max){
        if(root == null) return true;
        if(root.data<= min || root.data>=max){
            return false;
        }
        return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
    }

//    boolean isValidBST(Node root){
//        if(root == null) return true;
//        if(root.left == null && root.right == null) return true;
//        if(root.left == null){
//            if(root.right.data < root.data) return false;
//        }
//        if( root.right == null){
//            if(root.left.data >= root.data) return false;
//        }
//        if(root.left.data >= root.data || root.right.data<root.data) return false;
//        if(root.left.data < root.data && root.right.data> root.data) {
//            return (isValidBST(root.left) && isValidBST(root.right));
//        }
//        return true;
//    }

    public static void main(String[] args) {
        TreeSearch tree = new TreeSearch();
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

        tree.bfs();
        tree.dfs();
        System.out.println(" ");
        System.out.println("Is the tree a valid bst? " + tree.isValidBST());
    }
}
