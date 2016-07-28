package InheritanceVsComposition;

/**
 * Created by awdesh on 7/25/16.
 */
public class Client{
    ExendingPersonClass person = new ExendingPersonClass("John", 25, "male", "Student");

    CompositionPersonClass cPerson = new CompositionPersonClass(person);

}
