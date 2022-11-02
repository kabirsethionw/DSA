package CodingInterview.LinkedList;

public class DetectLoop {
    public static boolean containsLoop(MyLinkedList head){
        MyLinkedList fastPtr = head, slowPtr = head;
        boolean loopDetected = false;
        while(fastPtr != null || fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(fastPtr == slowPtr){
                loopDetected = true;
                break;
            }
        }

        // When slowPtr and fastPtr will meet, the point will be where the loop starts
        slowPtr = head;
        if(fastPtr != null || fastPtr.next != null) {
            while(slowPtr != fastPtr){
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
            System.out.println("Loop at node with value - " + fastPtr.val);
        }

        return loopDetected;
    }

    public static void main(String[] args) {
        MyLinkedList n1, n2, n3, n4, n5, n6, n7, n8, n9, head;
        n1 = new MyLinkedList(1, null, null);
        n2 = new MyLinkedList(2, n1, null); n1.next = n2;
        n3 = new MyLinkedList(3, n2, null); n2.next = n3;
        n4 = new MyLinkedList(4, n3, null); n3.next = n4;
        n5 = new MyLinkedList(5, n4, null); n4.next = n5;
        n6 = new MyLinkedList(6, n5, null); n5.next = n6;
        n7 = new MyLinkedList(7, n6, null); n6.next = n7;
        n8 = new MyLinkedList(8, n7, null); n7.next = n8;
        n9 = new MyLinkedList(9, n8, null); n8.next = n9;
        n9.next = n4;
        head = n1;

        System.out.println(containsLoop(head));
    }
}
