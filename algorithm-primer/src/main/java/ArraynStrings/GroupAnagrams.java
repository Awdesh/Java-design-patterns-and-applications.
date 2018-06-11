package ArraynStrings;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(List<String> ip){

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s : ip){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);

            String key = String.valueOf(ch);
            if(!map.containsKey(key))
                map.put(key, new ArrayList(Arrays.asList(s)));
            else
                map.get(key).add(s);
        }

        return new ArrayList(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        List<String> ll = new ArrayList<String>();

        ll.add("melon");
        ll.add("lemon");
        ll.add("break");
        ll.add("brake");
        ll.add("finder");
        ll.add("friend");

        List<List<String>> op =  ga.groupAnagrams(ll);

        for(List<String> l : op){
            System.out.print(l);
        }
    }
}


