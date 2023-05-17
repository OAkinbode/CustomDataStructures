package lib.datastructures.nodes;

public class NodeD extends NodeS {
    public NodeS previous;

 

    public NodeD() {
        super();
        this.previous = null;
    }
    
    public NodeD(int value) {
        super(value);
        this.previous = null;
    }

       
    public NodeS getPrevious() {
        return previous;
    }

    
    public void setPrevious(NodeS previous) {
        this.previous = previous;
    }
    
    @Override
    public String toString() {
        return "Node with value: " + value;
        // return "NodeD [previous=" + previous + "]";
    }
    
}
