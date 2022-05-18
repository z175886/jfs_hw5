public class Stack<V>
{
    private static class Node<V>{

        V element; //data
        Node <V> next; //pointer

        public Node(V element){
            this.element = element;
        }
        public Node(V element, Node<V> next){
            this.element = element;
            this.next = next;

        }
    }

    private int length;
    private int maxSize;
    private Node<V> top;
    /**
        Constructor to initialize the stack with a maximum capacity of maxSize.
    */

    @SuppressWarnings("unchecked")
    public Stack(int maxSize)

    {
        this.maxSize = maxSize;
        this.top = null;
    }

    /**
         Pushes an item onto the top of this stack.
    */
    public void push(V element){
        Node<V> n = new Node<V>(element);
        n.next = top;
        top = n;
        length++;


    }

    /**
        Removes the object at the top of this stack and returns that object as the value of this function.
    */
    public V pop()
    {
        if(isEmpty()) throw new RuntimeException("Stack is empty");
        V element = top.element;
        top=top.next;
        length--;
        return element;
    }

    /**
        Looks at the object at the top of this stack without removing it from the stack.
    */
    public V peek()
    {
        if(isEmpty()) throw new RuntimeException("Stack is empty");
        return top.element;
    }

    /**
        Returns the number of items currently in the stack
    */
    public int currentSize() {

        return length;

    }

    /**
        Tests if this stack is empty.
    */
    public boolean isEmpty() {
        return top==null;
    }

    /**
        Tests if this stack is full
    */
    public boolean isFull() {
        return maxSize==length;
    }
    
}