import java.util.Stack;

/**
 * Created by awdesh on 6/13/16.
 */
public class ReverseString {
    public String Reverse(String input){
        char[] chArr = input.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < chArr.length; i++){
            stack.push(chArr[i]);
        }

        StringBuffer sb = new StringBuffer();

        while(!stack.empty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        System.out.println(rs.Reverse("Awdesh"));
        System.out.println(rs.Reverse("Preps are back"));
    }
}
