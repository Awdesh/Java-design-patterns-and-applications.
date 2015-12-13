import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import sun.util.logging.resources.logging;

/**
 * Created by awdesh on 4/15/15.
 */
public class Child2 extends Animal {

    @Override
    public void run()
    {
        System.out.println("run from child2 is called");
    }

    @Override
    public void roar()
    {
        System.out.println("roar from child2 is called");
    }

    @Override
    public void fly()
    {
        throw new NotImplementedException();
    }

}
