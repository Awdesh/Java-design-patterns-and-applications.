/**
 * Polymorphism, since we using multiple inheritance here.
 * Created by awdesh on 8/26/15.
 */
public class Truck extends Car implements Drive, Weight {

    public float tonnage = 0;
    public void tonnage()
    {
        this.tonnage = 5000;
        System.out.printf("tonnage: %.2f", tonnage);
    }

    public void speed()
    {
        finalSpeed = 140;
    }

    @Override
    public void color()
    {
        finalColor = "white";
    }

    @Override
    public void model()
    {
        finalModel = "Nissan";
    }

    public static void main(String[] args) {
        // car extension will have access to both car class's and truck's method.
        // but whenever extension occurred we use parent class first. e.g. parent obj = new child();
        Car carExtension = new Truck();
        // truck will only have access to truck's methods.
        Truck truck = new Truck();

        carExtension.color();
        carExtension.model();
        carExtension.speed();
        carExtension.print(finalMake,finalModel,finalYear,finalColor,finalSpeed);

        truck.tonnage();
    }
}
