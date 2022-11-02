package JavaFiddle;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReversLinkedList2 {

    public static ListNode reverse(ListNode head, int left, int right){
        ListNode ptr = head, prev = null;
        int count = 0;
        while(++count < left){
            prev = ptr;
            ptr = ptr.next;
        } count--;
        ListNode start = prev;
        while(count++ < right){
            ListNode temp = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = temp;
        }

        if(left == 1) return prev;
        else{
            start.next.next = ptr;
            start.next = prev;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode e1 = new ListNode(1);
        ListNode e2 = new ListNode(2);
        ListNode e3 = new ListNode(3);
        ListNode e4 = new ListNode(4);
        ListNode e5 = new ListNode(5);
        e1.next = e2; e2.next = e3; e3.next = e4; e4.next = e5;
        ListNode head = e1;
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println(" ");
        head = e1;
        head = reverse(head, 1, 5);
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
