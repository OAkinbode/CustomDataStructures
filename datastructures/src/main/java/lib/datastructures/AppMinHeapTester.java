package lib.datastructures;

import lib.datastructures.heap.MinH;

public class AppMinHeapTester {
    public static void main(String[] args) {

        int[] array = { 4, 18, 22, 10, 7, 9, 2, 6 };
        MinH minh= new MinH(array);

        minh.heapSort();

        minh.delete(22);

        // minh.insert(12);
        // minh.insert(2);
        // minh.insert(18);
        // minh.insert(4);
        // minh.insert(7);
        // minh.insert(1);
        // minh.insert(8);
        // minh.insert(5);


        minh.print();
        
        
    }
}
