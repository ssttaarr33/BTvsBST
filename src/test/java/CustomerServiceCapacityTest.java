import algorhytms.CustomerServiceCapacity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerServiceCapacityTest {
    private CustomerServiceCapacity customerServiceCapacity;
    private int[][] times;

    @BeforeEach
    void setup() {
        customerServiceCapacity = new CustomerServiceCapacity();
        times = new int[][]{{1481122000, 1481122000}, {1481122000, 1481122040}, {1481122030, 1481122035}};
    }

    @Test
    void test() {
        assertEquals(1, customerServiceCapacity.howManyAgentsToAdd(1, times));
    }

}
