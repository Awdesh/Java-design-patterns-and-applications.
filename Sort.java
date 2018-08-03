import java.util.*;
import java.lang.Object;

public class Sort {

    public static void main(String[] args) {
    
        List<String> list = Arrays.asList(args);
        System.out.println(list.getClass());
        // list.add("a");
        System.out.println(list.size());

        Collections.sort(list);
        System.out.println(list);
       
        List<String> ll = new ArrayList<>();
        System.out.println(ll.getClass());

        ll.add("a");
        ll.add("z");
        ll.add("c");

        Collections.sort(ll);
        System.out.println(ll.toArray().length);
        Object[] str = ll.toArray();
        System.out.println(str);
        System.out.println(ll);
    }
}