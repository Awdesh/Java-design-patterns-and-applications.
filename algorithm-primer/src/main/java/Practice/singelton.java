package Practice;

public class singelton {
    private static singelton ourInstance = new singelton();

    public static singelton getInstance() {
        return ourInstance;
    }

    private singelton() {
    }
}
