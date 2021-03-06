import algorhytms.OrderNames;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderNamesTest {

    private OrderNames orderNames;

    @BeforeEach
    void setup(){
        orderNames = new OrderNames();
    }

    @Test
    public void testOrder(){
        List<String> names = new ArrayList<>();
        names.add("raymond");
        names.add("nora");
        names.add("daniel");
        names.add("louie");
        names.add("peter");
        names.add("esteban");
        assertEquals("peter",orderNames.orderNamesLinkedList(names).get(0));
    }
}
