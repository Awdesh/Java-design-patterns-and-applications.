/**
 * Created by awdesh on 8/26/15.
 */
public class Car implements Drive
{
    protected static String finalColor = "";
    protected static String finalMake = "";
    protected static String finalModel = "";
    protected static int finalYear;
    protected static int finalSpeed;

    public Car()
    {
        finalMake = "Ford";
        finalYear = 2014;
    }

    public static void main(String[] args)
    {
        Car car = new Car();
        car.speed();
        car.color();
        car.model();
        car.print(finalMake, finalModel, finalYear, finalColor, finalSpeed);
    }

    public void speed()
    {
        finalSpeed = 260;
    }

    public void color()
    {
        finalColor = "Blue";
    }

    public void model()
    {
        finalModel = "Mustang";
    }

    public void print(String make, String model, int year, String color, int topSpeed)
    {
        System.out.printf("Make %s\n"
                   + "Model: %s\n"
                   + "Year: %d\n"
                   + "Color: %s\n"
                   + "Top Speed: %d mph\n",
                make,model,year,color,topSpeed) ;
    }
}
