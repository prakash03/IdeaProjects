package Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Node{
    int val;
    List<Node> adj;
    boolean visited;

    public Node(int val){
        this.val = val;
        this.adj = new LinkedList<>();
        this.visited = false;
    }
}

public class Graph {
    Node root;
    List<Node> vertices;
    public Graph(Node root){
        this.root = root;
        this.vertices = new LinkedList<>();
        vertices.add(root);
    }

    void addNode(int val){
        vertices.add(new Node(val));
    }

    void addEdge(int vertex1, int vertex2){
        Node node_1 = new Node(vertex1);
        Node node_2 = new Node(vertex2);
        for(Node vertex : vertices){
            if(vertex.val == vertex1){
                node_1 = vertex;
            } else if(vertex.val == vertex2){
                node_2 = vertex;
            }
        }

        node_1.adj.add(node_2);
    }

    void graphDepthFirstTraversal(Node root){
        Stack<Node> stack = new Stack<>();

        stack.push(root);

        System.out.println("Depth first traversal: ");
        while(!stack.isEmpty()){
           Node current = stack.pop();
           if(!current.visited) System.out.print(" --> "+ current.val);

           current.visited = true;
           for(Node adjacent_vertex : current.adj){
                if(!adjacent_vertex.visited){
                    stack.push(adjacent_vertex);
                }
           }
        }
    }

    void graphBreadthFirstTraversal(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        System.out.println("Breadth first traversal: ");
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(!current.visited) System.out.print(" --> " + current.val);

            current.visited = true;
            for(Node adjacent_vertex : current.adj){
                if(!adjacent_vertex.visited){
                    queue.add(adjacent_vertex);
                }
            }

        }
    }


    public static void main(String[] args){
        Node root = new Node(0);
        Graph graph = new Graph(root);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(2,3);
        graph.addEdge(1,4);
        graph.addEdge(3,5);
        graph.addEdge(4,5);
        graph.addEdge(5,1);

        for(Node vertex : graph.vertices){
            System.out.print("Head: " + vertex.val);
            for(Node adj : vertex.adj){
                System.out.print(" -- > " + adj.val);
            }
            System.out.println("\n");
        }

//        graph.graphBreadthFirstTraversal(root); //Only of the 2 methods can be called at once since each of these mark the nodes as visited.
        graph.graphDepthFirstTraversal(root);
    }
}
