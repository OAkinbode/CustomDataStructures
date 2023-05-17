package lib.datastructures.linear;

import lib.datastructures.nodes.NodeS;

public class LLStack extends SinglyLL{
    
    // Constructors
    public LLStack(){
        super();
    }

    public LLStack(NodeS head){
        super(head);
    }

    // Tail is overridden with an empty class.
    @Override
    public void insertTail(NodeS node) {}
    
    @Override
    public void insert(NodeS node, int index) {}

    @Override
    public void sortedInsert(NodeS node) {}

    @Override
    public void deleteTail() {}

    @Override
    public void delete(NodeS node) {}

    @Override
    public void sort() {} 

    @Override
    public void print(){
        if (head != null){
        NodeS cursor = head;
        System.out.println("Stack depth is: " + count() + " objects deep");
		while (cursor != null) {
			System.out.println(cursor);
			cursor = cursor.getNext();
        }
        }
        else{
            System.out.println("List is empty");
        }
    }

    public void push(NodeS node){
        insertHead(node);
    }

    public NodeS pop(){
        NodeS node = null;
        if (isEmpty())
            System.out.println("Array empty");
        else{
            node = getHead();
            deleteHead();
        }
        return node;
    }

    public NodeS peek(){
        NodeS node = null;
        if (isEmpty())
            System.out.println("Array empty");
        else{
            node = getHead(); 
        }
        System.out.println(node);
        return node;
    }

    public void empty(){
        clear();
    }

    public void elements(){
        print();
    }

} 
