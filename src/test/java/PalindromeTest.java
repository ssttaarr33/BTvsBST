import algorhytms.Palindrome;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {

    @Test
    public void testPalindromeCheck(){
        assertTrue(Palindrome.isPalindromeSentence("abba"));
        assertTrue(Palindrome.isPalindromeSentence("Too hot to hoot."));
        assertFalse(Palindrome.isPalindromeSentence("abcde"));
        assertFalse(Palindrome.isPalindrome("1234"));
        assertTrue(Palindrome.isPalindrome("abba"));
        assertTrue(Palindrome.checkPalindromePairs(Arrays.asList("abb","bba", "or","ok")));
        assertFalse(Palindrome.checkPalindromePairs(Arrays.asList("abb","dba", "or","ok")));
    }
}
