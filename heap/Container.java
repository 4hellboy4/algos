package heap;

interface Container<T> {

    void siftUp(int index);

    void siftDown(int index);

    void insert(T element);

    void remove(int index);

}
