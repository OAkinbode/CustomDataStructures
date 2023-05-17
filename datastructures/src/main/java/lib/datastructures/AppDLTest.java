package lib.datastructures;


import lib.datastructures.linear.DoublyLL;
import lib.datastructures.nodes.NodeD;

public class AppDLTest {
    
    public static void main (String [] args) {
        DoublyLL test = new DoublyLL(new NodeD(2));
        // test.insertTail(new NodeD(2));
        test.insertTail(new NodeD(4));
        test.insertTail(new NodeD(5));
        test.insertTail(new NodeD(6));
        test.insertTail(new NodeD(8));
        test.insertTail(new NodeD(19));
        test.insertTail(new NodeD(13));
        test.insertTail(new NodeD(17));
        test.insertTail(new NodeD(19));
        test.insert(new NodeD(24), 0);

        // test.print();
        
        // test.sort();
        // test.sortedInsert(new NodeD(25));
    
        // test.sortedInsert(new NodeD(12));
    
        System.out.println("The linked list is as follows: ");
        test.print();

        

        // insertion with index. works
        // test.insert(new NodeD(9), 10);
        // System.out.println("\nThe linked list with indexed insertion is as follows: ");
        // test.print();

        
        
        // sorted insertion. works (need to repair sort function)
        // test.sortedInsert(new NodeD(12));
        // System.out.println("\nThe linked list with sorted insertion is as follows: ");
        // test.print();
    
        // search function. (works).
        // System.out.println("\nSearching for node with value 19: ");
        // System.out.println(test.search(new NodeD(19)).toString());
    
        // deleting head. works.
        // test.deleteHead();
       
        // deleting tail. works.
        // System.out.println("tests started: ");
        // test.sort();
        // test.deleteTail();
        // test.print();
    
        // delete node function. (works)
        // System.out.println("\ndeleting node with value 11: ");
        // test.sort();
        // test.delete(new NodeD(8));
        // test.print();
    
        // clear list function. (works)
        // System.out.println("\nclearing list: ");
        // test.clear();
        // test.print();
    
    
        }


}
