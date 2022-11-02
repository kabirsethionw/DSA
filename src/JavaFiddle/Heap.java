package JavaFiddle;

/**
 * @description: Min heap where heap[i] > 0, heap[i] = 0 means empty node
 */
public class Heap {
    private int heap[] = new int[100];
    private int size = 0;

    public void insert(int elem){
        int index = size;
        size++;
        heap[index] = elem;
        while(index > 0 && heap[index/2] > heap[index]){
            int temp = heap[index];
            heap[index] = heap[index/2];
            heap[index/2] = temp;
            index /= 2;
        }
        return;
    }

    public void delete(){
        int
                elem = heap[0],
                index = size -1;
        heap[0] = heap[index];
        heap[index] = 0;
        index = 0;
        size--;
        int
                child1 = (int)Math.pow(2, index + 1) - 1,
                child2 = (int)Math.pow(2, index + 1);

        while((heap[child1] != 0 && heap[child1] < heap[index]) || (heap[child2] != 0 && heap[child2] < heap[index])){
            if(heap[child1] < heap[index]){
                int temp = heap[child1];
                heap[child1] = heap[index];
                heap[index] = temp;
                index = child1;
            }
            else{
                int temp = heap[child2];
                heap[child2] = heap[index];
                heap[index] = temp;
                index = child2;
            }
            child1 = (int)Math.pow(index + 1, 2) - 1;
            child2 = (int)Math.pow(index + 1, 2);
        }
        return;
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(15);
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        heap.insert(30);
        heap.delete();
    }
}
