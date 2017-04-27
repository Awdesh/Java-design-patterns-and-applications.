/**
 * Created by awdesh on 4/26/17.
 */

/**
 * A Node class.
 */
class LinkedNode{
    int val;
    LinkedNode next;

    public LinkedNode(int val){
        this.val = val;
    }
}

/**
 * LinkedHashMap class
 * In worst case scenario search is-: O(n)
 */
public class LinkedHashMap
{
    LinkedNode[] array;

    public LinkedHashMap(int count){
        array = new LinkedNode[count];
    }

    // Inserting an item inside hash table.
    public void insert(int item){
        int index = calculateIndex(getHashCode(item));
        LinkedNode temp;
        if (array[index] != null) {
            temp = array[index];
            while (temp != null && temp.next != null) {
                temp = temp.next;
            }
            LinkedNode newNode = new LinkedNode(item);
            temp.next = newNode;
            array[index] = temp;
            return;
        } else{
            LinkedNode ln = new LinkedNode(item);
            array[index] = ln;
        }
    }

    // retrieves an index based on the hash code.
    private int calculateIndex(int hashCode){
        return hashCode % array.length;
    }

    // calculates hash code from an integer.
    private int getHashCode(int item){
        int c = (int)(item * (item >>> 32));
        // 37 is the prime number we've used.
        int hashCode =  37 * 3 + c;
        return hashCode;
    }

    public void print(){
        for (int i=0; i <array.length; i++){
            if(array[i] != null){
                System.out.println(array[i].val);
            }
        }
}

    public static void main(String[] args) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(10);
        linkedHashMap.insert(12);
        linkedHashMap.insert(13);
        linkedHashMap.insert(14);
        linkedHashMap.insert(15);
        linkedHashMap.insert(16);
        linkedHashMap.insert(17);

        System.out.println("**************");
        linkedHashMap.print();
    }
}


