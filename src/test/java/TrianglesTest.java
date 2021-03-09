import algorhytms.Triangles;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrianglesTest {
    @Test
    public void testTriangles() {
        assertEquals(2, Triangles.triangle(3, 5, 4));
        assertEquals(1, Triangles.triangle(3, 3, 3));
        assertEquals(0, Triangles.triangle(-1, 2, 3));
    }
}
