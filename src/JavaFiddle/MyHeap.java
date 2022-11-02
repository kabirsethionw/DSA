package JavaFiddle;

public class MyHeap {
    private int[] heap;
    private int size;
    private final int MAX_SIZE;

    MyHeap(int maxSize){
        this.size = 0;
        this.MAX_SIZE = maxSize;
        this.heap = new int[maxSize];
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
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    private void minHeapify(int pos){
        if(isLeaf(pos)) return;
        int
                leftChild = getLeftChild(pos),
                rightChild = getRightChild(pos);
        if(heap[pos] > heap[leftChild] || heap[pos] > heap[rightChild]){
            if(heap[pos] > heap[leftChild]){
                swap(pos, leftChild);
                minHeapify(leftChild);
            }
            else if (heap[pos] > heap[rightChild]){
                swap(pos, rightChild);
                minHeapify(rightChild);
            }
        }
    }

    public void insert(int element){
        heap[size] = element;
        int
                current = size,
                parent = getParent(current);
        while(heap[current] < heap[parent]){
            swap(current, parent);
            current = parent;
            parent = getParent(current);
        }
        size++;
    }

    public int popTop(){
        int popped = heap[0];
        size--;
        heap[0] = heap[size];
        minHeapify(0);
        return popped;
    }

    public static void main(String[] args) {
        System.out.println("The Min Heap is ");

        MyHeap myHeap = new MyHeap(15);

        // Inserting nodes
        // Custom inputs
        myHeap.insert(5);
        myHeap.insert(3);
        myHeap.insert(17);
        myHeap.insert(10);
        myHeap.insert(84);
        myHeap.insert(19);
        myHeap.insert(6);
        myHeap.insert(22);
        myHeap.insert(9);

        // Calling maxHeap() as defined above

        // Print and display the maximum value in heap
        System.out.println("The min val is "
                + myHeap.popTop());
    }

}
