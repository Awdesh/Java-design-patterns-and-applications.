import java.util.Comparator;

/**
 * Created by awdesh on 8/15/16.
 */
public class CharComparator implements Comparator<Character>{

   @Override
    public int compare(Character a, Character b){
        if(a > b){
            return 1;
        } if(a < b) {
            return -1;
        }
        return 0;
    }
}
