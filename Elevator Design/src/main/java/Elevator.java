/**
 * Created by AS025782 on 9/23/2015.
 */
public class Elevator extends ElevatorController
{
    private int currentFloor;
    public Elevator()
    {

    }

    public void moveUp()
    {
        // open door.
        // add request to queue.
        // move elevator.
        // stop elevator.
        // blink floor panel.
        // remove request from queue.
    }

    public void moveDown()
    {
        // open door.
        // add request to queue.
        // move elevator.
        // stop elevator.
        // blink floor panel.
        // remove request from queue.
    }

    public int getCurrentFloor()
    {
        return currentFloor;
    }

    public String getElevatorMovingDirection()
    {
        return Direction.DOWN.getValue();
    }

    public String getElevatorNextDirection()
    {
        return Direction.UP.getValue();
    }
}
