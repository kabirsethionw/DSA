package CodingInterview.LinkedList;

public class RemoveKthFromLast {
    public static MyLinkedList remove(MyLinkedList head, int k){
        MyLinkedList ptr1, ptr2;
        ptr2 = head; ptr1 = head;
        int dist = 1, count = 0;
        while(dist++ != k){
            ptr1 = ptr1.next;
            if(ptr1 != null) return null;
        }

        while(ptr1.next != null){
            count++;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        if(ptr2.prev != null)
            ptr2.prev.next = ptr2.next;
        if(ptr2.next != null)
            ptr2.next.prev = ptr2.prev;

        if(count == 0)
            head = ptr2.next;

        return head;
    }

    public static void main(String[] args) {
        MyLinkedList n1, n2, n3, n4, n5, n6, n7, n8, n9, head;
        n1 = new MyLinkedList(5, null, null);
        n2 = new MyLinkedList(7, n1, null); n1.next = n2;
        n3 = new MyLinkedList(8, n2, null); n2.next = n3;
        n4 = new MyLinkedList(5, n3, null); n3.next = n4;
        n5 = new MyLinkedList(9, n4, null); n4.next = n5;
        n6 = new MyLinkedList(6, n5, null); n5.next = n6;
        n7 = new MyLinkedList(8, n6, null); n6.next = n7;
        n8 = new MyLinkedList(9, n7, null); n7.next = n8;
        n9 = new MyLinkedList(5, n8, null); n8.next = n9;
        head = n1;
        head = remove(head, 3);
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
