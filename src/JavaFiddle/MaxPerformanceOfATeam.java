package JavaFiddle;

import java.util.ArrayList;
import java.util.Collections;

class CustomMinHeap{

        private MyPair[] heap;
        private int size;
        private final int MAX_SIZE;

    CustomMinHeap(int maxSize){
            this.size = 0;
            this.MAX_SIZE = maxSize;
            this.heap = new MyPair[maxSize];
        }

        public int size(){
            return size;
        }

        private int getParent(int pos){
            return (pos - 1)/2;
        }

        private int getLeftChild(int pos){
            return pos*2 + 1;
        }

        private int getRightChild(int pos){
            return pos*2 + 2;
        }

        private boolean isLeaf(int pos)
        {
            if (pos > (size / 2) && pos <= size) {
                return true;
            }
            return false;
        }

        private void swap(int fpos, int spos)
        {
            MyPair tmp;
            tmp = heap[fpos];
            heap[fpos] = heap[spos];
            heap[spos] = tmp;
        }

        private void minHeapify(int pos){
            if(isLeaf(pos)) return;
            int
                    leftChild = getLeftChild(pos),
                    rightChild = getRightChild(pos);
            if((int)heap[pos].value > (int)heap[leftChild].value || (int)heap[pos].value > (int)heap[rightChild].value){
                if((int)heap[pos].value > (int)heap[leftChild].value){
                    swap(pos, leftChild);
                    minHeapify(leftChild);
                }
                else if ((int)heap[pos].value > (int)heap[rightChild].value){
                    swap(pos, rightChild);
                    minHeapify(rightChild);
                }
            }
        }

        public void insert(MyPair element){
            heap[size] = element;
            int
                    current = size,
                    parent = getParent(current);
            while((int)heap[current].value < (int)heap[parent].value){
                swap(current, parent);
                current = parent;
                parent = getParent(current);
            }
            size++;
        }

        public MyPair popTop(){
            MyPair popped = heap[0];
            size--;
            heap[0] = heap[size];
            minHeapify(0);
            return popped;
        }


}

public class MaxPerformanceOfATeam {
    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int maxPerformance = 0, teamSpeed = 0;
        CustomMinHeap minHeap = new CustomMinHeap(k);
        ArrayList<MyPair> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new MyPair(efficiency[i], speed[i]));
        }
        Collections.sort(list, (t1, t2) -> Integer.signum((int)t2.key - (int)t1.key));
        for(MyPair elem: list){
            int currentPerformance;
            if(minHeap.size() < k){
                minHeap.insert(elem);
            }
            else{
               MyPair popped = minHeap.popTop();
               teamSpeed -= (int)popped.value;
            }
            teamSpeed += (int)elem.value;
            currentPerformance = teamSpeed*(int)elem.key;
            maxPerformance = Math.max(maxPerformance, currentPerformance);
        }
        return maxPerformance%(int)(Math.pow(10, 9)+7);
    }

    public static void main(String[] args) {
        int
            n = 6,
            speed[] = {2,10,3,1,5,8},
            efficiency[] = {5,4,3,9,7,2},
            k = 3;

        System.out.println("Answer: " + maxPerformance(n, speed, efficiency,k));

//        CustomMinHeap myHeap = new CustomMinHeap(15);
//
//        myHeap.insert(new MyPair(9,1));
//        myHeap.insert(new MyPair(7,5));
//        myHeap.insert(new MyPair(5,2));
//        myHeap.insert(new MyPair(4,10));
//        myHeap.insert(new MyPair(3,3));
//        myHeap.insert(new MyPair(2,8));
//
//        System.out.println("Test: "+ myHeap.popTop().value);
    }
}
