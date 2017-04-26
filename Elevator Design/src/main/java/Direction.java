/**
 * Created by AS025782 on 9/28/2015.
 */
public enum Direction
{
    UP("up"),
    DOWN("down");

    private String value;

    /**
     *
     * @return
     */
    public String getValue() {
        return value;
    }

    /**
     *
     * @param value
     */
    Direction(String value)
    {
        this.value = value;
    }
}
