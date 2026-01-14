public class StackArr<T> {
    private T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public StackArr(int capacity) {
        data = (T[]) new Object[capacity];
        size = -1;
    }

    public void push(T element) {
        if (size == data.length - 1) {
            throw new ArrayIndexOutOfBoundsException("Stack overflow");
        }
        size++;
        data[size] = element;
    }

    public T pop() {
        if (size == -1) {
            throw new ArrayIndexOutOfBoundsException("Stack underflow");
        }
        T res = data[size];
        data[size] = null;
        size--;
        return res;
    }

    public T peek() {
        if (size == -1) {
            throw new ArrayIndexOutOfBoundsException("Stack underflow");
        }
        return data[size];
    }
}
