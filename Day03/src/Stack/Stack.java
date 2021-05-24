package Stack;

import java.util.Arrays;

class Stack {
    private int[] arr;
    private int top = 0;

    Stack(int size) {
        arr = new int[size];
    }

    public void push(int val) {
        if(top >= arr.length) return;

        arr[top] = val;
        top++;
    }

    public int pop() {
        if(top == 0) throw new Error("stack is empty");
        top = top - 1;
        int popVal = arr[top];
        return popVal;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public boolean isFull() {
        return top == arr.length;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "arr=" + Arrays.toString(arr) +
                ", top=" + top +
                '}';
    }

    public void test() {
        int val = 30;

        System.out.println(isEmpty() == true);
        System.out.println(isFull() == false);

        push(val);

        System.out.println(isEmpty() == false);
        System.out.println(isFull() == false);
        System.out.println(top == 1);
        System.out.println(arr[0] == val);

        push(2);
        push(3);
        push(4);
        push(5);
        push(6);

        System.out.println(isEmpty() == false);
        System.out.println(isFull() == true);
        System.out.println(arr[arr.length-1] == 5);

        int popped = pop();

        System.out.println(popped == 5);

        System.out.println(isEmpty() == false);
        System.out.println(isFull() == false);

        pop(); // 4
        pop(); // 3
        pop(); // 2
        pop(); // 1
        try {
            pop(); // when empty
        }
        catch (Error e) {
            System.out.println(e.getMessage().equals("stack is empty"));
        }

        System.out.println(isEmpty() == true);
        System.out.println(isFull() == false);
    }
}

class StackExample {

    public static void main(String[] args) {
        Stack myStack = new Stack(4);
        Stack myStack2 = new Stack(7);

        myStack.push(10);

        System.out.println(myStack);
        System.out.println(myStack2);
    }
}