package InheritanceVsComposition;

/**
 * Created by awdesh on 7/26/16.
 */
public class CompositionPersonClass {

    private String occupation;

    public CompositionPersonClass(AbstractPerson person){
        this.occupation = person.getOccupation();
    }

    public String getOccupation(){
        return occupation;
    }

    public int demo(){
        return 1;
    }
}
