package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class BFS {
    private int V;
    private LinkedList<Integer> adj[];
    BFS(int v){
        V = v;
        adj = new LinkedList[v]; //Creates and Array of LinkedList<Integer> of size 'v'.
                                // Sames as LinkedList<Integer> list[] = new LinkedList[5];
        for(int i=0; i<v; ++i){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w){

        adj[v].add(w); //Directed Graph in this Case.
    }

    void BFS(int s){
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        while(queue.size() != 0){
            s = queue.poll();
            System.out.println(s + " ");
            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                //if(visited[n]) System.out.println("Detected a cycle in the Graph.");
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void DFS(int s){
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        visited[s] = true;
        stack.push(s);

        while(stack.size() != 0){
            s = stack.pop();
            System.out.println(s + " ");
            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                //if(visited[n]) System.out.println("Detected a cycle in the Graph.");
                if(!visited[n]){
                    visited[n] = true;
                    stack.push(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS graph = new BFS(6);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(3,5);
        graph.addEdge(4,5);
        graph.addEdge(5,0);

        System.out.println("Breadth First Traversal starting form vertex 0 is: ");

        graph.BFS(0);

        System.out.println("Depth first Traversal from Vertex 0 is: ");
        graph.DFS(0);
    }
}
