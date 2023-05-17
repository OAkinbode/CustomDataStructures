package lib.datastructures;

import lib.datastructures.heap.MaxH;
import lib.datastructures.heap.MinH;
import lib.datastructures.linear.DoublyCLL;
import lib.datastructures.linear.DoublyLL;
import lib.datastructures.linear.LLQueue;
import lib.datastructures.linear.LLStack;
import lib.datastructures.linear.SinglyCLL;
import lib.datastructures.linear.SinglyLL;
import lib.datastructures.nodes.NodeD;
import lib.datastructures.nodes.NodeS;
import lib.datastructures.nodes.TNode;
import lib.datastructures.trees.AVL;
//import lib.datastructures.nodes.NodeS;
import lib.datastructures.trees.BST;

public class App {
    public static void main (String [] args) {
        SinglyLL test1 = new SinglyLL(new NodeS(2));
        test1.insertTail(new NodeS(4));
        test1.insertTail(new NodeS(5));
        test1.insertTail(new NodeS(11));
        test1.insertTail(new NodeS(8));
        test1.insertTail(new NodeS(6));
        test1.insertTail(new NodeS(13));
        test1.insertTail(new NodeS(17));
        test1.insertTail(new NodeS(19));
    
        System.out.println("The linked list is as follows: ");
        test1.print();

        // sort function
        test1.sort();
        test1.print();

        // insertion with index. works
        test1.insert(new NodeS(9), 6);
        System.out.println("\nThe linked list with indexed insertion is as follows: ");
        test1.print();
        
        // sorted insertion. works (need to repair sort function)
        test1.sortedInsert(new NodeS(12));
        System.out.println("\nThe linked list with sorted insertion is as follows: ");
        test1.print();
    
        // search function. (works).
        System.out.println("\nSearching for node with value 11: ");
        System.out.println(test1.search(new NodeS(11)).toString());
    
        // deleting head. works.
        test1.deleteHead();
       
        // deleting tail. works.
        test1.deleteTail();
        test1.print();
    
        // delete node function. (works)
        System.out.println("\ndeleting node with value 11: ");
        test1.delete(new NodeS(11));
        test1.print();
    
        // clear list function. (works)
        System.out.println("\nclearing list: ");
        test1.clear();
        test1.print();
    
        DoublyLL test2 = new DoublyLL(new NodeD(2));
        // test.insertTail(new NodeD(2));
        test2.insertTail(new NodeD(4));
        test2.insertTail(new NodeD(5));
        test2.insertTail(new NodeD(6));
        test2.insertTail(new NodeD(8));
        test2.insertTail(new NodeD(19));
        test2.insertTail(new NodeD(13));
        test2.insertTail(new NodeD(17));
        test2.insertTail(new NodeD(19));
        test2.insert(new NodeD(24), 0);

        test2.print();
        
        test2.sort();
        test2.sortedInsert(new NodeD(25));
    
        test2.sortedInsert(new NodeD(12));
    
        System.out.println("The linked list is as follows: ");
        test2.print();

        

        // insertion with index. works
        test2.insert(new NodeD(9), 10);
        System.out.println("\nThe linked list with indexed insertion is as follows: ");
        test2.print();

        
        
        // sorted insertion. works (need to repair sort function)
        test2.sortedInsert(new NodeD(12));
        System.out.println("\nThe linked list with sorted insertion is as follows: ");
        test2.print();
    
        // search function. (works).
        System.out.println("\nSearching for node with value 19: ");
        System.out.println(test2.search(new NodeD(19)).toString());
    
        // deleting head. works.
        test2.deleteHead();
       
        // deleting tail. works.
        System.out.println("tests started: ");
        test2.sort();
        test2.deleteTail();
        test2.print();
    
        // delete node function. (works)
        System.out.println("\ndeleting node with value 11: ");
        test2.sort();
        test2.delete(new NodeD(8));
        test2.print();
    
        // clear list function. (works)
        System.out.println("\nclearing list: ");
        test2.clear();
        test2.print();
    
        SinglyCLL test3 = new SinglyCLL(new NodeS(2));
        // test.insertTail(new NodeS(2));
        test3.insertTail(new NodeS(4));
        test3.insertTail(new NodeS(5));
        test3.insertTail(new NodeS(23));
        test3.insertTail(new NodeS(8));
        test3.insertTail(new NodeS(11));
        test3.insertTail(new NodeS(13));
        test3.insertTail(new NodeS(17));
        test3.insertTail(new NodeS(19));
        test3.insert(new NodeS(24), 9);
        // test.sortedInsert(new NodeS(21));
        // test.insert(new NodeS(24), 9);
        
        // // test.sort();
        // // test.sortedInsert(new NodeS(1));
        System.out.println("The linked list is as follows: ");
        test3.print();
        System.out.println(test3.tail.getNext().toString());
       
        // insertion with index. works
        test3.insert(new NodeS(9), 6);
        System.out.println("\nThe linked list with indexed insertion is as follows: ");
        test3.print();
        
        // sorted insertion. works (need to repair sort function)
        test3.sortedInsert(new NodeS(12));
        System.out.println("\nThe linked list with sorted insertion is as follows: ");
        test3.print();
    
        // search function. (works).
        System.out.println("\nSearching for node with value 11: ");
        System.out.println(test3.search(new NodeS(12)).toString());
    
        // deleting head. works.
        System.out.println ("deleting head and tail");
        test3.deleteHead();
       
        // deleting tail. works.
        test3.deleteTail();
        test3.print();
    
        // delete node function. (works)
        System.out.println("\ndeleting node with value 11: ");
        test3.delete(new NodeS(24));
        test3.print();
        System.out.println(test3.tail.getNext().toString());
    
        // clear list function. (works)
        System.out.println("\nclearing list: ");
        test3.clear();
        test3.print();
    
        DoublyCLL test4 = new DoublyCLL(new NodeD(2));
        // test.insertTail(new NodeD(2));
        test4.insertTail(new NodeD(4));
        test4.insertTail(new NodeD(5));
        test4.insertTail(new NodeD(6));
        test4.insertTail(new NodeD(8));
        test4.insertTail(new NodeD(19));
        test4.insertTail(new NodeD(13));
        test4.insertTail(new NodeD(17));
        test4.insertTail(new NodeD(19));
        test4.insert(new NodeD(24), 0);

        test4.print();
        
        test4.sort();
        test4.sortedInsert(new NodeD(25));
    
        test4.sortedInsert(new NodeD(12));
    
        System.out.println("The linked list is as follows: ");
        test4.print();

        

        // insertion with index. works
        test4.insert(new NodeD(9), 10);
        System.out.println("\nThe linked list with indexed insertion is as follows: ");
        test4.print();

        
        
        // sorted insertion. works (need to repair sort function)
        test4.sortedInsert(new NodeD(12));
        System.out.println("\nThe linked list with sorted insertion is as follows: ");
        test4.print();
    
        // search function. (works).
        System.out.println("\nSearching for node with value 13: ");
        System.out.println(test4.search(new NodeD(13)).toString());
    
        // deleting head. works.
        test4.deleteHead();
       
        // deleting tail. works.
        System.out.println("tests started: ");
        test4.sort();
        test4.deleteTail();
        test4.print();
    
        // delete node function. (works)
        System.out.println("\ndeleting node with value 11: ");
        test4.delete(new NodeD(8));
        test4.print();
    
        // clear list function. (works)
        System.out.println("\nclearing list: ");
        test4.clear();
        test4.print();

        LLStack test5 = new LLStack();
        test5.push(new NodeS(2));
        test5.push(new NodeS(7));
        test5.push(new NodeS(4));
        test5.push(new NodeS(6));
        test5.push(new NodeS(3));
        
        test5.elements();

        test5.pop();
        test5.pop();

        test5.elements();
        System.out.println("Peek");
        test5.peek();


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

           // tester for the BST class
        // all works perfectly

        BST bst = new BST();
        BST bst1 = new BST(10);
        BST bst2 = new BST(new TNode(12));
       
        //manually creating a subtree node1
        TNode node1 = new TNode(15);
        node1.setLeft(new TNode(7));
        node1.setRight(new TNode(17));
        node1.getLeft().setRight(new TNode(9));

        bst1.insert(12);
        bst1.insert(19);
        bst1.insert(4);
        bst1.insert(11);
        bst1.insert(3);
        bst1.insert(6);
        bst1.insert(8);
        bst1.insert(1);
        bst1.delete(4);

        bst1.insert(node1);

        bst1.printInOrder();

        //bst1.setRoot(new TNode(30));

        bst1.printBF(); // works

        AVL avl = new AVL();

        AVL avl1 = new AVL(10);

        AVL avl2 = new AVL(new TNode(10));

        avl1.insert(12);
        avl1.insert(19);
        avl1.insert(4);
        avl1.insert(11);
        avl1.insert(3);
        avl1.insert(6);
        avl1.insert(8);
        avl1.insert(1);

        avl1.printInOrder();
        avl1.printBF();
        //avl.print();

        int[] array = { 4, 18, 22, 10, 7, 9, 2, 6 };
        MaxH maxh = new MaxH(array);

        maxh.heapSort();

        maxh.delete(22);

        //maxh.insert(12);


        maxh.print();

        //System.out.println(maxh.contains(18));

        int[] array1 = { 4, 18, 22, 10, 7, 9, 2, 6 };
        MinH minh= new MinH(array1);

        minh.heapSort();

        minh.delete(22);

        minh.insert(12);
        minh.insert(2);
        minh.insert(18);
        minh.insert(4);
        minh.insert(7);
        minh.insert(1);
        minh.insert(8);
        minh.insert(5);

        minh.print();
        

    
    }
}
