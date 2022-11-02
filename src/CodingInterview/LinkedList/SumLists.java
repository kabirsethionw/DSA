package CodingInterview.LinkedList;

import java.util.Stack;

public class SumLists {
    public static MyLinkedList sum(MyLinkedList head1, MyLinkedList head2){
        Stack<Integer> stack1 = new Stack(), stack2 = new Stack<>();
        MyLinkedList ptr1 = head1, ptr2 = head2;

        while(ptr1 != null || ptr2 != null){
            if(ptr1 != null){
                stack1.push(ptr1.val);
                ptr1 = ptr1.next;
            }
            if(ptr2 != null){
                stack2.push(ptr2.val);
                ptr2 = ptr2.next;
            }
        }

        int carry = 0;
        MyLinkedList head = null;
        while(!(stack1.isEmpty() && stack2.isEmpty())){
            int
                    num1 = stack1.isEmpty() ? 0 : stack1.pop(),
                    num2 = stack2.isEmpty() ? 0 : stack2.pop(),
                    num = num1 + num2 + carry;
            MyLinkedList node = new MyLinkedList(num%10, null, head);
            head = node;
            carry = num/10;
        }

        if(carry != 0){
            MyLinkedList node = new MyLinkedList(carry, null, head);
            head = node;
        }

        return head;
    }

    public static void main(String[] args) {
        MyLinkedList n1, n2, n3, n4, n5, n6, n7, n8, n9, head1, head2, head;
        // 874
        n1 = new MyLinkedList(4, null, null);
        n2 = new MyLinkedList(7, null, null); n1.next = n2;
        n3 = new MyLinkedList(8, null, null); n2.next = n3;
        head1 = n1;
        // 15874
        n1 = new MyLinkedList(7, null, null);
        n2 = new MyLinkedList(3, null, null); n1.next = n2;
        n3 = new MyLinkedList(8, null, null); n2.next = n3;
        n4 = new MyLinkedList(5, null, null); n3.next = n4;
        n5 = new MyLinkedList(1, null, null); n4.next = n5;
        head2 = n1;

        head = sum(head1, head2);

        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
