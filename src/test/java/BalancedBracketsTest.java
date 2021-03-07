import algorhytms.BalancedBrackets;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BalancedBracketsTest {

    @Test
    public void checkBalancedBrackets(){
        assertTrue(BalancedBrackets.balancedBrackets("({[()]})"));
        assertFalse(BalancedBrackets.balancedBrackets("{[()]})"));
    }
}
