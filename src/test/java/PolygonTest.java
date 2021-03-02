import algorhytms.PolygonAlgo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolygonTest {
    private PolygonAlgo poly;
    private List<String> polys;
    @BeforeEach
    void setUp(){
        poly = new PolygonAlgo();
        polys = Arrays.asList(
                "36 30 36 30",
                "15 15 15 15",
                "46 96 90 100",
                "86 86 86 86",
                "100 200 100 200",
                "-100 200 -100 200");
    }

    @Test
    public void testPolyFunction(){
        assertEquals("2 2 2", poly.checkPolygonsTypes(polys));
    }
}
