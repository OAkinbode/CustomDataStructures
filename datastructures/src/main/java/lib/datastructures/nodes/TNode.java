package lib.datastructures.nodes;

public class TNode {
    int data, balance, height;
    
    TNode left, right, parent;
    
    public TNode() {
    }
    
    public TNode(int data) {
        this.data = data;
    }
    
    public int getData() {
        return data;
    }
    
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public void setData(int data) {
        this.data = data;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public TNode getLeft() {
        return left;
    }

    public void setLeft(TNode left) {
        this.left = left;
    }

    public TNode getRight() {
        return right;
    }

    public void setRight(TNode right) {
        this.right = right;
    }

    public TNode getParent() {
        return parent;
    }

    public void setParent(TNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "TNode [data=" + data + "]";
    }

    public void print() {
        System.out.println("Node: " + this.data + "\nParent: " 
        + "\nLeftChild: " + this.getLeft().data + "\nRightChild: " + this.getRight().data);
    }
}