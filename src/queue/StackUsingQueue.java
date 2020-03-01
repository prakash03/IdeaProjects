package queue;
import java.util.*;
/*
push() and poll()
1 <-- 2 <-- 3 <-- 4
poll - Output Expected  :4 (stack) LIFO
Method 1: //Making the push() operation costly - O(n)
primaryQueue   :  1 --> 2 --> 3
secondaryQueue :

Method 2: makes the pop() costly - O(n)

 */
public class StackUsingQueue {
    private Queue<Integer> primaryQueue = new LinkedList<>();
    private Queue<Integer> secondaryQueue = new LinkedList<>();

    public StackUsingQueue(){} //Hybrid Stack!

    public void push(int x){
        secondaryQueue.add(x);
        while(!primaryQueue.isEmpty()){
            secondaryQueue.add(primaryQueue.poll());
        }
        Queue<Integer> temp = new LinkedList<>();
        temp = primaryQueue;
        primaryQueue = secondaryQueue;
        secondaryQueue = temp;
    }

    public int pop(){
        if(primaryQueue.isEmpty()) throw new IndexOutOfBoundsException();
        return primaryQueue.poll();
    }

    public static void main(String[] args){
        StackUsingQueue hybridStack = new StackUsingQueue();
        hybridStack.push(1);
        hybridStack.push(2);
        hybridStack.push(3);
        hybridStack.push(4);
        System.out.println(hybridStack.pop());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue.peek());


    }
}
