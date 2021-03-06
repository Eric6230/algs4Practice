import edu.princeton.cs.algs4.*; // for test client code main()
//Pushdown Stack (linked-list implementation)
//LIFO
public class Stack<Item>
{
    private Node first; // top of stack
    private int N; // number of items
    
    private class Node
    {
        Item item;
        Node next;
    }
    
    public boolean isEmpty() { return first == null; }
    public int size() { return N; }
    
    public void push(Item item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        ++N;
    }
    
    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        --N;
        return item;
    }
    
    // test client code main()
    public static void main(String[] args)
    {
        Stack<String> s = new Stack<String>();
        while(!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            if(!item.equals("-"))
                s.push(item);
            else if(!s.isEmpty())
                StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
    