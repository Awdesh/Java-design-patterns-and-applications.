/**
 * Created by awdesh on 8/26/15.
 */
public class Van extends VanElements
{
    public static void main(String[] args) {
        VanElements vanElements = new Van();
        vanElements.setColor("White");
        vanElements.setMake("Dodge");
        vanElements.setModel("RAM");
        vanElements.setSpeed(100);
        vanElements.setYear(2010);
        vanElements.print();

        // getters in abstract class exposes private member variables, which is encapsulation.
        vanElements.getColor();
    }
}
