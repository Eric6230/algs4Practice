import edu.princeton.cs.algs4.*; // for test client code main()
import java.util.Iterator; // so that our code can refer to Java's Iterator interface
// Bag (linked-list implementation)
public class Bag<Item> implements Iterable<Item>
{
    private Node first; // first node in list
    
    private class Node
    {
        Item item;
        Node next;
    }
    
    public void add(Item item)
    {
        // same as push() in Stack
        // add node at the begining of a linked-list
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }
    
    public Iterator<Item> iterator()
    { return new ListIterator(); }
    
    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;
        
        public boolean hasNext()
        { return current != null; }        
        public void remove() {}       
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    public static void main(String[] args)
    {
        Bag<String> bag = new Bag<String>();
        while(!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            bag.add(item);
        }
        //happens to be LIFO order
        for(String s : bag)
            StdOut.print(s + " ");
        StdOut.println();
    }
}