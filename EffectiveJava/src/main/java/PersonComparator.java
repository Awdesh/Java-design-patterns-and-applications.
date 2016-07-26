import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by awdesh on 7/25/16.
 * Example taken from-: http://stackoverflow.com/documentation/java/3137/comparable-and-comparatort/10693/sorting-a-list-using-comparablet-or-a-comparatort#t=201607260123186403901
 *
 * If Person object doesn't want to have the load of having compareTo then this class would be important and
 * that's where Comparator interface comes in picture. In order to Comparator to work one must pass in collection to
 * sort and a comparator.
 */
public class PersonComparator implements Comparator<Person>{

    public int compare(Person p1, Person p2){
        if(p1.getLastName().compareTo(p2.getLastName()) != 0){
            return p1.getLastName().compareTo(p2.getLastName());
        } else {
            return p1.getFirstName().compareTo(p2.getFirstName());
        }
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("John", "Doe", 23));
        persons.add(new Person("Bob", "Dole", 33));
        persons.add(new Person("Ronald","McDonald", 45));
        persons.add(new Person("Alice","McDonald", 67));
        persons.add(new Person("Jill","Doe", 77));

        for(Person p : persons){
            System.out.print(p.getLastName());
            System.out.println();
        }

        // Since Person object implements Comparable interface thus
        // Collections.sort(persons); would work because there is a compareTo method that sort can work on.
        Collections.sort(persons, new PersonComparator());
        // If Person obj doesn't want to bear the load of compare
        System.out.print("***************\n");

        for(Person p : persons){
            System.out.print(p.getLastName());
            System.out.println();
        }
    }

}


