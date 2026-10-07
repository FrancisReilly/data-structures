package priorityqueue;

import java.util.NoSuchElementException;

public class SortedArrayPriorityQueue {

    private final int[] items;
    private int size;

    public SortedArrayPriorityQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive, got " + capacity);
        }
        items = new int[capacity];
        size = 0;
    }

    //Adds a value, keeping the array in ascending order. 
    public void insert(int value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full (capacity " + items.length + ")");
        }
        int j = size;
        // Shift every element larger than value one place to the right.
        while (j > 0 && items[j - 1] > value) {
            items[j] = items[j - 1];
            j--;
        }
        items[j] = value;
        size++;
    }

    //Removes and returns the smallest value. 
    public int remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove from an empty queue");
        }
        int min = items[0];
        // Shift the remaining elements one place to the left.
        for (int i = 1; i < size; i++) {
            items[i - 1] = items[i];
        }
        size--;
        return min;
    }

    //Returns the smallest value without removing it.
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot peek at an empty queue");
        }
        return items[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == items.length;
    }

    public int size() {
        return size;
    }

    
    public static void main(String[] args) {
        SortedArrayPriorityQueue queue = new SortedArrayPriorityQueue(10);
        int[] values = {42, 7, 19, -3, 25, 7, 0};

        System.out.print("Inserting: ");
        for (int v : values) {
            System.out.print(v + " ");
            queue.insert(v);
        }
        System.out.println();

        System.out.println("Smallest (peek): " + queue.peek());

        System.out.print("Removing:  ");
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }
}
