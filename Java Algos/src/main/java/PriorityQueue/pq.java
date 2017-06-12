package PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by awdesh on 8/15/16.
 */
public class pq {

    public static void main(String[] args) {
        Comparator<Character> comparator = new CharComparator();
        PriorityQueue<Character> prq = new PriorityQueue<Character>(10, comparator);
        prq.add('c');
        prq.add('h');
        prq.add('a');
        prq.add('q');

        while (prq.size() != 0){
            System.out.println(prq.remove());
        }
    }
}
