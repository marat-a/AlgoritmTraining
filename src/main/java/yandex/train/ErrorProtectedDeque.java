import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Deque {
    ArrayList<Integer> array;
    int size;

    Deque() {
        this.array = new ArrayList<>();
        this.size = 0;
    }

    void push_front(int n) {
        array.add(0, n);
        size++;
        System.out.println("ok");
    }
    void push_back(int n) {
        array.add( n);
        size++;
        System.out.println("ok");
    }

    void pop_front() {
        if (size != 0) {
            System.out.println(array.remove(0));
            size--;
        } else System.out.println("error");
    }
    void pop_back() {
        if (size != 0) {
            System.out.println(array.remove(size-1));
            size--;
        } else System.out.println("error");
    }

    void back() {
        if (size != 0) {
            System.out.println(array.get(size - 1));
        } else System.out.println("error");
    }

    void front() {
        if (size != 0) {
            System.out.println(array.get(0));
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

public class ErrorProtectedDeque {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("input.txt"));
        Deque deque = new Deque();
        String command;
        while ((command = r.readLine()) != null) {
            if (command.contains("push_front")) {
                String[] pushCommand = command.split(" ");
                deque.push_front(Integer.parseInt(pushCommand[1]));
            }
            if (command.contains("push_back")) {
                String[] pushCommand = command.split(" ");
                deque.push_back(Integer.parseInt(pushCommand[1]));
            }
            if (command.contains("pop_front")) {
                deque.pop_front();
            }
            if (command.contains("pop_back")) {
                deque.pop_back();
            }
            if (command.equals("front")) {
                deque.front();
            }
            if (command.equals("back")) {
                deque.back();
            }
            if (command.contains("size")) {
                deque.size();
            }
            if (command.contains("clear")) {
                deque.clear();
            }
            if (command.contains("exit")) {
                deque.exit();
            }
        }
    }
}


