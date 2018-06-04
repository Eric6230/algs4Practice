import edu.princeton.cs.algs4.*; // for test client code main()
//FIFO queue (linked-list implementation)
public class Queue<Item>
{
    private Node first; // link to least recently added node
    private Node last; // link to most recently added node
    private int N; // number of items on the queue
    
    private class Node
    {
        Item item;
        Node next;
    }
    
    public boolean isEmpty() { return first == null; }
    public int size() { return N; }
    
    public void enqueue(Item item)
    {
        // add node at the end of linked-list
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty())
            first = last;
        else
            oldlast.next = last;
        N++;
    }
    
    public Item dequeue()
    {
        // remove node from the head of linked list
        Item item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        N--;
        return item;
    }
    
    public static void main(String[] args)
    {
        Queue<String> q = new Queue<String>();
        while(!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            if(!item.equals("-"))
                q.enqueue(item);
            else if(!q.isEmpty())
                StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on stack)");
    }
}