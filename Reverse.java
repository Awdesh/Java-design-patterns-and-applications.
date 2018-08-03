import java.util.*;
import java.lang.Object;

public class Reverse {

    public static void main(String[] args) {
        String s  = "This is a word";
        String[] arr = s.split(" ");

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            String temp = arr[end];
            arr[end --] = arr[start];
            arr[start ++] = temp;
        }
    }
}
