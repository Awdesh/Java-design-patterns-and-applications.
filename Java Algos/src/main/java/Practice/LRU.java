//* A short README (or similar) that evaluates the runtime complexity of your algorithm, how to build the program (if needed), how to run the program,
// any known issues, limitations, assumptions, and any other details needed.
//        * The source code you have written.
//
//        Solutions to the problem below exist on the internet, but we are going to ask you to pretend that they don't.
//        While we don't mind if you use the internet as you normally would to solve a previously unsolved problem (refreshing yourself general knowledge on syntax, libraries, etc),
//        you should not look at cache algorithms and implementations and things of that sort. We trust that you will follow the spirit of this.
//        We are interested in your approach and style, not someone else's. It's more important that it be your own than it be optimal or perfect.
//        Finally, all of the code you supply for this exercise must be your own written from scratch for obvious reasons.  Feel free to use standard language libraries.
//
//        With all of that out of the way, the question:
//        Design and implement an LRU (Least Recently Used) cache. This is a cache with fixed size in terms of the number of items it holds (supplied at instantiation).
//        For this exercise, we won’t worry about the number of bytes. Your program can treat the keys and values as strings.  You don’t need to support keys or values that contain spaces.
//        The cache must allow client code to get items from the cache and set items to the cache. Once the cache is full, when the client wants to store a new item in the cache, an old item must be overwritten or
//        removed to make room. The item we will remove is the Least Recently Used (LRU) item.  Note that your cache does not need persistence across sessions.
//
//        Please read input from stdin and print output to stdout and support the following format (please DO NOT print any kind of a prompt or extra line breaks).
//        All inputs and outputs exist on their own line:
//
//        The first input line should set the max number of items for the cache using the keyword SIZE.  The program should respond with ‘SIZE OK’. This must only occur as the first operation.
//
//        Set items with a line giving the key and value, separated by a space,
//        your program should respond with 'SET OK'.
//
//        Get items with a line giving the key requested, your program should respond with the previously stored value, for example “GOT foo”. If the the key is not in the cache,
//        it should reply with “NOTFOUND”.
//
//        ‘EXIT’ should cause your program to exit.
//
//        If the input is invalid, your program should respond with ‘ERROR’
//
//        Sample Input
//        SIZE 3
//        GET foo
//        SET foo 1
//        GET foo
//        SET foo 1.1
//        GET foo
//        SET spam 2
//        GET spam
//        SET ham third
//        SET parrot four
//        GET foo
//        GET spam
//        GET ham
//        GET ham parrot
//        GET parrot
//        EXIT
//
//        Expected Output
//        SIZE OK
//        NOTFOUND
//        SET OK
//        GOT 1
//        SET OK
//        GOT 1.1
//        SET OK
//        GOT 2
//        SET OK
//        SET OK
//        NOTFOUND
//        GOT 2
//        GOT third
//        ERROR
//        GOT four


/*
Solution-:

1.) If list contains a key move value to the head i.e. recently visited.
2.) If list doesn't contain a key and list is not full, add the new key make it head and update the tail.
3.) If list is full, remove least recently used i.e. tail value from the list. Add the new key and update the head.
4.) Hash Map which will contain keys as a string and values corresponding to keys are in a linked list.
*/

package Practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

/*

 */
class NodeList
{
    int size;
    int currSize;
    Node head;
    Node tail;

    /*

     */
    public NodeList(int size)
    {
        this.size = size;
        this.currSize = 0;
    }

    /*
    This method will create new node inside the list.
     */
    public Node insert(String value)
    {
        Node node = new Node(value);

        if (head == null){
            head = node;
            tail = node;
            currSize = 1;
            return node;
        }
        else if(currSize < size)
        {
            currSize += 1;
        }
        // size of the list is equal to maximum size possible thus remove the tail node (least recently used node)
        else{
            tail = tail.getPrev();
            tail.setNext(null);
        }

        node.setNext(head);
        head.setPrev(node);
        head = node;

        return node;
    }

    /*
     This method will update supplied node inside the list to be the new head.
     */
    public void updateHead(Node node)
    {
        if (node == tail)
        {
            tail = tail.getPrev();
            tail.setNext(null);
        }

        // no need to update head.
        if ( node == null || node.equals(head))
        {
            return;
        }

        Node prev = node.getPrev();
        Node next = node.getNext();
        if (prev == null)
        {
            head.setValue(node.getValue());
            return;
        }
        prev.setNext(next);

        if (next != null)
        {
            next.setPrev(prev);
        }

        node.setPrev(null);
        node.setNext(head);

        head.setPrev(node);
        head = node;
    }

    public Node getTail() {
        return tail;
    }
}

/*
A node class for linked list traversal.
 */

class Node
{
    private String value;
    private Node prev;
    private Node next;

    public  Node(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

/*

 */
public class LRU
{
    private final int MAX_SIZE;
    HashMap<String, Node> map = new HashMap<String, Node>();
    private NodeList itemList;

    /*

     */
    public LRU(int size)
    {
        MAX_SIZE = size;
        itemList = new NodeList(size);
    }

    /*

     */
    public String get(String key){

        Node node;

        if(!map.containsKey(key)){
            return "NOTFOUND";
        } else {
            // key exists inside the map, make it a head.
            node = map.get(key);
            itemList.updateHead(node);
        }

        return "GOT " + node.getValue();
    }

    /*

     */
    public String set(String key, String value){

        Node node;

        // map is already full, we'd need to replace the existing nodes.
        if (map.size() == MAX_SIZE)
        {
            // Find the last recently used and replace it.
            String s = itemList.getTail().getValue();
            for(String iter: map.keySet())
            {
                String ss = map.get(iter).getValue();
                if(ss == s){
                    map.remove(iter);
                    break;
                }
            }
            itemList.insert(value);
            node = new Node(value);
            map.put(key, node);
        }
        else
        {
            if(map.containsKey(key))
            {
                node = map.get(key);
                node.setValue(value);
                // make this new node as head of the NodeList.
                itemList.updateHead(node);
            } else { // either map is empty or doesn't contain key.
                itemList.insert(value);
                node = new Node(value);
            }
            map.put(key, node);
        }

        return "OK";
    }
}


/*

 */
class client
{
    public static void main(String[] args) {
        LRU cache = null;
        Scanner scanner = new Scanner(System.in);
        String cmdString = scanner.next();
        int myInt = scanner.nextInt();
        if (cmdString.equals("SIZE"))
        {
            cache = new LRU(myInt);
            System.out.println("SIZE OK");
        }

        try {
            while (true) {
//                cmdString = scanner.next();
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String ip = br.readLine();
                String[] ips = ip.split(" ");

                // getting value from key.
                if (ip.contains("GET")) {
                    if (ips.length > 2)
                    {
                        System.out.println("ERROR");
                        continue;
                    }
                    String retItem = cache.get(ips[1]);
                    System.out.println(retItem);
                }

                // Setting key and value.
                else if (ip.contains("SET")) {
                    if (ips.length < 3)
                    {
                        System.out.println("ERROR");
                        continue;
                    }
                    cache.set(ips[1], ips[2]);
                    System.out.println("SET OK");
                }

                // Exits the program if user enters "EXIT".
                else if (ip.contains("EXIT")) {
                    break;
                }
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }
}




