import java.util.*;

/*
Java Collection framework provides many interfaces (Set, List, Queue, Deque etc.) and
classes (ArrayList, Vector, LinkedList, PriorityQueue, HashSet, LinkedHashSet, TreeSet etc).
 */
public class JavaDataStructures {

    public static void main(String[] args) {
        java.util.PriorityQueue q = new java.util.PriorityQueue();

        ArrayList<Integer> list = new ArrayList<Integer>();
        int val = 10;
        while (list.size() <= 5){
            list.add(val);
            val++;
        }

        q.addAll(list);

        while (!q.isEmpty())
        {
            System.out.println(q.poll());
        }

        q.addAll(list);
        System.out.println(q.poll());
        System.out.println("***************************");



        // Alternate to list when you need to store only unique strings.
        HashSet<String> set = new HashSet<String>();
        set.add("Apple");
        set.add("Banana");
        set.add("Apple");
        set.add("Mango");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("***************************");

        List<String> arrayList = new ArrayList<String>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Apple");
        arrayList.add("Mango");

        Iterator iteratorList = arrayList.listIterator();
        while (iteratorList.hasNext()){
            System.out.println(iteratorList.next());
        }
        System.out.println("***************************");
        // Default LinkedList is doubly linked list.
        List<Integer> linkedList = new java.util.LinkedList<Integer>();
        linkedList.add(5);
        linkedList.add(15);
        linkedList.add(25);

        Iterator itr = linkedList.listIterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println("***************************");


        // TreeMap and TreeSet are same as map and set except they maintain
        //  values in ascending order.
        TreeSet<String> ts = new TreeSet<String>();
        ts.add("phone");
        ts.add("cup");
        ts.add("mug");

        Iterator itr1 = ts.iterator();
        while (itr1.hasNext()){
            System.out.println(itr1.next());
        }
    }
}


