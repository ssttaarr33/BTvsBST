import algorhytms.PlaneReservationSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaneReservationSystemTest {

    @Test
    public void testPlaneReservation(){
        assertEquals(2, PlaneReservationSystem.solution(2,"1a, 2f 1c"));
        assertEquals(3, PlaneReservationSystem.solution(2,"1a, 2f"));
        assertEquals(2, PlaneReservationSystem.solution(1,""));
    }
}
