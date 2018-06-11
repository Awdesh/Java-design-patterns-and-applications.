package Practice;

/**
 * Created by asd8a7 on 5/10/17.
 */
public class AddIntegers {
    public static void main (String[] args) {

        //code
        int res = Add(5,5);
        System.out.println(res);
    }

    public static int Add(int x, int y)
    {
        // Iterate till there is no carry
        while (y != 0)
        {
            // carry now contains common set bits of x and y
            int carry = x & y;

            // Sum of bits of x and y where at least one of the bits is not set
            x = x ^ y;

            // Carry is shifted by one so that adding it to x gives the required sum
            y = carry << 1;
        }
        return x;
    }

}

