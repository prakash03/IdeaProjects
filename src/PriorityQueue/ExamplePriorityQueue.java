package PriorityQueue;

import java.util.Iterator;
import java.util.PriorityQueue;

public class ExamplePriorityQueue {

    public static void main(String[] args){

        // Time Complexity on this DataStructure.
//        O(log n) time for the enqueing and dequeing methods (offer, poll, remove() and add)
//
//        O(n) for the remove(Object) and contains(Object) methods
//
//        O(1) for the retrieval methods (peek, element, and size)
        PriorityQueue<String> pQueue = new PriorityQueue<>();
        pQueue.add("ruby");
        pQueue.add("C");
        pQueue.add("java");
        pQueue.add("alphabet");
        pQueue.add("alphabet");
        pQueue.add("python");


        System.out.println("Head value:" + pQueue.peek());

        System.out.println("Queue elements:");
        Iterator itr = pQueue.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        while(itr.hasNext()){
            System.out.println("Element next removed: " + pQueue.poll());
        }

        System.out.println("After removing the first element:");
        pQueue.poll();
        Iterator itr2 = pQueue.iterator();
        while(itr2.hasNext())
            System.out.println(itr2.next());

//        PriorityQueue<Integer>




    }
}
