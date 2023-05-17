package lib.datastructures;

import lib.datastructures.nodes.TNode;
import lib.datastructures.trees.BST;

public class AppBSTTester {
    public static void main(String[] args) throws IllegalAccessException {

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







    }

    
}
