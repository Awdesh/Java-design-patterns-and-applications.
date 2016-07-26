package Comparable;

import java.util.*;

/**
 * Created by awdesh on 7/25/16.
 */
public class Person implements Comparable<Person>{

    private final String firstName;

    private final String lastName;

    private final int age;

    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getAge(){
        return age;
    }

    public String toString(){
        return firstName + ' ' + lastName;
    }

    public int compareTo(Person obj){
        Person p1 = obj;
        if(p1.lastName.compareTo(this.lastName) != 0){
            return p1.lastName.compareTo(this.lastName);
        } else {
            return p1.firstName.compareTo(this.firstName);
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

        Collections.sort(persons);
        System.out.print("***************\n");

        for(Person p : persons){
            System.out.print(p.getLastName());
            System.out.println();
        }

        int[] sampleArr = new int[5];
        sampleArr[0] = 4;
        sampleArr[1] = 2;
        sampleArr[2] = 8;
        sampleArr[3] = 10;
        sampleArr[4] = 6;

        for(int i : sampleArr){
            System.out.print(i);
        }

        Arrays.sort(sampleArr);

        System.out.print("\nafter sort\n");

        for(int i : sampleArr){
            System.out.print(i);
        }

    }


}
