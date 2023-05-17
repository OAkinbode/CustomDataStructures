package lib.datastructures.linear;
import lib.datastructures.nodes.NodeS;

public class SinglyLL {

    // I removed the private node class into a file of its own 
    // and included constructors; getters and setters; and toSting override.
    protected NodeS head;
    public NodeS tail;
    protected int size;
    protected boolean sorted = false;
    protected NodeS sorts;

    // Constructors
    public SinglyLL(){
        this.head = null;
    }

    public SinglyLL(NodeS head){
        this.head = head;
    }
    
    // insertHead recieves an object of type Node.
    // Complexity is O(1)
    public void insertHead(NodeS node) {
        if (head == null) {
			head = node;
            tail = node;
		}
		else {
			node.setNext(head);
			head = node;
		}
        size++;
        sorted = false;
    }
    // insert tail is specified to be passing a node into the function.
    // Complexity is O(1)
    public void insertTail(NodeS node) {
        if (head == null) {
			head = node;
            tail = node;
		}
		else {	
			getLastNode().setNext(node);
            tail = node;
		}
        size++;
        sorted = false;
    }
    
    // insert is specified to be passed by node.
    // Complexity is O(n)
    public void insert(NodeS node, int index) {
        NodeS current = head;
        if (index < size){
            if(index == 0)
                insertHead(node);
        for (int i = 1; i < index ; i++) {
            current = current.getNext();
        }
        node.setNext(current.next);
        current.setNext(node);
        if (current ==  tail)
            tail = node;
        size++;
        }
        else{
            System.out.println("insertion index out of range");
        }
        sorted = false;
    }

    protected boolean isEmpty() {
        return head == null;
    }

    // This sorted insert all values including duplicates.
    // Complexity is O(n)
    public void sortedInsert(NodeS node) {
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
            NodeS cursor = head;
		    while (cursor != null) {
		
			    if (node.getValue() > cursor.getValue() && node.getValue() <= cursor.getNext().getValue()){
				    node.setNext(cursor.getNext());
                    cursor.setNext(node);
                    break;
			    }
			    cursor = cursor.getNext();
		    }
	    }
        sorted = true;
        size++;
    }
    
    // Complexity is O(n)
    public NodeS search(NodeS node){
        NodeS cursor = head;
		NodeS result = null;
		while (cursor != null) {
			if (node.getValue()== cursor.getValue()){
			result = cursor;
			}
			cursor = cursor.getNext();
		}
		return result;
    }
    
    // Complexity is O(1)
    public void deleteHead() {
        if (isEmpty())
            throw new IllegalArgumentException("The list is empty");
        if (head == tail)
            head = tail = null;
        else {
            NodeS second = head.next;
            head.next = null;
            head = second;
        }
        size--;
    }

    // Complexity is O(n)
    public void deleteTail() {
        if (isEmpty())
            throw new IllegalArgumentException("The list is empty!");
        if (head == tail)
            head = tail = null;
        else {
            NodeS previous = getPrevious(tail);
            tail = previous;
            tail.next = null;
        }
        size--;
    }

    private NodeS getPrevious(NodeS node) {
        NodeS cursor = head;
        while (cursor != null) {
            if (cursor.next == node)
                return cursor;
            cursor = cursor.next;
        }
        return null;
    }

    // Complexity is O(n)
    public void delete(NodeS node) {
        NodeS cursor = head;
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
				cursor.setNext(cursor.getNext().getNext());
			}
			else if (cursor.getNext().getValue() == node.getValue() && 
            cursor.getNext().getNext() == null){
				deleteTail();
				continue;
			}
			cursor = cursor.getNext();
			}
            size--;
        }
    }

    // Complexity is O(n2)
    public void sort()   { 
        // initially, no nodes in sorted list so its set to null 
        sorts = null; 
        NodeS current = head; 
        // traverse the linked list and add sorted node to sorted list
        while (current != null)  { 
            // Store current.next in next
            NodeS next = current.getNext(); 
            // current node goes in sorted list 
            Insert_sorted(current); 
            // now next becomes current 
            current = next; 
        } 
        // update head to point to linked list 
        head = sorts; 
        sorted = true;
    } 
 
     //insert a new node in sorted list
    private void Insert_sorted(NodeS newNode)   { 
        //for head node
        if (sorts == null || sorts.getValue() >= newNode.getValue())    { 
            newNode.setNext(sorts); 
            sorts = newNode; 
        } 
        else  { 
            NodeS current = sorts; 
            //find the node and then insert
            while (current.next != null && current.getNext().getValue() < newNode.getValue())   { 
                current = current.getNext(); 
            } 
            newNode.setNext(current.next); 
            current.setNext(newNode); 
        } 
    } 

    // Complexity is O(n)
    public void clear() {
        for (int i = 0; i < size - 1; i++){
            deleteTail();
        }
        head = null;
        tail = null;
    }

    // Complexity is O(n)
    public int count(){
        size = 0;
        NodeS cursor = head;
        while (cursor != null){
            size++;
            cursor = cursor.getNext();
        }
        return size;
    }

    // Complexity is O(n)
    protected NodeS getLastNode() {
		NodeS cursor = head;
		while (cursor.getNext() != null) {
			cursor = cursor.getNext();
		}
		return cursor;
	}

    // Complexity is O(1)
	public NodeS getHead() {
		return head;
	}

    // Complexity is O(1)
    public boolean isSorted(){
        return sorted;
    }

    // Complexity is O(n)
    public void print(){
        if (head != null){
        NodeS cursor = head;
        System.out.println("List Length is: " + count() + "\n" + "Sorted Status is: " + sorted);
		while (cursor != null) {
			System.out.println(cursor);
			cursor = cursor.getNext();
        }
        }
        else{
            System.out.println("List is empty");
        }
}
}
