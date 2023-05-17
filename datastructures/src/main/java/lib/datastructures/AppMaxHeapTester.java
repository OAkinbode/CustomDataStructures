package lib.datastructures;

import lib.datastructures.heap.MaxH;

public class AppMaxHeapTester {
    public static void main(String[] args) {

        int[] array = { 4, 18, 22, 10, 7, 9, 2, 6 };
        MaxH maxh = new MaxH(array);

        maxh.heapSort();

        maxh.delete(22);

        //maxh.insert(12);


        maxh.print();

        //System.out.println(maxh.contains(18));

      




    }
}
