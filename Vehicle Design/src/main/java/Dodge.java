/**
 * Created by awdesh on 8/26/15.
 */
public class Dodge extends Car
{
    public Dodge()
    {
        finalMake = "Dodge";
        finalYear = 2015;
    }

    @Override
    public void speed()
    {
        finalSpeed = 240;
    }

    @Override
    public void color()
    {
        finalColor = "red";
    }

    @Override
    public void model()
    {
        finalModel = "Challenger";
    }

    public static void main(String[] args) {
        // Car is the parent class, always put parent first if we extending.
        Car dodge = new Dodge();
        dodge.speed();
        dodge.color();
        dodge.model();
        dodge.print(finalMake, finalModel, finalYear, finalColor, finalSpeed);
    }
}
