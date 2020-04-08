/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;

public class Permutation
{

    public static void main(String[] args)
    {
        RandomizedQueue<String> rn = new RandomizedQueue<String>();
        int n = Integer.parseInt(args[0]);
        int i = 0;
        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            rn.enqueue(s);
        }



        while (i < n) {
            System.out.println(rn.dequeue());
            i++;
        }
    }
}
