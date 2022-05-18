public class Queue<V> {


    private static class Node<V>{
        V element; //data
        Node<V> next; //pointer

        public Node(V element){
            this.element = element;
        }
        public Node(V element, Node<V> next){
            this.element = element;
            this.next = next;

        }
    }
    private Node<V> head;// head pointer point to the first node of the queue(use for remove() or poll())
    private Node<V> tail;// tail pointer point to the last node of the queue(use for add())
    private int maxSize;// max capacity
    private int length;// how many items in queue

    /**
    * Constructor to initialize the queue with a maximum capacity of maxSize.
    */
    @SuppressWarnings("unchecked")

    public Queue(int maxSize) {
        this.maxSize = maxSize;

    }

    /**
        Returns the maximum size this queue can support.
    */
    public int getMaxSize() {
        return maxSize;
    }

     /**
        Returns the current number of items enqueued.
    */
    public int getCurrentSize() {
        return length;
    }

    /**
        Returns true if there are no elements in the queue.
    */
    public boolean isEmpty() {
        return getCurrentSize()==0;
    }

    /**
        Returns true if the queue is size is at max size.
    */
    public boolean isFull() {
        return maxSize==getCurrentSize();
    }

    /**
        Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
    */
    public V peek() {
        return head.element;
    }

   /**
        Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available.
    */
    public void add(V value) {
        Node n = new Node<>(value);
        if(tail==null){
            tail=head=n;
        }else {
        tail.next = n;
        tail = n;
        }
        length++;
    }

    /**
        Retrieves and removes the head of this queue, or returns null if this queue is empty.
    */
    public V poll() {
        if(isEmpty()) return null;
        return head.element;
    }

    /**
        Retrieves and removes the head of this queue.
    */
     public V remove() {
         if(isEmpty()) return null;
         Node <V> temp= head;
         if(length==1){
             head = tail = null;
         }else{
             head=head.next;
             temp.next=null;
         }
         length--;
         return temp.element;
         }


}