package lib.datastructures.linear;

import lib.datastructures.nodes.NodeD;

public class DoublyLL implements DoubleLLMethods {

    protected NodeD last = null;
    
    public NodeD head;
    public NodeD tail;
    protected int size;
    protected boolean sorted = false;
    protected NodeD sorts;
    
     // Constructors
    public DoublyLL(){
        this.head = null;
        this.tail = null;
    }

    public DoublyLL(NodeD head){
        this.head = head;
        this.tail = head;
        size++;
    }

    @Override
    public void insertHead(NodeD node) {
        if (isEmpty())
            head = tail = node;
        else {
            head.setPrevious(node);
            node.setNext(head);
            head = node;
        }
        size++;
        sorted = false;
    }

    private boolean isEmpty() {
        return head == null;
    }

    @Override
    public void insertTail(NodeD node) {
        if (isEmpty())
            head = tail = node;
        else {
            node.setPrevious(tail);
            tail.setNext(node);
            tail = node;
        }
        size++;
        sorted = false;
    }

    @Override
    public void insert(NodeD node, int index) {
        count();
        if (index == 0) {
            insertHead(node);
            return;
        }
        else if (index == size) {
            insertTail(node);
            return;
        }
        
        else {
            NodeD current = head;
            NodeD temp = null;
            for (int i = 1; i < index; i++) {
                current = (NodeD) current.getNext();
            }
            temp = (NodeD) current.getNext();
            current.setNext(node);
            node.setPrevious(current);
            temp.setPrevious(node);
            node.setNext(temp);
        }
        size++;
        sorted = false;
    }

    @Override
    public void sortedInsert(NodeD node) {
            // checking to see if the list is sorted.
            if (isSorted() == false)
                sort();
    
            // check if the value is out of range and insert appropriately
            if (node.getValue() > tail.getValue() || node.getValue() < head.getValue()){
                if (tail.getValue() < node.getValue())
                    insertTail(node);
                if (head.getValue() > node.getValue())
                    insertHead(node);
            }
            // The value is within range and can be inserted within.
            else {
                NodeD cursor = head;
                while (cursor != null) {
                    if (node.getValue() > cursor.getValue() && node.getValue() <= cursor.getNext().getValue()){
                        node.setNext(cursor.getNext());
                        ((NodeD) cursor.getNext()).setPrevious(node);
                        cursor.setNext(node);
                        node.setPrevious(cursor);
                        break;
                    }
                    cursor = (NodeD) cursor.getNext();
                }
            }
            size++;
            sorted = true;
        }
     
    @Override
    public void deleteHead() {
        if (isEmpty())
            throw new IllegalArgumentException("The list is empty");
        else if (head == tail)
            head = tail = null;
        else {
            NodeD second = (NodeD) head.getNext();
            // head.next = null;
            head = second;
            second.setPrevious(null);
        }
        size--;
    }

    @Override
    public void deleteTail() {
        if (isEmpty())
            throw new IllegalArgumentException("The list is empty!");
        else if (head == tail)
            head = tail = null;
        else {
            NodeD previous = (NodeD) tail.getPrevious();
            tail.previous = null;
            tail = previous;
            tail.next = null;
    }
    size--;
        
    }

    @Override
    public void delete(NodeD node) {
        NodeD cursor = head;
        
        if (size == 1){
            head = null;
            tail = null;
            size--;
        }
        else {
            
		    while (cursor.getNext() != null) {
			    if (cursor.getValue() == node.getValue() && cursor == head){
				    deleteHead();
			    }
			    else if (cursor.getNext().getValue() == node.getValue() 
                && cursor.getNext().getNext() != null){
                    ((NodeD) cursor.getNext().getNext()).setPrevious(cursor);
				    cursor.setNext(cursor.getNext().getNext());
			    }
			    else if (cursor.getNext().getValue() == node.getValue() && 
                cursor.getNext().getNext() == null){
				    deleteTail();
				    continue;
			    }
			    cursor = (NodeD) cursor.getNext();
			    }
                size--;
            }
        
    }

    @Override
    public void sort() {
         // initially, no nodes in sorted list so its set to null 
         sorts = null; 
         NodeD current = head; 
         // traverse the linked list and add sorted node to sorted list
         while (current != null)  { 
             // Store current.next in next
             NodeD next = (NodeD) current.getNext(); 
             // current node goes in sorted list 
             Insert_sorted(current); 
             // now next becomes current 
             current = next; 
         } 
         // update head to point to linked list 
         head = sorts; 
         head.setPrevious(null);
         tail = last;
         sorted = true;
    }

     //insert a new node in sorted list
     private void Insert_sorted(NodeD newNode)   { 
 
        if (sorts == null){
            newNode.setNext(sorts);
            sorts = newNode;
            last = sorts;
        }
        else if (sorts.getValue() >= newNode.getValue()){
            newNode.setNext(sorts); 
            last = sorts;
            sorts.setPrevious(newNode);
            sorts = newNode;
        }
        else  { 
            NodeD current = sorts; 
            //find the node and then insert
            while (current.getNext() != null && current.getNext().getValue() < newNode.getValue())   { 
                current = (NodeD) current.getNext(); 
            } 
            newNode.setNext(current.next);
            if (current.getNext() == null){
                // ((NodeD) current.getNext()).setPrevious(newNode);
                last = newNode;
            }
            if (current.getNext() != null)
                ((NodeD) current.getNext()).setPrevious(newNode);
            newNode.setPrevious(current); 
            current.setNext(newNode); 
        } 
    } 

    @Override
    public void clear() {
        for (int i = 0; i < size - 1; i++){
            deleteTail();
        }
        head = null;
        tail = null;
    }

    public int count(){
        size = 0;
        NodeD cursor = head;
        while (cursor != null){
            size++;
            cursor = (NodeD) cursor.getNext();
        }
        return size;
    }

    public boolean isSorted(){
        return sorted;
    }


    @Override
    public NodeD search(NodeD node) {
        NodeD cursor = head;
		NodeD result = null;
		while (cursor != null) {
			if (node.getValue()== cursor.getValue()){
			result = cursor;
			}
			cursor = (NodeD) cursor.getNext();
		}
		return result;
    }

    protected NodeD previous(NodeD node){
        return (NodeD) node.getPrevious();
    }
    

    @Override
    public void print() {
        
        if (head != null){
            NodeD cursor = head;
            System.out.println("List Length is: " + count() + "\n" + "Sorted Status is: " + sorted);
            while (cursor != null) {
                // System.out.println("Previous nodes: " + cursor.previous);
                System.out.println(cursor);
                cursor = (NodeD) cursor.getNext();
            }
            }
            else{
                System.out.println("List is empty");
            }
    }
    
}
   
    
