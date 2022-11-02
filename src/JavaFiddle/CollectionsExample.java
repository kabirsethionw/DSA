package JavaFiddle;

import java.util.*;

public class CollectionsExample {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);
        deque.offer(6);
        deque.pollFirst();
        deque.pollLast();
        Iterator iter = deque.descendingIterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        SortedSet<Integer> sortedSet = new TreeSet<Integer>();
        sortedSet.add(4);
        sortedSet.add(2);
        sortedSet.add(1);
        sortedSet.add(8);
        Iterator iter2 = sortedSet.iterator();
        while(iter2.hasNext()){
            System.out.println(iter2.next());
        }

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("abc");
        arrayList.add("def");
        arrayList.add("ijk");
        ListIterator lsIter = arrayList.listIterator();
        while(lsIter.hasNext()){
            System.out.println(lsIter.next());
        }
        while(lsIter.hasPrevious()){
            System.out.println(lsIter.previous());
        }
        System.out.println(arrayList.size());
        arrayList.trimToSize(); //It is used to trim the capacity of this ArrayList instance to be the list's current size.
        System.out.println(arrayList.size());

        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("abc");
        linkedList.add("def");
        linkedList.add("ijk");
        linkedList.removeFirstOccurrence("def");

        String s1 = new String("qwewqewq");
        String s2 = "qwewqewq";
        System.out.println(s1.hashCode() == s2.hashCode());
    }
}
