package heap;

class BinaryHeapMin<T extends Comparable<T>> implements Container<T> {
    private Object[] elements;
    private int DEFAULT_CAPACITY = 20;
    private int currentCapacity;
    private int size;

    BinaryHeapMin() {
        setSize(0);
        setCurrentCapacity(DEFAULT_CAPACITY);
        elements = new Object[getCurrentCapacity()];
    }

    BinaryHeapMin(int capacity) {
        setSize(0);
        setCurrentCapacity(capacity);
        elements = new Object[getCurrentCapacity()];
    }

    BinaryHeapMin(Object[] arr) {
        setSize(arr.length);
        setCurrentCapacity(arr.length);
        elements = arr;
        for (int ind = getSize() - 1; ind >= 0; ind--) {
            siftDown(ind);
        }
    }

    public void grow() {
        Object[] newElements = new Object[getCurrentCapacity() * 2];
        for (int i = 0; i < getCurrentCapacity(); i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        currentCapacity *= 2;
    }

    public T findMin() {
        return (T) elements[0];
    }

    public T extractMin() {
        T min = (T) elements[0];
        remove(0);
        return min;
    }

    public void swap(int ind1, int ind2) {
        T elemInd1 = (T) elements[ind1];
        elements[ind1] = elements[ind2];
        elements[ind2] = elemInd1;
    }

    @Override
    public void siftUp(int index) {
        while (index > 0 && ((T) elements[index]).compareTo((T) elements[(index - 1) / 2]) < 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    @Override
    public void siftDown(int index) {
        int largest = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        if (getSize() > left && ((T) elements[left]).compareTo((T) elements[largest]) < 0) {
            largest = left;
        }
        if (getSize() > right && ((T) elements[right]).compareTo((T) elements[largest]) < 0) {
            largest = right;
        }

        if (largest != index) {
            swap(index, largest);
            siftDown(largest);
        }
    }

    @Override
    public void insert(T element) {
        if (getSize() == getCurrentCapacity()) grow();
        elements[this.size] = element;
        setSize(getSize() + 1);
        siftUp(this.size);
    }

    @Override
    public void remove(int index) {
        swap(index, elements.length - 1);
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
