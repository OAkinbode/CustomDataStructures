package lib.datastructures;

import lib.datastructures.linear.LLQueue;
import lib.datastructures.linear.LLStack;
import lib.datastructures.nodes.NodeS;

public class AppStackQueueTest {
    public static void main (String [] args) {
        LLStack test = new LLStack();
        test.push(new NodeS(2));
        test.push(new NodeS(7));
        test.push(new NodeS(4));
        test.push(new NodeS(6));
        test.push(new NodeS(3));
        
        test.elements();

        test.pop();
        test.pop();

        test.elements();
        System.out.println("Peek");
        test.peek();
        

        LLQueue test6 = new LLQueue();
        test6.enqueue(new NodeS(2));
        test6.enqueue(new NodeS(7));
        test6.enqueue(new NodeS(4));
        test6.enqueue(new NodeS(6));
        test6.enqueue(new NodeS(3));
        
        test6.elements();

        test6.dequeue();
        test6.dequeue();

        test6.elements();
        System.out.println("Peek");
        test6.peek();
    
    }
}

