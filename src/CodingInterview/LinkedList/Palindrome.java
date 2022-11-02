package CodingInterview.LinkedList;

import java.util.Stack;

public class Palindrome {
    public static boolean isPalindrome(MyLinkedList head){
        MyLinkedList
                fastHead = head,
                slowHead = head,
                ptr1, ptr2;
        Stack<MyLinkedList> stack = new Stack();
        int count = 1;
        while(fastHead.next != null){
            fastHead = fastHead.next; count++;
            if(fastHead.next != null){
                fastHead = fastHead.next;
                count++;
            }
            stack.push(slowHead);
            slowHead = slowHead.next;
        }

        ptr1 = slowHead;
        ptr2 = slowHead.next;

        if(count%2 != 0){
            ptr1 = stack.pop();
        }

        while(!stack.isEmpty()){
            if(ptr1.val != ptr2.val) return false;
            ptr1 = stack.pop(); ptr2 = ptr2.next;
        }

        return true;
    }

    public static void main(String[] args) {
        MyLinkedList n1, n2, n3, n4, n5, n6, n7, n8, n9, head;
        n1 = new MyLinkedList(5, null, null);
        n2 = new MyLinkedList(7, n1, null); n1.next = n2;
        n3 = new MyLinkedList(8, n2, null); n2.next = n3;
        n4 = new MyLinkedList(5, n3, null); n3.next = n4;
        n5 = new MyLinkedList(9, n4, null); n4.next = n5;
        n6 = new MyLinkedList(5, n5, null); n5.next = n6;
        n7 = new MyLinkedList(8, n6, null); n6.next = n7;
        n8 = new MyLinkedList(7, n7, null); n7.next = n8;
        n9 = new MyLinkedList(5, n8, null); n8.next = n9;
        head = n1;
        System.out.println(isPalindrome(head));
    }
}
