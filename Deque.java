import java.util.Iterator;
import java.util.NoSuchElementException;

/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */
public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int c;

    private class Node
    {
        Item item;
        Node next;
        Node prev;
    }


    public Deque()
    {
        first = new Node();
        last = new Node();
        c = 0;
    }


    public boolean isEmpty()
    {
        return c == 0;
    }


    public void addFirst(Item item)
    {
        if (item == null)
            throw new IllegalArgumentException("Item cannot be null");

        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        first.prev = null;
        if (isEmpty()) {
            last = first;
        } else {
            oldFirst.prev = first;
        }
        c++;
    }


    public void addLast(Item item)
    {
        if (item == null)
            throw new IllegalArgumentException("Item cannot be null");
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.prev = oldLast;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        c++;
    }


    public Item removeFirst()
    {
        if (isEmpty())
            throw new NoSuchElementException("List is empty");
        Item item = first.item;
        c--;
        if (isEmpty()) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.prev = null;
        }
        return item;
    }


    public Item removeLast()
    {
        if (isEmpty())
            throw new NoSuchElementException("List is empty");
        Item item = last.item;
        c--;
        if (isEmpty()) {
            first = null;
            last = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        return item;
    }


    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }


    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean hasNext()
        {
            return current == null;
        }

        public void remove()
        {
            throw new UnsupportedOperationException("Unsupported action");
        }

        public Item next()
        {
            if (hasNext())
                throw new NoSuchElementException("List is empty");
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


    public int size()
    {
        return c;
    }


    public static void main(String[] args)
    {
        Deque<String> d = new Deque<>();
        for (int i = 1; i <= 50; i++)
        d.addFirst("u");
        Iterator<String> i = d.iterator();
        int k = 0;
        while (!i.hasNext())
            System.out.println(++k + "==>" + i.next() + " ");
    }
}
