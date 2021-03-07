import algorhytms.ArrayRotate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayRotateTest {

    @Test
    public void testRotate() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(5, ArrayRotate.rotLeft(array, 4)[0]);
    }
}
