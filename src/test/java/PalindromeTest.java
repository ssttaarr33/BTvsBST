import algorhytms.Palindrome;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {
    private Palindrome palindrome;

    @Test
    public void testPalindromeCheck(){
        assertTrue(Palindrome.isPalindrome("abba"));
        assertTrue(Palindrome.isPalindrome("Too hot to hoot."));
        assertFalse(Palindrome.isPalindrome("abcde"));
    }
}
