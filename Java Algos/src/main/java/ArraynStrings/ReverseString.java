package ArraynStrings;

import java.util.Stack;

/**
 * Created by awdesh on 7/27/16.
 */
public class ReverseString {

    public static String Reverse(String input)
    {
        if(input.length() <= 0)
            return null;

        if(input.length() == 1)
            return input;

        int len = input.length();
        char[] inputArr = input.toCharArray();
        int i = 0;
        int j = len - 1;

        while(i <= j)
        {
            char temp = inputArr[i];
            inputArr[i] = inputArr[j];
            inputArr[j] = temp;
            i++;
            j--;
        }

        String reversedString = new String(inputArr);
        return reversedString;
    }

    public static String ReverseWordsInString(String input)
    {
        boolean space = false;
        char[] inputArr = input.toCharArray();
        if(inputArr[0] == ' ')
            space = true;
        String[] words = input.split(" ");
        Stack<String> coll = new Stack<String>();
        for(String word : words){
            coll.push(word);

    }

        StringBuffer sb = new StringBuffer();
        if(space)
            sb.append(" ");

        while(!coll.empty()){
            sb.append(coll.pop());
            sb.append(" ");
    }

        return sb.toString();
    }


    public static void main(String[] args) {
        String op = ReverseString.Reverse("This is the test string!");
        System.out.print(op);
        System.out.println();

        String op1 = ReverseString.ReverseWordsInString(" This is the test string");
        System.out.print(op1);
        System.out.println();


        String op2 = ReverseString.ReverseWordsInString("This is the test string");
        System.out.print(op2);
        System.out.println();

        String op3 = ReverseString.ReverseWordsInString("This is the test string ");
        System.out.print(op3);
        System.out.println();

    }

}
