package Heap;

public class MaxHeap {

    int capacity;
    int size;
    int current;
    int[] maxHeap;

    MaxHeap(int capacity){
        this.capacity = capacity;
        size = 0;
        maxHeap = new int[capacity+1];
        maxHeap[0] = Integer.MAX_VALUE;
    }

    public int parent(int pos)
    {
        return pos/2;
    }

    public void swap(int pos1, int pos2){
        int temp;
        temp = maxHeap[pos1];
        maxHeap[pos1] = maxHeap[pos2];
        maxHeap[pos2] = temp;
    }

    public void insert(int key){

        maxHeap[++size] = key;
        current = size;

        while (maxHeap[current] > maxHeap[parent(current)]){
            swap(parent(current), current);
            current = parent(current);
        }
    }

    private boolean isLeaf(int pos){
        if(pos >= size/2 && pos <= size)
            return true;

        return false;
    }

    private int leftChild(int pos) { return (pos * 2);}

    private int rightChild(int pos) { return (pos * 2) +1 ;}

    public void maxHeapify(int pos){
            if(isLeaf(pos))
                return;

            if (maxHeap[pos] < maxHeap[leftChild(pos)]
                    || maxHeap[pos] < maxHeap[rightChild(pos)]){

                if(maxHeap[leftChild(pos)] > maxHeap[rightChild(pos)]){
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                }
                else{
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
    }

    public int extractMax(){
        int max = maxHeap[1];
        maxHeap[1] = maxHeap[size--];
        maxHeapify(1);
        return max;
    }

    public void print(){
        for (int i=1; i<= size /2; i++){
            System.out.println("HEAP : " + maxHeap[i]
                                + " LEFT CHILD : " +maxHeap[(i * 2)]
                                + " RIGHT CHILD : " +maxHeap[(i * 2) +1]);
            System.out.println();
        }
    }

    public static void main(String[] args){

        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.print();
        System.out.println("Max Heap: " + maxHeap.extractMax());
        maxHeap.print();
    }
}
