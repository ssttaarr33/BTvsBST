import algorhytms.DeltaEncoding;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DeltaEncodingTest {
    private DeltaEncoding deltaEncoding;
    private List<Integer> numbers;

    @BeforeEach
    void setup(){
        deltaEncoding = new DeltaEncoding();
        numbers = Arrays.asList(25626, 25757, 24367, 24267, 16, 100, 2, 7277);
    }

    @Test
    void testDeltaDecode(){
        List<Integer> expected = deltaEncoding.deltaEncode(numbers);
        assertEquals(Arrays.asList(25626,-128, 131, -128, -1390, -100, -128, -24251, 84, -98, -128, 7275),
                expected);
    }
}
