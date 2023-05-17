package lib.datastructures;

import lib.datastructures.linear.SinglyCLL;
import lib.datastructures.nodes.NodeS;


public class AppCLTest {
    public static void main (String [] args) {
        SinglyCLL test = new SinglyCLL(new NodeS(2));
        // test.insertTail(new NodeS(2));
        test.insertTail(new NodeS(4));
        test.insertTail(new NodeS(5));
        test.insertTail(new NodeS(23));
        test.insertTail(new NodeS(8));
        test.insertTail(new NodeS(11));
        test.insertTail(new NodeS(13));
        test.insertTail(new NodeS(17));
        test.insertTail(new NodeS(19));
        test.insert(new NodeS(24), 9);
        // test.sortedInsert(new NodeS(21));
        // test.insert(new NodeS(24), 9);
        
        // // test.sort();
        // // test.sortedInsert(new NodeS(1));
        System.out.println("The linked list is as follows: ");
        test.print();
        // System.out.println(test.tail.getNext().toString());
       
        // insertion with index. works
        // test.insert(new NodeS(9), 6);
        // System.out.println("\nThe linked list with indexed insertion is as follows: ");
        // test.print();
        
        // sorted insertion. works (need to repair sort function)
        // test.sortedInsert(new Node(12, null));
        // System.out.println("\nThe linked list with sorted insertion is as follows: ");
        // test.print();
    
        // search function. (works).
        // System.out.println("\nSearching for node with value 11: ");
        // System.out.println(test.search(new NodeS(12)).toString());
    
        // deleting head. works.
        // System.out.println ("deleting head and tail");
        // test.deleteHead();
       
        // deleting tail. works.
        // test.deleteTail();
        // test.print();
    
        // delete node function. (works)
        // System.out.println("\ndeleting node with value 11: ");
        // test.delete(new NodeS(24));
        // test.print();
        // System.out.println(test.tail.getNext().toString());
    
        // clear list function. (works)
        // System.out.println("\nclearing list: ");
        // test.clear();
        // test.print();
    
    
        }
    
}
