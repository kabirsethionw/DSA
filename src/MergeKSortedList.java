import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> tmpList = Arrays.asList(lists);
        while(tmpList.size() != 1){
            tmpList = merge(tmpList);
        }
        return tmpList.get(0);
    }

    public static List<ListNode> merge(List<ListNode> arrLists){
        List<ListNode> tmpList = new ArrayList<>();
        int s = arrLists.size()/2, r = arrLists.size() - s*2;
        if(r != 0){
            tmpList.add(arrLists.get(2*s));
        }

        for(int i = 0; i < 2*s; ){
            tmpList.add(mergeLists(arrLists.get(i++), arrLists.get(i++)));
        }

        return tmpList;
    }

    public static ListNode mergeLists(ListNode listNode1, ListNode listNode2) {
        ListNode mergedList = null , ptr = null;

        while(listNode1 != null && listNode2 != null){
             if(mergedList == null){
                 mergedList = new ListNode();
                 ptr = mergedList;
             }
             else{
                 ptr.next = new ListNode();
                 ptr = ptr.next;
             }

             if(listNode1.val < listNode2.val){
                 ptr.val = listNode1.val;
                 listNode1 = listNode1.next;
             }
             else{
                 ptr.val = listNode2.val;
                 listNode2 = listNode2.next;
             }
        }

        while(listNode1 != null){
            if(mergedList == null){
                mergedList = new ListNode();
                ptr = mergedList;
            }
            else{
                ptr.next = new ListNode();
                ptr = ptr.next;
            }
            ptr.val = listNode1.val;
            listNode1 = listNode1.next;
        }

        while(listNode2 != null){
            if(mergedList == null){
                mergedList = new ListNode();
                ptr = mergedList;
            }
            else{
                ptr.next = new ListNode();
                ptr = ptr.next;
            }
            ptr.val = listNode2.val;
            listNode2 = listNode2.next;
        }

        return mergedList;
    }
}
