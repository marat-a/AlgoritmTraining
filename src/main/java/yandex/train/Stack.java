import java.util.ArrayList;

class StackStruct {
    ArrayList<Integer> array;
    int size;

    void push(int n) {
        array.add(n);
        size++;
        System.out.println("ok");
    }

    void pop() {
        size--;
        System.out.println(array.remove(size-1));
    }

    void back() {
        System.out.println(array.get(size-1));
    }

    void size() {
        System.out.println(size);
    }

    void clear() {
        size = 0;
        array.clear();
        System.out.println("ok");
    }
    void exit() {
        System.out.println("bye");
    }
}

public class Stack {
    public static void main(String[] args) {

    }
}
