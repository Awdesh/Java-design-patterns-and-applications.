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
import java.util.HashMap;

/**
 * An object that keeps track of head and tail node in the list.
 */
class NodeList
{
    int size;
    int currSize;
    Node head;
    Node tail;

    /**
     * A parametrized constructor to initialize.
     * @param size Initializes the size of list.
     */
    public NodeList(int size)
    {
        this.size = size;
        this.currSize = 0;
    }

    /**
     * This method will create new node inside the list.
     * @param value -: inserts a value inside the list.
     * @return -: A node object that's been inserted inside the list.
     */
    public Node insert(String value)
    {
        Node node = new Node(value);

        if (head == null)
        {
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
        else
        {
            tail = tail.getPrev();
            tail.setNext(null);
        }

        // inserts new node my making it new head.
        node.setNext(head);
        head.setPrev(node);
        head = node;

        return node;
    }

    /**
     * This method will update supplied node inside the list to be the new head.
     * @param node-: A node object that is accessed last and should now become head.
     */
    public void updateHead(Node node)
    {
        if (node == tail)
        {
            tail = tail.getPrev();
            tail.setNext(null);
        }

        // If passed node object is already head, no need to process further.
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

    /**
     * gets the tail node from the list.
     * @return A tail node object.
     */
    public Node getTail()
    {
        return tail;
    }
}

/**
 * A node class for linked list traversal.
 */
class Node
{
    private String value;
    private Node prev;
    private Node next;

    /**
     * A parametrized constructor.
     * @param value-: value to be initialized.
     */
    public  Node(String value)
    {
        this.value = value;
    }

    /**
     * Getter method to get the value of the node.
     * @return A String value.
     */
    public String getValue()
    {
        return value;
    }

    /**
     * Getter method to get the next node.
     * @return A Node object.
     */
    public Node getNext() {
        return next;
    }

    /**
     * Getter method to get the prev node.
     * @return A Node object.
     */
    public Node getPrev() {
        return prev;
    }

    /**
     * Setter method to set the next node.
     * @param next A node object to point to next.
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Setter method to set the previous node.
     * @param prev A node object to point to prev.
     */
    public void setPrev(Node prev) {
        this.prev = prev;
    }

    /**
     * Setter method to set the value.
     * @param value A value to set on the node.
     */
    public void setValue(String value) {
        this.value = value;
    }
}

/**
 * A Least recently cache class which inserts performs following operations.
 * Gets: Get value from the cache when key is supplied.
 * Sets: Sets the value corresponding to the key in cache.
 */
public class LRU
{
    // Maximum size cache can take.
    private final int MAX_SIZE;
    HashMap<String, Node> map = new HashMap<String, Node>();
    // A NodeList object to maintain values so as to update last accessed node.
    private NodeList itemList;

    private static final String NOTFOUND = "NOTFOUND";
    private static final String OK = "OK";
    private static final String GOT = "GOT";

    /**
     * A parametrized constructor.
     * @param size-: Size that cache should take.
     */
    public LRU(int size)
    {
        MAX_SIZE = size;
        itemList = new NodeList(size);
    }

    /**
     * Method gets the value corresponding to the key from cache.
     *
     * @param key-: A string key whose corresponding value needs to be retrieved.
     * @return-: A string. "NOTFOUND" if key is not present in the cache else return "GOT value".
     */
    public String get(String key)
    {
        Node node;

        if(!map.containsKey(key))
        {
            return NOTFOUND;
        }
        else
        {
            // key exists inside the map, make it a head.
            node = map.get(key);
            itemList.updateHead(node);
        }

        return GOT.concat(" ").concat(node.getValue());
    }

    /**
     * Inserts key and corresponding value inside cache.
     * @param key-: A String value representing key.
     * @param value-: A String value representing value.
     * @return A string value.
     */
    public String set(String key, String value){

        Node node;

        // map is already full, we'd need to replace the existing nodes.
        if (map.size() == MAX_SIZE)
        {
            // Find the least recently used and remove it.
            for(String iter: map.keySet())
            {
                // find the tail node from list and remove it from map.
                if(itemList.getTail().getValue().equals(map.get(iter).getValue())){
                    map.remove(iter);
                    break;
                }
            }

            // Since remove happened in above for loop, a new item can be inserted.
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
            }
            else
            {
                // either map is empty or doesn't contain key.
                itemList.insert(value);
                node = new Node(value);
            }
            map.put(key, node);
        }

        return OK;
    }
}