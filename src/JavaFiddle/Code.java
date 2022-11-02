package JavaFiddle;

import java.util.LinkedList;
import java.util.Queue;

public class Code {
    public static void main(String[] args) {
        System.out.println("Hello from Java!");
        Queue<Integer> Q
                = new LinkedList<Integer>();

        // Add numbers to end of Queue
        Q.add(7855642);
        Q.add(35658786);
        Q.add(5278367);
        Q.add(74381999);

        // print queue
        System.out.println("Queue: " + Q.poll());
    }
}
