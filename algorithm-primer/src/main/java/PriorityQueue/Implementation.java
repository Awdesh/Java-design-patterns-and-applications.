package PriorityQueue;

import java.util.Arrays;

/*
Implementing priority queue. Min-Heap.
 */
public class Implementation {
    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    private boolean hasParent(int index) { return getParentIndex(index) >= 0; }
    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size; }
    private boolean hasRightChild(int index) { return getRightChildIndex(index) < size; }

    private int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1;}
    private int getRightChildIndex(int parentIndex) { return 2 * parentIndex + 2;}
    private int getParentIndex(int childIndex) { return (childIndex - 1) / 2;}

    private int parent(int index) { return items[getParentIndex(index)];}
    private int leftChild(int index) { return items[getLeftChildIndex(index)];}
    private int rightChild(int index) { return items[getRightChildIndex(index)];}

    /*
    This will be used in heapify process.
     */
    private void swap(int indexOne, int indexTwo)
    {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureExtraCapacity(){
        if(size == capacity){
            // copyOf creates another array with double capacity of current.
            Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public void heapifyUp(){
        int index = size - 1;
        //
        while(hasParent(index) && parent(index) > items[index]){
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    public void heapifyDown(){
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index))
                smallerChildIndex = getRightChildIndex(index);

            if(items[index] > items[smallerChildIndex]){
                swap(index, smallerChildIndex);
            } else {
                // We don;'t need to do anything since parent node's value
                // is lesser than both of it's children.'
                break;
            }
            // update the index so we continue heapify process.
            index = smallerChildIndex;
        }

    }

    public int peek(){
        if (size == 0) { throw new IllegalStateException();}
        return items[0];
    }

    public void push(int item){
        // adds at the bottom and then heapify up.
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public int poll(){

        if(size == 0) throw new IllegalStateException();

        // delete root node and then heapify down.
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    public void print() {
        int index = 0;
        while(index < size){
            System.out.println(items[index]);
            index ++;
        }
    }

    public static void main(String[] args) {
        System.out.println("*******************************");
        Implementation implementation = new Implementation();
        implementation.push(10);
        implementation.push(15);
        implementation.push(20);
        implementation.push(17);
        implementation.push(25);
        implementation.print();
        System.out.print("Size is-:");
        System.out.println(implementation.size);
        System.out.print("Capacity is-:");
        System.out.println(implementation.capacity);
        System.out.println("*******************************");

        implementation.push(8);
        implementation.print();
        System.out.println("*******************************");

        int polledItem = implementation.poll();
        System.out.println(polledItem);
        System.out.println("*******************************");

        implementation.print();

        System.out.println("************************");
        System.out.println("Finding First 2 smallest");
        System.out.println(implementation.items[0]);
        System.out.println(implementation.items[1]);

        System.out.println("*******************************");
        implementation.print();
    }
}
