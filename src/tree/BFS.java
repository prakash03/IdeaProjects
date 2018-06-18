package tree;
import tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    Node root;

    int height() {return height(root);}

    int height(Node root){
        if(root ==null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    void bfs(){ bfs(root);}

    void bfs(Node root){
        for(int d = 1; d<= height(root); d++){
            System.out.println(" ");
            printBfs(root, d);
        }
    }

    void printBfs(Node root, int d){
        if(root == null) return;
        if(d == 1){
            System.out.print(root.data+ " ");
        }
        else{
            printBfs(root.left, d-1); //Awesomeness man
            printBfs(root.right, d-1);
        }
    }


    void printBfsUsingQueue(){printBfsUsingQueue(root);}

    void printBfsUsingQueue(Node root){
        Queue<Node> queue = new LinkedList<>();
        System.out.println(root.data);
        queue.add(root.left);
        queue.add(root.right);
        printBfsUsingQueue(queue);
    }

    void printBfsUsingQueue(Queue<Node> queue){
        if(queue.isEmpty())return ;    //Base Case for Recursion.
        Queue<Node> newQueue = new LinkedList<>();
        while(!queue.isEmpty()){
            System.out.print(queue.peek().data+" ");
            if(queue.peek().left !=null) newQueue.add(queue.peek().left);
            if(queue.peek().right !=null)newQueue.add(queue.peek().right);
            queue.remove();
        }
        System.out.println(" ");
        printBfsUsingQueue(newQueue); //Recursive Call
    }

    public static void main(String[] args){
        BFS tree = new BFS();
        tree.root = new Node (1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node (5);
        tree.root.left.right.right = new Node(6);
        //tree.bfs();
        System.out.println(tree.height());
        System.out.println("Iterating over each level: O(n^2) runtime");
        tree.bfs();
        System.out.println(" ");
        System.out.println("Printing tree using queue and the approach has a O(n) runtime");
        tree.printBfsUsingQueue();
    }
}
