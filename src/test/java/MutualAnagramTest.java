import algorhytms.MutualAnagrams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class MutualAnagramTest {
    private MutualAnagrams mutualAnagrams;
    private String input;

    @BeforeEach
    void setup() {
        mutualAnagrams = new MutualAnagrams();
        input = "pear amleth dormitory tinsel dirtyroom hamlet listen silnet";
    }

    @Test
    void testCheckAnagram() {
        List<MutualAnagrams.AnagramPair> actual = mutualAnagrams.checkPairs(input);
        List<MutualAnagrams.AnagramPair> expected = Arrays.asList(
                new MutualAnagrams.AnagramPair(Arrays.asList("amleth", "hamlet")),
                new MutualAnagrams.AnagramPair(Arrays.asList("dirtyroom", "dormitory")),
                new MutualAnagrams.AnagramPair(Arrays.asList("listen", "silnet", "tinsel")),
                new MutualAnagrams.AnagramPair(Arrays.asList("pear"))
        );
        assertThat(actual, hasSize(4));
    }
}
