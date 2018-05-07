package Practice;

/**
 * Created by awdesh on 7/5/15.
 */
public class fibonacci
{
    public int CreateSeries(int num)
    {
        if(num <= 0){
            return 1;
        }

        if(num == 1 || num == 2)
        {
            return 1;
        }

        return CreateSeries(num-1) + CreateSeries(num-2);
    }

    public static void main(String[] args) {
        fibonacci fib = new fibonacci();
        int x = fib.CreateSeries(8);
        System.out.println(x);
    }
}
