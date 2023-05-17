package lib.datastructures.linear;
import lib.datastructures.nodes.NodeS;

public class SinglyCLL extends SinglyLL {    

    NodeS  last;

     // Constructors
     public SinglyCLL(){
        super();
    }

    public SinglyCLL(NodeS head){
        super(head);
        tail = head;
        head.setNext(head);
        size++;
    }

    @Override
    public void insertHead(NodeS node){
        if (head == null) {
            head = node;
            tail = node;   
        }
        else{
            node.setNext(head);
            head = node;
        }
        tail.setNext(head);
        size++;
        sorted = false;
    }

    // insert tail is specified to be passing a node into the function.
    @Override
    public void insertTail(NodeS node) {
        if (head == null) {
			head = node;
            tail = node;
		}
		else {	
			getLastNode().setNext(node);
            tail = node;  
		}
        tail.setNext(head);
        size++;
        sorted = false;
    }

    @Override
    public void insert(NodeS node, int index){
        NodeS current = head;
        count();

        if (head == null && index == 0)
            insertHead(node);
        else if (index <= size){
            if (index == 0)
                insertHead(node);
            else {
                for (int i = 1; i < index ; i++) {
                    current = current.getNext();
                }
                node.setNext(current.next);
                current.setNext(node);
                size++;
            if (index + 1 == size){
                tail = node;
                tail.setNext(head);
            } 
            }
        }
        else{
            System.out.println("insertion index out of range");
        }
        sorted = false;
    }

    @Override
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
            NodeS cursor = head.getNext();
            // initialize head operation.
            if (node.getValue() > head.getValue() && node.getValue() <= head.getNext().getValue()){
                node.setNext(head.getNext());
                head.setNext(node);
            }
            // iteration continues until the cursor hits head again.
            else {
		        while (cursor != head) {
			        if (node.getValue() > cursor.getValue() && node.getValue() <= cursor.getNext().getValue()){
				        node.setNext(cursor.getNext());
                        cursor.setNext(node);
                        break;
			        }
			    cursor = cursor.getNext();
		    }
            }
	    }
        size++;
        sorted = true;
        tail.setNext(head);
    }

    @Override
    public NodeS search(NodeS node){
        NodeS cursor = head.getNext();
		NodeS result = null;
        // head is handled separetely.
        if (node == head)
            result = head;
        else { // the rest of the list is checked till cursor hits head.
		    while (cursor != head) {
			    if (node.getValue()== cursor.getValue()){
			    result = cursor;
			    }
			cursor = cursor.getNext();
		}
        }
		return result;
    }

    @Override
    public void sort()   { 
        // initially, no nodes in sorted list so its set to null 
        sorts = null; 
        NodeS current = head.getNext();
        // initialize the new linked list
        Insert_sorted(head);
        // traverse the linked list and add sorted node to sorted list
        while (current != head)  { 
            // Store current.next in next
            NodeS next = current.getNext(); 
            // current node goes in sorted list 
            Insert_sorted(current); 
            // now next becomes current 
            current = next; 
        } 
        // update head to point to linked list 
        head = sorts;
        tail = last;
        last.setNext(head);
        sorted = true;
    } 

    private void Insert_sorted(NodeS newNode)   { 
        //for head node
        if (sorts == null || sorts.getValue() >= newNode.getValue())  { 
            newNode.setNext(sorts); 
            sorts = newNode; 
        } 
        else  { 
            NodeS current = sorts; 
            //find the node and then insert
            while (current.getNext() != null && current.getNext().getValue() < newNode.getValue())   { 
                current = current.getNext(); 
            } 
            newNode.setNext(current.next); 
            current.setNext(newNode); 
            if (newNode.getNext() == null)
                last = newNode;
        } 
    } 

    @Override
    protected NodeS getLastNode() {
		NodeS cursor = head;
		while (cursor.getNext() != head) {
			cursor = cursor.getNext();
		}
        // for (int i = 1; i <= size; i++)
        //     cursor = cursor.getNext();
		return cursor;
	}

    @Override
    public int count(){
        NodeS cursor = null; 
        size = 0;
        if (head != null){
            size = 1;
            cursor = head.getNext();
        }
        while (cursor != head && cursor !=  null){
            size++;
            cursor = cursor.getNext();
        }
        return size;
    }

    @Override
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

    @Override
    public void deleteTail() {
        if (isEmpty())
            throw new IllegalArgumentException("The list is empty!");
        if (head == tail)
            head = tail = null;
        else {
            NodeS previous = getPrevious(tail);
            tail = previous;
            tail.next = head;
        }
        size--;
    }

    private NodeS getPrevious(NodeS node) {
        NodeS cursor = head;
        int count = 0;
        while (count < size - 1) {
            count++;
            if (cursor.next == node)
                return cursor;
            cursor = cursor.next;
        }
        return null;
    }

    @Override
    public void delete(NodeS node) {
        NodeS cursor = head;
        if (size == 1){
            head = null;
            tail = null;
            size--;
        }
        else {
            int count = 0;
		while (count < size - 1) {
            count++;
			if (cursor.getValue() == node.getValue() && cursor == head){
				deleteHead();
			}
			else if (cursor.getNext().getValue() == node.getValue() 
            && cursor.getNext().getNext() != head){
				cursor.setNext(cursor.getNext().getNext());
			}
			else if (cursor.getNext().getValue() == node.getValue() && 
            cursor.getNext().getNext() == head){
				deleteTail();
				continue;
			}
			cursor = cursor.getNext();
			}
            size--;
        }
    }

    @Override
    public void print(){
        if (head != null){
        NodeS cursor = head.getNext();
        if (head != null){
            System.out.println("List Length is: " + count() + "\n" + "Sorted Status is: " + sorted);
            System.out.println(head);
            
        }
            cursor = head.getNext();
		    while (cursor != head && cursor.getNext() != null) {
			    System.out.println(cursor);
			    cursor = cursor.getNext();
        }
        }
        else{
            System.out.println("List is empty");
        }
}
    
}
