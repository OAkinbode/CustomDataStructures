package lib.datastructures.heap;

import java.util.Vector;

public class MaxH extends Heap {
    private Vector<Integer> elements ;
    
    public MaxH() {
        elements = new Vector<Integer>();
    }

    public MaxH(int size) {
        elements = new Vector<Integer>(size);
    }

    public MaxH(int[] array) {
        elements = new Vector<Integer>();
        for (int i = 0; i < array.length; i++) {
            //elements.addElement(array[i]);
            elements.add(array[i]);
            //insert(array[i]);
        }
    }
    
    public void insert(int val) {
        elements.add(val);
        bubbleUp();
    }

    public void clear() {
        elements.clear();
    }

    public int getSize() {
        return elements.size();
    }

    public void sort() {
        Vector<Integer> temp = (Vector<Integer>) elements.clone();
        elements.clear();
        for (int i = 0; i < temp.size(); i++) {
            insert(temp.get(i));
        }
    }

    public void heapSort() {
        int lastParentIndex = elements.size() / 2 - 1;
        for (int i = lastParentIndex; i >= 0; i--)
            heapSort(elements, i);
    }
    
    private void heapSort(Vector<Integer> elements, int index) {
        int largerIndex = index;

        int leftIndex = index * 2 + 1;
        if (leftIndex < elements.size() &&
            elements.get(leftIndex) > elements.get(largerIndex))
        largerIndex = leftIndex;

        int rightIndex = index * 2 + 2;
        if (rightIndex < elements.size() &&
        elements.get(rightIndex) > elements.get(largerIndex))
        largerIndex = rightIndex;

        if (index == largerIndex)
        return;

        swap(index, largerIndex);
        heapSort(elements, largerIndex);
    }

    public boolean contains(int value) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) == value )
                return true;
        }
        return false;
    }

    private void bubbleUp() {
        int index = elements.size() - 1;
        while (index > 0 && elements.get(index) > elements.get(parent(index))) {
            swap(index, parent(index));
            index = parent(index);
        }

    }
    

    private void swap(int first, int second) {
        int temp = elements.get(first);
        elements.set(first, elements.get(second));
        elements.set(second, temp);
    }

    private int parent(int index) {
        if (index == 0)
            return -1;
        return (index - 1) /2;
    }



    public void delete(int val) {
        if (!contains(val)) {
            System.out.println("value doesn't exist");
            return;
        }
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) == val)
                elements.remove(i);
        }
        sort();
        
    }

    private void bubbleDown() {
        System.out.println("bubbledown");
        int index = 0;
        System.out.println(elements.size());
        for (int i = 0; i < elements.size(); i++) {
            if (!isValidParent(i)) {
                int largerChildIndex = largerChildIndex(index);
                System.out.println("lgi: " + largerChildIndex);
                swap(index, largerChildIndex);
                index = largerChildIndex;
            }
        }

    }

    private int largerChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;

        if (!hasRightChild(index))
            return leftChildIndex(index);

        return (leftChild(index) > rightChild(index)) ? leftChildIndex(index) : rightChildIndex(index);

    }
    
        private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }
    

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;

        boolean isValid = elements.get(index) >= leftChild(index);

        if (hasRightChild(index))
            isValid &= elements.get(index) >= rightChild(index);

        return isValid;
    }
    
    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= elements.size();
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= elements.size();
    }

    private int rightChild(int index) {
        return elements.get(rightChildIndex(index));
    }
  

    private int leftChild(int index) {
        return elements.get(leftChildIndex(index));
    }

    public void print() {
        for (int i = 0; i < elements.size(); i++) 
            System.out.print("  " +parent(i) + "  ");
        System.out.print("\n");
        for (int i = 0 ; i< elements.size(); i++)
            System.out.print("  " +elements.get(i)+ "  ");
    }
  
}
    
