package algorhytms;

import java.util.ArrayList;
import java.util.List;

/*
Problem
Given a list of numbers, e.g.:

25626 25757 24367 24267 16 100 2 7277
Output a delta encoding for the sequence. In a delta encoding, the first element is reproduced as is. Each subsequent element is represented as the numeric difference from the element before it. E.g. for the sequence above, the delta encoding would be:

25626 131 -1390 -100 -24251 84 -98 7275
However, if a difference value does not fit in a single signed byte, i.e. -127 <= x <= 127, then, instead of the difference, we would like to use an escape token, printing it.

This will denote that the value following the escape token is a full four-byte difference value, rather than a one-byte different value.

For this exercise, we'll declare -128 as the escape token.

Following the same example above, the final result would be:

25626 -128 131 -128 -1390 -100 -128 -24251 84 -98 -128 7275
 */
public class DeltaEncoding {

    private List<Integer> encoded = new ArrayList<>();
    public List<Integer> deltaEncode(List<Integer> numbers){
        int head = numbers.get(0);
        encoded.add(head);
        numbers = numbers.subList(1, numbers.size());
        for(int number: numbers){
            int x = number - head;
            if(-127 >= x || x >= 127){
                encoded.add(-128);
                encoded.add(x);
            } else{
                encoded.add(x);
            }
            head = number;
        }
        return encoded;
    }
}
