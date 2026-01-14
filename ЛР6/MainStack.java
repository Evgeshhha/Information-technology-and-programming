public class MainStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push(4);
        System.out.println(stack.pop());

        StackArr<Integer> stackArr = new StackArr<>(10);
        stackArr.push(1);
        stackArr.push(2);
        stackArr.push(3);
        System.out.println(stackArr.pop());
        System.out.println(stackArr.peek());
        stackArr.push(4);
        System.out.println(stackArr.pop());

    }
}
