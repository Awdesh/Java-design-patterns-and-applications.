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

package Practice;

import java.util.Hashtable;
import java.util.Scanner;

/*

 */
class CacheNode
{
    String value;

    CacheNode prev;
    CacheNode next;

    CacheNode head;
    CacheNode tail;

    /*

     */
    public CacheNode(String value)
    {
        this.value = value;
        head = new CacheNode(value);
        head.next = null;
        this.prev = null;
    }

    public void insert(String value)
    {
        CacheNode node = head;
        while (node.next != null)
        {

        }

    }

}

/*

 */
public class LRU
{
    private final int MAX_SIZE;
    Hashtable<String, String> map = new Hashtable<String, String>();
    CacheNode head = null;
    CacheNode end = null;

    /*

     */
    public LRU(int size)
    {
        MAX_SIZE = size;
    }

    /*

     */
    public int getSize()
    {
        return MAX_SIZE;
    }

    /*

     */
    public String get(String key){

//        if(map.size() <= 0){
//            return "ERROR";
//        }

        if(!map.containsKey(key)){
            return "NOTFOUND";
        }

        return "";
    }

    /*

     */
    public String set(String key, String value){

        if (map.size() == 3)
        {
            // Find the last recently used and replace it.
            map.put(key, value);
        }



        return "";
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

        while (true){
            cmdString = scanner.next();

            // getting value from key.
            if(cmdString.equals("GET"))
            {
                String keyItemString = scanner.next();

                if(cache.getSize() == myInt)
                {
                    //cache is full, remove tail node and add
                    // new node in the beginning.

                }
                String retItem = cache.get(keyItemString);
                System.out.println(retItem);
            }

            // Setting key and value.
            else if(cmdString.equals("SET")){
                String keyItemString = scanner.next();
                String valItemString = scanner.next();
                cache.set(keyItemString, valItemString);
                System.out.println("SET OK");
            }

            // Exits the program if user enters "EXIT".
            else if(cmdString.equals("EXIT")){
                scanner.close();
                break;
            }
        }

    }
}




