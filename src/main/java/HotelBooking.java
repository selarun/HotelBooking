import java.util.Arrays;
import java.util.Comparator;

/**
 * check in  [2,5,8]
 * check out [3,6,10]
 *
 * 1 day min stay
 *
 *
 * check in  [2,5,8]
 * check out [3,9,11]
 *
 * 2  3
 *        5     9
 *            8    11
 *
 *   check in  [2,1,8]   -> [1,2,8]
 *   check out [3,9,11]  -> [9,3,11]
 *   1 - 9
 *
 *   1- 9
 *   3
 *   1 - 11
 *
 *     check in  [2,1,8,4]   -> [1,2,4,8]
 *     check out [3,9,11,6]  -> [9,3,6,11]
 *
 *     1 - 9
 *     checkin 1
 *     checkout 1
 *
 *     count 2
 *     checkin 2
 *     checkout 9
 *
 *     1-9 2
 *
 *   2  3
 *     1
 * step 1 - sort by checkout time
 *
 */
public class HotelBooking {


    // nlog n + n
    //O(1)
    public int numOfRooms(int [] checkins, int checkouts[]) {
        int noOfRooms = 0;

        if(checkins == null || checkins.length ==0) return noOfRooms;

        Integer index[] = new Integer[checkins.length];
        for(int i=0;i<checkins.length;i++) {
            index[i] = i;
        }
        Arrays.sort(index,(a,b) -> Integer.compare(checkins[a],checkins[b]));


        int prevCheckin = checkins[index[0]];
        int prevCheckout = checkouts[index[0]];

        noOfRooms = 1;
        for(int i=1;i<checkins.length;i++) {
            int currentCheckin = checkins[index[i]];
            int currentCheckout = checkouts[index[i]];
            if(currentCheckin < prevCheckout) {
                noOfRooms++;
            }
            prevCheckin  = currentCheckin;
            prevCheckout  = currentCheckout;
        }
        return noOfRooms;
    }
}
