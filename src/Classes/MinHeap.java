package Classes;

import Generics.TypeNode;

import java.util.Arrays;


public class MinHeap {

    private int[] heap;
    private int size;
    private int maxSize;

    private static final int FRONT = 1;



    public MinHeap(int maxSize){
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[this.maxSize + 1];
        heap[0] = Integer.MIN_VALUE;

    }

    private void swap(TypeNode parent, TypeNode children){
        TypeNode temp = parent;
        parent = children;
        children = temp;
    }

    private void swimUp(TypeNode parent, TypeNode children){
        if (children.value > parent.value){
            swap(parent,children);
        }
    }

    // Get parent

    private int parent(int pos)
    {
        return pos / 2;
    }

    private int leftChild(int pos)
    {
        return (2 * pos);
    }

    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos)
    {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    private void minHeapify(int pos)
    {

        // If the node is a non-leaf node and greater
        // than any of its child
        if (!isLeaf(pos)) {
            if (heap[pos] > heap[leftChild(pos)]
                    || heap[pos] > heap[rightChild(pos)]) {

                // Swap with the left child and heapify
                // the left child
                if (heap[leftChild(pos)] < heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }

                // Swap with the right child and heapify
                // the right child
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element)
    {
        if (size >= maxSize) {
            return;
        }
        heap[++size] = element;
        int current = size;

        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void minHeap()
    {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    public int remove()
    {
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        minHeapify(FRONT);
        return popped;
    }


    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + heap[i]
                    + " LEFT CHILD : " + heap[2 * i]
                    + " RIGHT CHILD :" + heap[2 * i + 1]);
            System.out.println();
        }
    }

    public Node getMin(){
        return null;
    }

    // TODO: finish
    public Node extractMin(){
        return new Node(0);
    }

    public void insert(Node node){

    }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }
}
