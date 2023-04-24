import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class StackStruct {
    ArrayList<Integer> array;
    int size;

    StackStruct() {
        this.array = new ArrayList<>();
        this.size = 0;
    }

    void push(int n) {
        array.add(n);
        size++;
        System.out.println("ok");
    }

    void pop() {
        if (size != 0) {
            System.out.println(array.remove(size - 1));
            size--;
        } else System.out.println("error");

    }

    void back() {
        if (size != 0) {
            System.out.println(array.get(size - 1));
        } else System.out.println("error");
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
        System.exit(0);
    }
}

public class Stack {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("src/main/java/yandex/input.txt"));
        StackStruct stack = new StackStruct();
        String command;
        while ((command = r.readLine()) != null) {
            if (command.contains("push")) {
                String[] pushCommand = command.split(" ");
                stack.push(Integer.parseInt(pushCommand[1]));
            }
            if (command.contains("pop")) {
                stack.pop();
            }
            if (command.contains("back")) {
                stack.back();
            }
            if (command.contains("size")) {
                stack.size();
            }
            if (command.contains("clear")) {
                stack.clear();
            }
            if (command.contains("exit")) {
                stack.exit();
            }
        }
    }
}

