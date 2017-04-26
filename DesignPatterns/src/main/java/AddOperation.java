/**
 * Created by awdesh on 10/8/15.
 */
public class AddOperation implements Strategy
{
    @Override
    public int perform(int num1, int num2)
    {
        return num1 + num2;
    }
}
