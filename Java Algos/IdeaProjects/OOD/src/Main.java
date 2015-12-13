/**
 * Created by awdesh on 4/15/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Child1 obj = new Child1();
        obj.roar();
        obj.run();

        System.out.println();

        Child2 obj2 = new Child2();
        obj2.roar();
        obj2.run();

    }
}
