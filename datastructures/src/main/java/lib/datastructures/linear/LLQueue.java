package lib.datastructures.linear;

import lib.datastructures.nodes.NodeS;

public class LLQueue extends SinglyLL{

// Constructors
public LLQueue(){
    super();
}

public LLQueue(NodeS head){
    super(head);
}

@Override
public void insertHead(NodeS node) {}

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

public void enqueue(NodeS node){
    insertTail(node);
}

public NodeS dequeue(){
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
    return node;
}

public void empty(){
    clear();
}

public void elements(){
    print();
}
    
}
