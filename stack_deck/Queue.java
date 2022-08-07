package stack_deck;

public class Queue<T> implements Interface<T> {
    private final int DEFAULT_CAPACITY = 10;
    private int currentCapacity;
    private Interface<T> stack = new Stack<>();
    private Interface<T> stackDel = new Stack<>();
    private int del;
    private int size;

    Queue() {
        setSize(0);
        setDel(0);
        setCurrentCapacity(DEFAULT_CAPACITY);
        stack = new Stack<>(getCurrentCapacity());
        stackDel = new Stack<>(getCurrentCapacity());
    }

    Queue(int capacity) {
        setSize(0);
        setDel(0);
        setCurrentCapacity(capacity);
        stack = new Stack<>(getCurrentCapacity());
        stackDel = new Stack<>(getCurrentCapacity());
    }

    @Override
    public void push(T object) {
        setSize(getSize() + 1);
        stack.push(object);
//        elements[getSize()] = object;
    }

    @Override
    public T pop() {
        T obj = null;
        if (stackDel.isEmpty()) {
            while (!stack.isEmpty()) {
                stackDel.push(stack.pop());
            }
        }
        if (!stackDel.isEmpty()) {
            setSize(getSize() - 1);
            obj = (T) stackDel.pop();
        };

        return obj;
    }

    @Override
    public T peek() {
        T obj = null;
        if (stackDel.isEmpty()) {
            while (!stack.isEmpty()) {
                stackDel.push(stack.pop());
            }
        }
        if (!stackDel.isEmpty()) {
            obj = (T) stackDel.peek();
        }

        return obj;
    }

    @Override
    public int curSize() {
        return getSize();
    }

    @Override
    public boolean isEmpty() {
        if (getSize() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

}
