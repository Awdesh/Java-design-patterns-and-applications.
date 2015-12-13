/**
 * Created by AS025782 on 8/3/2015.
 */
public class ShapeFactory
{
    public Shape getShape(String shapeType)
    {
        if(shapeType == null)
        {
            return null;
        }

        if(shapeType.equalsIgnoreCase("CIRCLE"))
        {
            return new Circle();
        }

        if(shapeType.equalsIgnoreCase("SQUARE"))
        {
            return new Square();
        }

        return null;
    }
}
