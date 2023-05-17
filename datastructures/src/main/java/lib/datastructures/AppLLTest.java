package lib.datastructures;

import lib.datastructures.linear.SinglyLL;
import lib.datastructures.nodes.NodeS;

public class AppLLTest {
    
    public static void main (String [] args) {
        SinglyLL test = new SinglyLL(new NodeS(2));
        test.insertTail(new NodeS(4));
        test.insertTail(new NodeS(5));
        test.insertTail(new NodeS(11));
        test.insertTail(new NodeS(8));
        test.insertTail(new NodeS(6));
        test.insertTail(new NodeS(13));
        test.insertTail(new NodeS(17));
        test.insertTail(new NodeS(19));
    
        System.out.println("The linked list is as follows: ");
        test.print();

        // sort function
        test.sort();
        test.print();

        // insertion with index. works
        // test.insert(new NodeS(9), 6);
        // System.out.println("\nThe linked list with indexed insertion is as follows: ");
        // test.print();
        
        // sorted insertion. works (need to repair sort function)
        // test.sortedInsert(new NodeS(12));
        // System.out.println("\nThe linked list with sorted insertion is as follows: ");
        // test.print();
    
        // search function. (works).
        // System.out.println("\nSearching for node with value 11: ");
        // System.out.println(test.search(new NodeS(11)).toString());
    
        // deleting head. works.
        // test.deleteHead();
       
        // deleting tail. works.
        // test.deleteTail();
        // test.print();
    
        // delete node function. (works)
        // System.out.println("\ndeleting node with value 11: ");
        // test.delete(new NodeS(11));
        // test.print();
    
        // clear list function. (works)
        // System.out.println("\nclearing list: ");
        // test.clear();
        // test.print();
    
    
        }

}
