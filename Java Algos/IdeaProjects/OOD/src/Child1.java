/**
 * Created by awdesh on 4/15/15.
 */
public class Child1 extends Birds {

    @Override
    public void run()
    {
        System.out.println("run from child1 is called");
    }

    @Override
    public void roar()
    {
        System.out.println("roar from child 1 is called");
    }

    @Override
    public void fly()
    {
        System.out.println("fly from child 1 is called");
    }

    @Override
    public void flyHigh() {
        System.out.println("fly high from child1 is called.");
    }
}
