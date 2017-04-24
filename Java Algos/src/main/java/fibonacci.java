import java.util.HashMap;
import java.util.Map;

/**
 * Created by awdesh on 7/5/15.
 */
public class fibonacci
{
    public int CreateSeries(int num)
    {
        if(num == 1 || num == 2)
        {
            return 1;
        }

        return CreateSeries(num-1) + CreateSeries(num-2);
    }

    public String firstRepeatedWord(String s)
    {
        Map<String, Integer> map = new HashMap<String, Integer>();

        final String EMPTY_STRING = "";

        for(String str : s.split(" "))
        {
            if(map.get(str) == null)
            {
                map.put(str, 1);
            }
            else
            {
                map.put(str, map.get(str) + 1);
            }
        }

        for(Map.Entry<String, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > 1)
            {
                return entry.getKey();
            }
        }

        return EMPTY_STRING;
    }
}
