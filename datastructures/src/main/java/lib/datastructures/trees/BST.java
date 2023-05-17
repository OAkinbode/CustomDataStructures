package lib.datastructures.trees;
import java.util.ArrayList;
import java.util.LinkedList;
import lib.datastructures.nodes.TNode;

public class BST {
    protected TNode root;
    //public LinkedList<TNode> list = new LinkedList<TNode>(); // used in the insertToTree helper method
    public LinkedList<TNode> list2 = new LinkedList<TNode>();// used in the inSertToTree helper method

    public BST() {
        this.root = null;
    }

    public BST(int value) {
        this.root = new TNode(value);
    }

    public BST(TNode root) {
        this.root = root;
    }

    public TNode getRoot() {
        return root;
    }

    /**
     * This sets the root of the BST
     * 
     * checks if the root is null and sets the root. 
     * if a root already exists, it throws an exception asking to use the insert method instead
     * @param root
     * @throws IllegalAccessException
     */
    public void setRoot(TNode node) throws IllegalAccessException { 
        if (root == null)
            this.root = node;
        else {
            throw new IllegalAccessException("Root already exists. Use the insert method instead");
        }   
    }
    
    public void insert(int val) {
        TNode node = new TNode(val);
        insert(node);
    }

    private boolean hasChild(TNode node) {
        return node.getLeft() != null || node.getRight() != null;
    }

    private void insertToTree(TNode node) {
        traversePreOrder(node);
        for (int i = 0; i < list2.size(); i++) {
            insert(list2.get(i).getData());
        }
    }

    public void traversePreOrder(TNode node) {
        if(node == null)
            return;
        list2.add(node);
        traversePreOrder(node.getLeft());
        traversePreOrder(node.getRight());
    }

    public void insert(TNode node) {
        if (hasChild(node)) {
            insertToTree(node);
            return;
        }
        else {
            
            if (root == null) {
                root = node;
                return;
            }
    
            TNode current = root;
            while (true) {
                if (node.getData() < current.getData()) {
                    if (current.getLeft() == null) {
                        current.setLeft(node);
                        break;
                    }
                    current = current.getLeft();
                } else {
                    if (current.getRight() == null) {
                        current.setRight(node);
                        break;
                    }
                    current = current.getRight();
                }
            }
        }
        
    }

    public void delete(int val) {
        root = delete(root, val);
    }

    private TNode delete(TNode root, int val) {
        if (root == null)
            return root;
        if (val < root.getData())
            root.setLeft(delete(root.getLeft(), val));
        else if (val > root.getData())
            root.setRight(delete(root.getRight(), val));
        else {
            if (root.getLeft() == null)
                return root.getRight();
            else if (root.getRight() == null)
                return root.getRight();

            root.setData(minValue(root.getRight()));
            root.setRight(delete(root.getRight(), root.getData()));
        }
        
        return root; 
    }

    private int minValue(TNode root) {
        int minVal = root.getData();
        while (root.getLeft() != null) {
            minVal = root.getLeft().getData();
            root = root.getLeft();
        }
        return minVal;
    }
    
    /**
     * Searches for the value and returns the Node object.
     * Runtime complexity = O(Log N)
     * 
     * @param val value of int to search for.
     * @return node object found or returns Null if not found
     */
    public TNode Search(int val) {
        TNode current = root;

        while (current != null) {
            if (val < current.getData())
                current = current.getLeft();
            else if (val > current.getData())
                current = current.getRight();
            else
                return current;
        }

        return null;

    }

    public void printInOrder() {
        printInOrder(root);
    }

    protected void printInOrder(TNode root) {
        if (root == null)
            return;
        printInOrder(root.getLeft());
        System.out.println(root.toString());
        printInOrder(root.getRight());

    }

    public void printBF() {
        for (int i = 0; i <= height(); i++) {
            System.out.println(getNodesAtDistance(i));
        }
    }
    
    protected int height() {
        return height(root);
    }
    protected int height(TNode root) {
        if (root == null)
            return -1;
        if (isLeaf(root))
            return 0;
        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));

    }

    protected boolean isLeaf(TNode node) {
        return node.getLeft() == null && node.getRight() == null;
    }

    protected ArrayList<TNode> getNodesAtDistance(int distance) {
        ArrayList<TNode> list = new ArrayList<TNode>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    protected void getNodesAtDistance(TNode node, int distance, ArrayList<TNode> list) {
        if (node == null)
            return;
        if (distance == 0) {
            list.add(node);
            return;
        }
        getNodesAtDistance(node.getLeft(), distance - 1, list);
        getNodesAtDistance(node.getRight(), distance - 1, list);

    }

    public void print() {
        System.out.println(root.toString());
    }

}
