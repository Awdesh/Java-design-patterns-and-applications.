package Dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by awdesh on 11/8/15.
 */
public class SlidingWindowMax
{
    public static void maxSlidingWindow(int[] A, int n, int w, int[] B)
    {
        Deque<Integer> Q = new ArrayDeque<Integer>();
        // Initialize deque Q for first window
        for (int i = 0; i < w; i++)
        {
            //check if new element is greater than the last element in the queue.
            while (!Q.isEmpty() && A[i] >= A[Q.getLast()])
            {
                Q.pollLast();
            }
            Q.offerLast(i);
        }
        for (int i = w; i < n; i++)
        {
            int idx = Q.getFirst();
            B[i - w] = A[idx];
            // update Q for new window
            while (!Q.isEmpty() && A[i] >= A[Q.getLast()])
            Q.pollLast();
            // Pop older element outside window from Q
            while (!Q.isEmpty() && Q.getFirst() <= i - w)
            Q.pollFirst();

            // Insert current element in Q
            Q.offerLast(i);
        }
        B[n - w] = A[Q.getFirst()];
    }

    public static void main(String[] args)
    {
        int w = 3;
        int a[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int b[] = new int[a.length - w + 1];
        maxSlidingWindow(a, a.length, w, b);
        System.out.println("Sliding Window Maximum is ");
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + ",");
        }

    }
}
