package Trie;


/*
Example from GeeksForGeeks.
https://www.geeksforgeeks.org/trie-insert-and-search/
 */
public class Implementation {

    static final int SIZE = 26;

    static class TrieNode {
        TrieNode[] children = new TrieNode[SIZE];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < SIZE; i++) {
                children[i] = null;
            }
        }
    }

    static TrieNode root;

    /*
    Inserting is very straight forward.

    i.) have a runner node that will start from root node.
    ii.) check if runner doesn't have any children at the index and populate it.
    iii.) update runner with the new children for next iteration.
    iv. ) Once iteration is complete that means key has been added successfully thus mark isEndOfWord to True.
     */
    static TrieNode insert(String key)
    {
        int level;
        int length = key.length();
        int index;

        TrieNode runner = root;
        for(level = 0; level < length; level++){
            //below will give you unique value for distinct alphabets.
            index = key.charAt(level) - 'a';
            if(runner.children[index] == null)
                runner.children[index] = new TrieNode();

            runner = runner.children[index];
        }

        runner.isEndOfWord = true;

        // Insert operation normally doesn't return, this is just for debugging.
        return root;
    }

    /*
    O(M) Time: M is length of the key to be searched.
     */
    static boolean search(String key)
    {
        int level;
        int length = key.length();
        int index;
        TrieNode runner = root;

        for(level = 0; level < length; level++)
        {
            //index below will be alphabet's position.
            index = key.charAt(level) - 'a';
            if(runner.children[index] == null){
                // Trie is empty.
                return false;
            }
            runner = runner.children[index];
        }

        return (runner != null && runner.isEndOfWord);
    }

    public static void main(String args[])
    {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};


        root = new TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
            root = insert(keys[i]);

        // Search for different keys
        if(search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);
//
//        if(search("these") == true)
//            System.out.println("these --- " + output[1]);
//        else System.out.println("these --- " + output[0]);
//
//        if(search("their") == true)
//            System.out.println("their --- " + output[1]);
//        else System.out.println("their --- " + output[0]);
//
//        if(search("thaw") == true)
//            System.out.println("thaw --- " + output[1]);
//        else System.out.println("thaw --- " + output[0]);

    }


}
