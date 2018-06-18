package Stacks;

import java.util.*;
/*
Wrong implementation done below!
Here is how the puush and the pop options should functiion.
push() - For each push operation , simply push the element normally into the Stack
poll() - For each poll() ccall, pop() and add all element into another stack, until it is empty and then pop the first element in this new Stack.
 */
//Implement a Queue using a Stack
public class QueueRep {
    static Stack<Integer> virtualQueue(Stack<Integer> stack){
        Stack<Integer> tempStack = new Stack<>();
        while(!stack.empty()){
            tempStack.add(stack.pop());
        }

        return tempStack;
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        System.out.println(queue.peek()+ " , "+ stack.peek());
        Stack<Integer> queueFromStack = virtualQueue(stack);
        System.out.println(queue.peek()+ " , "+ stack.peek());
        System.out.println(queue.peek() + " , "+ queueFromStack.peek());

    }
}
