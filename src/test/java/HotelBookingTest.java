import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class HotelBookingTest {
    HotelBooking hotelBooking = new HotelBooking();

    /**
     *        check in  [2,1,8,4]   ->        [1,2,4,8]
     *  *     check out [3,9,11,6]  -> [9,3,6,11]
     *
     *  * check in  [2,5,8]
     *  * check out [3,6,10]
     */
    @Test
    public void testBasic() {
        Assertions.assertEquals(0,hotelBooking.numOfRooms(new int[]{},new int[] {}));
        Assertions.assertEquals(1,hotelBooking.numOfRooms(new int[]{2},new int[] {3}));
        Assertions.assertEquals(1,hotelBooking.numOfRooms(new int[]{2,5,8},new int[] {3,6,10}));
        Assertions.assertEquals(2,hotelBooking.numOfRooms(new int[]{2,1,8,4},new int[] {3,9,11,6}));
        Assertions.assertEquals(2,hotelBooking.numOfRooms(new int[]{2,1,8,4,6},new int[] {3,9,11,5,7}));
    }
}
