import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMapTest {
    private MyMap<String, String> myMap;

    @BeforeEach
    void setup() {
        myMap = new MyMap<>();
        myMap.put("ION", "ION");
        myMap.put("ALEX", "ION");
        myMap.put("IOAN", "ALEX");
    }

    @Test
    @DisplayName("Check unique")
    void testMyMap() {
        myMap.put("ALEX", "ION");
        assertNotNull(myMap);
        assertEquals(3, myMap.size());
        assertEquals("ION", myMap.get("ION"));
        assertEquals("ION", myMap.get("ALEX"));
        assertNotEquals("ALEX", myMap.get("ION"));
    }
}
