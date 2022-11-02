package CodingInterview.LinkedList;

import java.util.HashMap;
import java.util.LinkedList;

public class RemoveDups {
    private static HashMap<Integer, Boolean> map = new HashMap<>();

    /**
     * @description O(n)
     * @param head
     */
    public static void removeDup1(MyLinkedList head) {
        MyLinkedList ptr = head;
        while(ptr != null){
            if(map.get(ptr.val) != null){
                ptr.prev.next = ptr.next;
                if(ptr.next != null)
                    ptr.next.prev = ptr.prev;
            }
            else{
                map.put(ptr.val, true);
            }
            ptr = ptr.next;
        }

        map = new HashMap<>();
    }

    /**
     * @description No use of auxilary memo, O(n^2)
     * @param head
     */
    public static void removeDup2(MyLinkedList head){
        MyLinkedList ptr1 = head;
        while(ptr1 != null){
            MyLinkedList ptr2 = ptr1.next;
            while(ptr2 != null){
                if(ptr1.val == ptr2.val){
                    ptr2.prev.next = ptr2.next;
                    if(ptr2.next != null)
                        ptr2.next.prev = ptr2.prev;
                }
                ptr2 = ptr2.next;
            }
            ptr1 = ptr1.next;
        }
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

        System.out.println("Executing version 1");
        long timeLapsed = System.nanoTime();
        removeDup1(head);
        timeLapsed = System.nanoTime() - timeLapsed;
        System.out.println("Time taken by version 1: " + timeLapsed);
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("");

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
        System.out.println("Executing version 2");
        timeLapsed = System.nanoTime();
        removeDup2(head);
        timeLapsed = System.nanoTime() - timeLapsed;
        System.out.println("Time taken by version 2: " + timeLapsed);
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("");

    }
}
