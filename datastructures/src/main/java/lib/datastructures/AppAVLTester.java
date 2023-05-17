package lib.datastructures;

import lib.datastructures.nodes.TNode;
import lib.datastructures.trees.AVL;

public class AppAVLTester {
    public static void main(String[] args) {
            
        AVL avl = new AVL();

        AVL avl1 = new AVL(10);

        AVL avl2 = new AVL(new TNode(10));

        TNode node1 = new TNode(15);
        node1.setLeft(new TNode(8));
        node1.setRight(new TNode(17));
        node1.getLeft().setRight(new TNode(11));

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

        
    }
}
