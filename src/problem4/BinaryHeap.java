package problem4;

import java.nio.BufferUnderflowException;

public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {

    private int currentSize;

    private AnyType[] array;

    public BinaryHeap() {
        this.currentSize = 0;
    }

    public BinaryHeap(AnyType[] array) {
        this.currentSize = array.length;
        this.array = (AnyType[]) new Comparable[(currentSize + 2) * 11 / 10];
        int i = 1;
        for (AnyType element : array) {
            this.array[i++] = element;
        }
        buildHeap();
    }


    public void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    public AnyType findMin() {
        if (array == null || array.length == 0) {
            return null;
        }
        return array[1];
    }

    private boolean isEmpty() {
        return currentSize == 0;
    }


    public void deleteMin() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        array[1] = array[currentSize--];
        percolateDown(1);
    }


    public void insert(AnyType element) {
        if (currentSize == array.length - 1) {
            enlargeArray(array.length * 2 + 1);
        }
        array[array.length - 1] = element;
        percolateUp(element);
    }

    private void enlargeArray(int newSize) {
        AnyType[] newArray = (AnyType[]) new Comparable[newSize];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }




    private void percolateDown(int hole) {
        int child;
        AnyType tmp = array[hole];
        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0) {
                child++;
            }
            if (array[child].compareTo(tmp) < 0) { // comparing distance between 6 and 1, the distance is the same,
                // so 6 stays in place,
                // which should not be the case
                array[hole] = array[child];
            } else {
                break;
            }
        }
        array[hole] = tmp;
    }


    private void percolateUp(AnyType x) {
        int hole = ++currentSize;
        for (array[0] = x; x.compareTo(array[hole/2]) < 0; hole /= 2) {
            array[hole] = array[hole/2];
        }
        array[hole] = x;
    }
}