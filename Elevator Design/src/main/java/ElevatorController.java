import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by AS025782 on 9/23/2015.
 */
public class ElevatorController
{
    protected Queue requests = new LinkedList();

    /**
     *
     * @param req
     */
    protected void startElevator(int req)
    {

    }

    private Elevator elevator = null;

    public ElevatorController()
    {
        elevator = new Elevator();
    }

    public ElevatorController(Requests req)

    {
        requests.add(req);
    }

    protected void startElevator()
    {

    }

    protected void shutDownElevator()
    {

    }
}


