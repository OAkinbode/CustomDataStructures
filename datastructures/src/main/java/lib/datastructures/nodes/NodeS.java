package lib.datastructures.nodes;

public class NodeS {
    protected int value;
    public NodeS next;

    public NodeS(int value) {
        this.value = value;
        this.next = null;
    }

    public NodeS(){
        this.value = 0;
        this.next = null;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int num){
        this.value = num;
    }

    public NodeS getNext(){
        return next;
    }

    public void setNext(NodeS node){
        this.next = node;
    }

    @Override
	public String toString () {
		return "Node with value: " + value;
	}
}
