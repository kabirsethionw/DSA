package CodingInterview.LinkedList;

public class MyLinkedList {
    int val = -1;
    MyLinkedList
            prev = null,
            next = null;

    public MyLinkedList(int val, MyLinkedList prev, MyLinkedList next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
