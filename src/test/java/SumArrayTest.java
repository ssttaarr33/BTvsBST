import algorhytms.SumArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumArrayTest {
    private SumArray sumArray;

    @BeforeEach
    void setup(){
        sumArray = new SumArray();
    }

    @Test
    public void testSum(){
        assertEquals(1, sumArray.checkArrayForSum(Arrays.asList(66,10,18,11,21,28,31,38,40,55,60,62)));
        assertEquals(0, sumArray.checkArrayForSum(Arrays.asList(66,10,18,10,21,28,31,3,40,55,60,62)));
    }
}
