package Tests;
import Classes.MinHeap;

public class MinHeapTest {
    public static void main (String[] ar){

        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(15);
        minHeap.insert(100);
        minHeap.insert(4);

        System.out.println("First round: "+minHeap);

        System.out.println("Removing min value: "+minHeap.getMin());

        minHeap.insert(1);

        System.out.println("Second round: "+minHeap);
    }
}
