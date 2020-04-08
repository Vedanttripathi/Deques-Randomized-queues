import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item>
{
    
    private Item[] s;
    private int n;

    public RandomizedQueue()
    {
        n = 0;
        s = (Item[]) new Object[1];
    }


    public boolean isEmpty()
    {
        return n == 0;
    }


    public int size()
    {
        return n;
    }


    public void enqueue(Item item)
    {
        if (item == null)
            throw new IllegalArgumentException("Item cannot be null");
        if (n == s.length)
            resize(2 * n);
        s[n++] = item;
    }


    private void resize(int capacity)
    {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++)
            copy[i] = s[i];
        s = copy;
    }


    public Item dequeue()
    {
        if (isEmpty())
            throw new NoSuchElementException("List is empty");
        int x = StdRandom.uniform(n);
        Item item = s[x];
        s[x] = s[n -1];
        s[n - 1] = null;
        if (n == (s.length/4))
            resize((s.length / 2));
        n--;
        return item;
    }


    public Item sample()
    {
        if (isEmpty())
            throw new NoSuchElementException("List is empty");
        int x = StdRandom.uniform(n);

        return s[x];
    }


    public Iterator<Item> iterator()
    {
        return new ReverseArrayIterator();
    }


    private void shuff()
    {
        StdRandom.shuffle(s);
    }


    private class ReverseArrayIterator implements Iterator<Item>
    {
        private int i = n;
        public boolean hasNext()
        {
            return i == 0;
        }
        public void remove()
        {
            throw new UnsupportedOperationException("Unsupported action");
        }
        public Item next()
        {
            if (hasNext())
                throw new NoSuchElementException("List is empty");
            shuff();
            return s[--i];
        }
    }


    public static void main(String[] args)
    {
        RandomizedQueue<String> d = new RandomizedQueue<>();
        d.enqueue("u");
        d.enqueue("c");
        d.enqueue("f");
        d.enqueue("k");
        Iterator<String> i = d.iterator();
        while (!i.hasNext())
            System.out.print(i.next() + " ");
        }
}
