/**
 * Abstraction & Encapsulation.
 * Created by awdesh on 8/26/15.
 */
public abstract class VanElements {

    private static String color = "";
    private static String make = "";
    private static String model = "";
    private static int year;
    private static int speed;

    public int getSpeed() {
        return speed;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public void setColor(String color) {
        VanElements.color = color;
    }

    public void setMake(String make) {
        VanElements.make = make;
    }

    public void setModel(String model) {
        VanElements.model = model;
    }

    public void setSpeed(int speed) {
        VanElements.speed = speed;
    }

    public void setYear(int year) {
        VanElements.year = year;
    }

    public void print()
    {
        System.out.printf("Make %s\n"
                + "Model: %s\n"
                + "Year: %d\n"
                + "Color: %s\n"
                + "Top Speed: %d mph\n",
                make,model,year,color,speed) ;
    }
}
