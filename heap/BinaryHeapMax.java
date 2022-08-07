package heap;

import heap.Container;

class BinaryHeapMax<T extends Comparable<T>> implements Container<T> {
    private Object[] elements;
    private int DEFAULT_CAPACITY = 20;
    private int currentCapacity;
    private int size;

    BinaryHeapMax() {
        setSize(0);
        setCurrentCapacity(DEFAULT_CAPACITY);
        elements = new Object[getCurrentCapacity()];
    }

    BinaryHeapMax(int capacity) {
        setSize(0);
        setCurrentCapacity(capacity);
        elements = new Object[getCurrentCapacity()];
    }

    BinaryHeapMax(Object[] arr) {
        setSize(arr.length);
        setCurrentCapacity(arr.length);
        elements = new Object[getCurrentCapacity()];
        for (int i = 0; i < arr.length; i++) {
            elements[i] = arr[i];
        }
//        elements = arr;
        for (int ind = getSize() - 1; ind >= 0; ind--) {
            siftDown(ind);
        }
    }

    public T findMax() {
        return (T) elements[0];
    }

    public T extractMax() {
        T max = (T) elements[0];
        remove(0);
        return max;
    }

    public T get(int index) {
        T elem = (T) elements[index];
        return elem;
    }

    public void set(int index, int val) {
        elements[index] = val;
    }

    public void grow() {
        Object[] newElements = new Object[getCurrentCapacity() * 2];
        for (int i = 0; i < getCurrentCapacity(); i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        this.currentCapacity *= 2;
    }

    public void swap(int ind1, int ind2) {
        T elemInd1 = (T) elements[ind1];
        elements[ind1] = elements[ind2];
        elements[ind2] = elemInd1;
    }

    @Override
    public void siftUp(int index) {
        while (index > 0 && ((T) elements[index]).compareTo((T) elements[(index - 1) / 2]) > 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    @Override
    public void siftDown(int index) {
        int lowest = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        if (getSize() > left && ((T) elements[left]).compareTo((T) elements[lowest]) > 0) {
            lowest = left;
        }
        if (getSize() > right && ((T) elements[right]).compareTo((T) elements[lowest]) > 0) {
            lowest = right;
        }

        if (lowest != index) {
            swap(index, lowest);
            siftDown(lowest);
        }
    }

    @Override
    public void insert(T element) {
        if (getSize() == getCurrentCapacity()) grow();
        elements[this.size] = element;
        siftUp(this.size);
        setSize(getSize() + 1);
    }

    @Override
    public void remove(int index) {
        swap(index, getSize() - 1);
        setSize(getSize() - 1);
        siftDown(index);
    }

    public void print() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(elements[i] + " ");
        }
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
