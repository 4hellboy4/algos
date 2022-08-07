package stack_deck;

interface Interface<T> {

    void push(T object);

    T pop();

    T peek();

    int curSize();

    boolean isEmpty();

}
