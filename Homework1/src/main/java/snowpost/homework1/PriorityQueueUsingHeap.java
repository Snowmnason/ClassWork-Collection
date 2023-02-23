package snowpost.homework1;

import java.util.ArrayList;

/**
 *
 * @author Snow
 */
public class PriorityQueueUsingHeap implements PriorityQueue {

    private Employee[] heap = new Employee[1234];

    public PriorityQueueUsingHeap() {
    }
    ;
    int size = 0;
    /**
     * 
     * @return current size of the queue 
     */
    @Override
    public int getLenght() {
        return size;
    }
    /**
     *
     * @return a Boolean true if empty false if it has an item
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * Cleans the queue without displaying it
     */
    @Override
    public void clear() {
        while (!isEmpty()) {
            getMax();
            size--;
        }
    }
    /**
     * @return The largest value in the queue
     */
    @Override
    public Employee getMax() {
        Employee answer = null;
        if (size == 0) {
            //do nothing
        } else {
            answer = heap[0];
            heap[0] = heap[size - 1];
            heapifyDown(0);
        }
        size--;
        return answer;
    }
    /**
     * adds employee to the list, most recent at the top
     * @param e Employee to be add
     */
    @Override
    public void add(Employee e) {
        if (size == 0) {
            heap[0] = e;
        } else {
            heap[size] = e;
            heapifyUp(size);
        }
        size++;
    }
    /**
     * 
     * @param index current index of item that needs to move up the array
     */
    void heapifyUp(int index) {
        Employee item = heap[index];
        int parentIndex = getParentIndex(index);
        Employee parent = heap[parentIndex];
        while (item.getSalary() > parent.getSalary()) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = getParentIndex(index);
            item = heap[index];
            parent = heap[parentIndex];
        }
    }
    /**
     * 
     * @param index current index of item that needs to move down the array
     */
    void heapifyDown(int index) {
        Employee item = heap[index];
        int childIndex = getChild(index);
        Employee child = heap[childIndex];
        while (item.getSalary() < child.getSalary()) {
            swap(index, childIndex);
            index = childIndex;
            childIndex = getChild(index);
            if (childIndex == -1) {
                break;
            }
            child = heap[childIndex];
            item = heap[index];
        }
    }
    /**
     * 
     * @param index index in which we need the child for
     * @return  the child index
     */
    int getChild(int index) {
        int childRightindex = getRightChildIndex(index);
        int childLeftindex = getLeftChildIndex(index);
        int childIndex;
        if ((childRightindex < size || childLeftindex < size) && heap[childRightindex].getSalary() < heap[childLeftindex].getSalary()) {
            childIndex = childRightindex;
        } else if (((childRightindex < size || childLeftindex < size) && heap[childRightindex].getSalary() > heap[childLeftindex].getSalary())) {
            childIndex = childLeftindex;
        } else {
            childIndex = size - 1;
        }
        return childIndex;
    }
    /**
     * 
     * @param index1 current index or parent
     * @param index2 child index that needs to swap with the parent
     */
    void swap(int index1, int index2) {
        Employee indexA = heap[index1];//12
        Employee indexB = heap[index2];//5
        heap[index1] = indexB;
        heap[index2] = indexA;
    }
    /**
     * 
     * @param index current index
     * @return parent index
     */
    int getParentIndex(int index) {
        return (index - 1) / 2;
    }
    /**
     * 
     * @param index current index
     * @return Left Child index
     */
    int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }
    /**
     * 
     * @param index current index
     * @return Right Child index
     */
    int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    
    
    PriorityQueueUsingHeap(PriorityQueueUsingHeap other) {
        PriorityQueueUsingHeap copyInternal = other;
    }

    public PriorityQueueUsingHeap makeCopy() {
        PriorityQueueUsingHeap copyExternal = new PriorityQueueUsingHeap();
        return copyExternal;
    }
}
