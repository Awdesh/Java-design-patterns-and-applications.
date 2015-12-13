/**
 * Created by AS025782 on 8/3/2015.
 */
public class DesignPatternDemo
{
    public static void main(String[] args)
    {
        ShapeFactory shapeFactory = new ShapeFactory();

        //get an object of Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        //call draw method of Circle
        shape1.draw();

        //get an object of Rectangle and call its draw method.
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        if(shape2!=null)
            //call draw method of Rectangle
            shape2.draw();

        //get an object of Square and call its draw method.
        Shape shape3 = shapeFactory.getShape("SQUARE");

        //call draw method of circle
        shape3.draw();


        Singelton obj = Singelton.getInstance();
        obj.callSample();
    }
}
