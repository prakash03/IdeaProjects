package Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphRep {
    private static class Graph{
        int V;
        LinkedList<Integer> adjListArray[];
        Graph(int V){
            this.V = V;
            adjListArray = new LinkedList[V];
            for(int i=0; i<V; i++){
                adjListArray[i] = new LinkedList<>();  //LinkedList<Integer>[] array = new LinkedList[6];
            }
        }
    }

    static void addEdge(Graph graph, int src, int dest){
        graph.adjListArray[src].addFirst(dest);  //Undirected Graph.
        graph.adjListArray[dest].addFirst(src);
    }

    static void printGraph(Graph graph){
        for(int v=0; v<graph.V; v++){
            System.out.println("Adjacency List of Vertex " + v);
            System.out.print("Head ");
            for(Integer value : graph.adjListArray[v]){
                System.out.print(" --> " + value);
            }
            System.out.println("\n");
        }
    }





    public static void main(String[] args){
        int V = 6;
        Graph graph = new Graph(6);
        addEdge(graph,0,1);
        addEdge(graph,0,2);
        addEdge(graph,1,3);
        addEdge(graph,2,4);
        addEdge(graph,3,5);
        addEdge(graph,4,5);
        addEdge(graph,5,0);

        printGraph(graph);
    }
}
