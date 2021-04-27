package Queue;

public class QueueLinkedList {

    public static class Node {
        int key;
        Node next = null;

        public Node (int key){
            this.key = key;
        }
    }

    public static void print(Node ndoe){
        if (ndoe != null){
            System.out.println(ndoe.key);
            print(ndoe.next);
        }
    }

    Node front, rear;
    int data;

    QueueLinkedList(){
        this.front = this.rear = null;
    }
    public void enqueue(int data){
        Node temp = new Node(data);
        if(this.rear == null){
            this.front = temp;
            this.rear = temp;
            return;
        }

        this.rear.next = temp;
        this.rear = temp;
    }

    public void dequeue(){
        if (this.front == null)
            return;

//        int temp = this.front.key;
        this.front = this.front.next;

        if(this.front == null)
            this.rear = null;
    }

    public static void main(String[] args) {
        QueueLinkedList queueLinkedList = new QueueLinkedList();

        queueLinkedList.enqueue(10);
        queueLinkedList.enqueue(20);
        queueLinkedList.enqueue(30);
        queueLinkedList.enqueue(40);
        queueLinkedList.enqueue(50);
        queueLinkedList.dequeue();
        print(queueLinkedList.front);
    }
}
