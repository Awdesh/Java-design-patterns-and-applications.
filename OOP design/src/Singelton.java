/**
 * Created by AS025782 on 8/3/2015.
 */
public class Singelton
{
    private static Singelton instance = new Singelton();

    private Singelton()
    {

    }

    // Imp: Remember to have below static.
    public static Singelton getInstance()
    {
        return instance;
    }


    public void callSample()
    {
        System.out.println("singleton instance called from main");
    }
}
