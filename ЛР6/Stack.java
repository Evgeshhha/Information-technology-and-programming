import java.util.*;

public class Stack<T> {
    private ArrayList<T> data;

    public Stack() {
        data = new ArrayList<>();
    }

    public Stack(int capacity) {
        data = new ArrayList<>(capacity);
    }

    public void push(T element) {
        data.add(element);
    }

    public T pop() {
        if (data.isEmpty()) {
            throw new IllegalStateException("Stack underflow");
        }
        T res = data.get(data.size() - 1);
        data.remove(data.size() - 1);
        return res;
    }

    public T peek() {
        if (data.isEmpty()) {
            throw new IllegalStateException("Stack underflow");
        }
        return data.get(data.size() - 1);
    }
}