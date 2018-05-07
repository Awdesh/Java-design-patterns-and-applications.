package Sorting;

import java.util.Comparator;

/**
 * Created by awdesh on 10/24/15.
 */
public class CarSorting implements Comparable
{
    private String make;

    private int mileage;

    /**
     * Default paramterized constructor.
     * @param make
     * @param mileage
     */
    public CarSorting(String make, int mileage)
    {
        this.make = make;
        this.mileage = mileage;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof CarSorting)
        {
            CarSorting car = (CarSorting) o;
            if(this.mileage > car.getMileage())
            {
                return 1;
            }

            else if(this.mileage < car.getMileage())
            {
                return -1;
            }
        }
        return 0;
    }

    public String toString()
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Make" + make + ",Mileage" + mileage);
        return buffer.toString();
    }
}

/**
 * Comparator is better than comparable since we are not
 * bound to compareTo implementation and one can directly pass into
 * functors
 */
class comp1 implements Comparator<String>
{
    @Override
    public int compare(String o1, String o2) {
        return o1.compareToIgnoreCase(o2);
    }
}

class comp2 implements Comparator<String>
{
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}

class comp3 implements Comparator<String>
{
    @Override
    public int compare(String o1, String o2)
    {
        String str1 = o1.substring(o1.indexOf("@"));
        String str2 = o2.substring(o2.indexOf("@"));
        return str1.compareToIgnoreCase(str2);
    }
}
