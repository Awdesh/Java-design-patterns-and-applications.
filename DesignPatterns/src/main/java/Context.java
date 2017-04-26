/**
 * Created by awdesh on 10/8/15.
 */
public class Context
{
    private Strategy strategy;

    public Context(Strategy strategy)
    {
        this.strategy = strategy;
    }

    /*
        Based on strategy context uses, respective perform methods been called.
     */
    public int executeStrategy(int num1, int num2)
    {
        return strategy.perform(num1, num2);
    }
}
