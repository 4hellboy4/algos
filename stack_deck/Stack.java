package stack_deck;

public class Stack<T> implements Interface<T> {
    private Object[] elements;
    private final int DEFAULT_STACK_CAPACITY = 20;
    private int currentCapacity;
    private int size;

    Stack() {
        setSize(0);
        setCurrentCapacity(DEFAULT_STACK_CAPACITY);
        elements = new Object[getCurrentCapacity()];
    }

    Stack(int currentCapacity) {
        setSize(0);
        setCurrentCapacity(currentCapacity);
        elements = new Object[getCurrentCapacity()];
    }

    public void grow() {
        Object[] newElements = new Object[getCurrentCapacity() * 2];
        for (int i = 0; i < getCurrentCapacity(); i++) {
            newElements[i] = elements[i];
        }
        setCurrentCapacity(getCurrentCapacity() * 2);
        elements = newElements;
    }

    @Override
    public void push(T object) {
        if (getSize() + 1 > getCurrentCapacity()) grow();
        if (getSize() + 1 <= getCurrentCapacity()) {
            setSize(getSize() + 1);
        }
        elements[getSize() - 1] = object;
    }

    @Override
    public T pop() {
        T obj = (T) elements[getSize() - 1];
        setSize(getSize() - 1);
        return obj;
    }

    @Override
    public T peek() {
        T obj = (T) elements[getSize() - 1];
        return obj;
    }

    @Override
    public int curSize() {
        return getSize();
    }

    @Override
    public boolean isEmpty() {
        if (getSize() == 0) {
            return true;
        } else {
            return false;
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
