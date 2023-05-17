package lib.datastructures.trees;

import java.util.LinkedList;

import lib.datastructures.nodes.TNode;

public class AVL extends BST{
    //private TNode root;
    
  
    public LinkedList<TNode> list = new LinkedList<TNode>();
    public LinkedList<TNode> list2 = new LinkedList<TNode>();

    
    public AVL(TNode root) {
        super(root);
        //this.root = root;
    }

    public AVL() {
        //his.root = null;
        super();
    }

    public AVL(int value) {
        super(value);
        //this.root = new TNode(value);
    }
    
    public TNode getRoot() {
        return root;
    }

    /**
     * per specificaations, this sets the root of the AVL tree. 
     * if a root already exists, the value is inserted into the tree along with it's children (if they exist)
     */
    @Override
    public void setRoot(TNode node) {
        if (root == null)
            root = node;
        else {
            if (hasChild(node))
                insertToTree(node);
        }
    }

    /**
     * complexity of O(n)
     */
    public void insert(int val) {
        TNode node = new TNode(val);
        insert(node);
    }
    
    public void insert(TNode node) {
        if (hasChild(node)) {
            insertToTree(node);
        }
        else
            root = insert(root, node.getData());
    }

    private void insertToTree(TNode node) {
        traversePreOrder(node);
        for (int i = 0; i < list.size(); i++) {
            root = insert(root, list.get(i).getData());
        }
    }

    private boolean hasChild(TNode node) {
        return node.getLeft() != null || node.getRight() != null;
    }
    
    private TNode insert(TNode root, int val) {
        if (root == null)
            return new TNode(val);
        if (val < root.getData())
            root.setLeft(insert(root.getLeft(), val));
        else
            root.setRight(insert(root.getRight(), val));
        setHeight(root);
        return balance(root);
    }

    private TNode balance(TNode root) {
        if (isLeftHeavy(root)) {

            if (balanceFactor(root.getLeft()) < 0)
                root.setLeft(rotateLeft(root.getLeft()));
            return rotateRight(root);
        }
        else if (isRightHeavy(root)) {
            if (balanceFactor(root.getRight()) > 0)
                root.setRight(rotateRight(root.getRight()));
            return rotateLeft(root);
        }
        return root;
    }

    private boolean isRightHeavy(TNode root) {
        return balanceFactor(root) < -1 ;
    }
    
    private boolean isLeftHeavy(TNode root) {
        return balanceFactor(root) > 1;
    }

    private TNode rotateRight(TNode root) {
        TNode newRoot = root.getLeft();

        root.setLeft(newRoot.getRight());
        newRoot.setRight(root);

        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private TNode rotateLeft(TNode left) {
        TNode newRoot = root.getRight();
        root.setRight(newRoot.getLeft());
        newRoot.setLeft(root);

        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private int balanceFactor(TNode node) {
        return (node == null) ? 0: nheight(node.getLeft()) - nheight(node.getRight());
    }


    private void setHeight(TNode root) {
        root.setHeight(Math.max(nheight(root.getLeft()), nheight(root.getRight())) +1);
    }

    private int nheight(TNode node) {
        return (node == null) ? -1 : node.getHeight();
    }

    public void traversePreOrder(TNode node) {
        if (node == null)
            return;
        list.add(node);
        traversePreOrder(node.getLeft());
        traversePreOrder(node.getRight());
    }
    
    public void print() {
        //System.out.println(super.root);
    }

    // // @Override
    // public void printInOrder() {
    //     // System.out.println("test2");
    //     // System.out.println(root);
    //     printInOrder(root);
    // }

    // // @Override
    // protected void printInOrder(TNode root) {
    //     if (root == null)
    //         return;
    //     printInOrder(root.getLeft());
    //     System.out.println(root.toString());
    //     //list.add(student.toString());
    //     printInOrder(root.getRight());

    // }
}
