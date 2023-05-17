package lib.datastructures.heap;

import java.util.Vector;

public class MinH extends Heap {
    private Vector<Integer> elements = new Vector<Integer>();

    public MinH() {

    }
     public MinH(int size) {
        elements = new Vector<Integer>(size);
    }

    public MinH(int[] array) {
        elements = new Vector<Integer>();
        for (int i = 0; i < array.length; i++) {
            elements.add(array[i]);
        }
    }
    
    /**
     * insert method for heap.
     * 
     * runtime complexity = O(log n)
     * @param val
     */
    public void insert(int val) {
        elements.add(val);
        bubbleUp();
    }

    /**
     * Sorting by inserting each method one at a time into the vector.
     * 
     * runtime complexity = O(nLogn)
     * space complexity = O(n)
     */
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
    
    /**
     * Runtime complexity = O(nlog n)
     * space complexity = O(1)
     * 
     * @param elements 
     * @param index
     */
    private void heapSort(Vector<Integer> elements, int index) {
        int largerIndex = index;

        int leftIndex = index * 2 + 1;
        if (leftIndex < elements.size() &&
            elements.get(leftIndex) < elements.get(largerIndex))
        largerIndex = leftIndex;

        int rightIndex = index * 2 + 2;
        if (rightIndex < elements.size() &&
        elements.get(rightIndex) < elements.get(largerIndex))
        largerIndex = rightIndex;

        if (index == largerIndex)
        return;

        swap(index, largerIndex);
        heapSort(elements, largerIndex);
    }
    


    /**
     * runtime complexity = O(log n)
     */
    private void bubbleUp() {
        int index = elements.size() - 1;
        while (index > 0 && elements.get(index) < elements.get(parent(index))) {
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
        }
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) == val)
                elements.remove(i);
        }
        //bubbleDown();
        sort();
    }

    public boolean contains(int value) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) == value )
                return true;
        }
        return false;
    }

    private void bubbleDown() {
        System.out.println("bubbledown");
        int index = 0;
        while (index < elements.size() && !isValidParent(index)) {
            int largerChildIndex = smallerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    private int smallerChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;
        if (!hasRightChild(index))
            return leftChildIndex(index);
        return (leftChild(index) < rightChild(index)) ? leftChildIndex(index) : rightChildIndex(index);

    }
    
    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }
    
    public void print() {
        for (int i = 0; i < elements.size(); i++) 
            System.out.print(" " +parent(i) + "  ");
        System.out.print("\n");
        for (int i = 0 ; i< elements.size(); i++)
            System.out.print(" " + elements.get(i)+ "  ");
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;
        boolean isValid = elements.get(index) <= leftChild(index);

        if (hasRightChild(index))
            isValid &= elements.get(index) <= rightChild(index);
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

    

}
