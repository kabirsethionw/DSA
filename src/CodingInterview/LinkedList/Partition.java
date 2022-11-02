package CodingInterview.LinkedList;

public class Partition {
    public static MyLinkedList doPartition(MyLinkedList node, int partition){
        MyLinkedList
                head = node,
                tail = node;

        while(node != null){
            MyLinkedList next = node.next;
            if(node.val < partition){
                node.next = head;
                head = node;
            }
            else{
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }

    public static void main(String[] args) {
        MyLinkedList n1, n2, n3, n4, n5, n6, n7, n8, n9, head;
        n1 = new MyLinkedList(4, null, null);
        n2 = new MyLinkedList(7, null, null); n1.next = n2;
        n3 = new MyLinkedList(8, null, null); n2.next = n3;
        n4 = new MyLinkedList(5, null, null); n3.next = n4;
        n5 = new MyLinkedList(9, null, null); n4.next = n5;
        n6 = new MyLinkedList(6, null, null); n5.next = n6;
        n7 = new MyLinkedList(8, null, null); n6.next = n7;
        n8 = new MyLinkedList(2, null, null); n7.next = n8;
        n9 = new MyLinkedList(1, null, null); n8.next = n9;
        head = n1;
        head = doPartition(head, 5);
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
