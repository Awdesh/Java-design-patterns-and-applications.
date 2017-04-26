package InheritanceVsComposition;

/**
 * Created by awdesh on 7/25/16.
 */
public class ExendingPersonClass extends AbstractPerson {

    private final String name;

    private final int age;

    private final String gender;

    private final String occupation;

    public ExendingPersonClass(String name, int age, String gender, String occupation){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getOccupation() {
        return occupation;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void demo() {

    }
}
