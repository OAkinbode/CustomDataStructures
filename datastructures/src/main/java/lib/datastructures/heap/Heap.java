package lib.datastructures.heap;

import java.util.Vector;

public abstract class Heap {
    private static Vector<Integer> elements;


    public static Vector<Integer> getElements() {
        return elements;
    }

    public void setElements(Vector<Integer> elements) {
        Heap.elements = elements;
    }

    public Heap() {
        Heap.elements = new Vector<Integer>();
    }

    public Heap(int size) {
        Heap.elements = new Vector<Integer>(size);
    }
    
    public Heap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            elements.addElement(array[i]);
        }
    }
    
    public int getSize() {
        return elements.size();
    }

     


    //no need for an isEmpty method as the vector class already has a method for it
    

    
}
