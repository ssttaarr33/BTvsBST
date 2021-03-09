package algorhytms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CustomerServiceCapacity {
    /*
     * At booking.com our customer service team is an important contributor to customer satisfaction.
     * During busy times, however, there might be more calls to customer service
     * than the number of customer service executives can manage.
     * Fortunately, we record data on that. We have collected information about all phone calls to our call centres for the past year.
     *
     * Given that our current number of customer care agents is X. Determine how many more people we would need to hire,
     * to make sure that our customers would not have to wait during peak hours
     * (we do not have more telephone calls than customer executives at a time)
     *
     * Input:
     * - Current number of customer executives X
     * - Number of data points in the data set N
     * - N lines of pairs of timestamp (as integer point in time: started, ended)
     *
     * Output
     * - integer, representing the number of additional customer service executives that we would need to hire,
     * to cover the call volume during peak times. If the current coverage is sufficient print 0;
     *
     * Example:
     * 1
     * 3
     * 1481122000 1481122020
     * 1481122000 1481122040
     * 1481122030 1481122035
     *
     * Answer 1
     */
    public int howManyAgentsToAdd(int noOfCurrentAgents, int[][] callsTimes) {
        List<Integer> positiveInsAndNegativeOuts = new ArrayList<>();
        Arrays.stream(callsTimes).forEach(callTime -> {
            positiveInsAndNegativeOuts.add(callTime[0]);
            positiveInsAndNegativeOuts.add(-callTime[1]);
        });
        int maxNumber = 0;
        int currentNumberOfAgents = 0;
        positiveInsAndNegativeOuts.sort(new ChecksComparator());
        for(int value : positiveInsAndNegativeOuts) {
            currentNumberOfAgents += value > 0 ? 1 : - 1;
            if (currentNumberOfAgents > maxNumber) {
                maxNumber = currentNumberOfAgents;
            }
        }
        int additional = maxNumber - noOfCurrentAgents;
        return Math.max(additional, 0);
    }

    public static class ChecksComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            int diff = Math.abs(o1) - Math.abs(o2);
            if (diff == 0) {
                return o2 - o1;
            }
            return diff;
        }
    }
}
