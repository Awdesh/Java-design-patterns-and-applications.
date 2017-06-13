/**
 * Created by awdesh on 8/15/16.
 */
public class StackFromArray {

    private int index = 0;
    private int[] arr = new int[10];
    private static int[] stackArr = new int[10];
    public StackFromArray(int[] arr){
        this.arr = arr;
    }

    public void push(int item){
        stackArr[index] = item;
        index++;
    }

    public int pop(){
        if(stackArr.length > 0)
            return stackArr[--index];
        else
            return Integer.MIN_VALUE;
    }

    public int peek(){
        int i = index;
        return stackArr[--i];
    }

    public int count(){
        return index;
    }

    public static void main(String[] args) {
        int[] ip = new int[10];
        ip[0] = 1;
        ip[1] = 2;
        ip[2] = 3;
        ip[3] = 4;
        ip[4] = 5;
        ip[5] = 6;
        ip[6] = 7;
        ip[7] = 8;
        StackFromArray s = new StackFromArray(ip);
        s.push(ip[0]);
        s.push(ip[2]);
        s.push(ip[3]);
        System.out.println(s.count());

        System.out.println("Peeking item from array now-:" + s.peek());

        System.out.println("First item is-:" + s.pop());
        System.out.println("Second item is-:" + s.pop());
        System.out.println("Count is-:" + s.count());

        System.out.println("Peeking item from array now-:" + s.peek());
    }
}
