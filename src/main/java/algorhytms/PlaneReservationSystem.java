package algorhytms;

import java.util.*;

public class PlaneReservationSystem {

    public static void main(String[] args) {
        System.out.println(solution(2, "1a 2f 1c"));
    }

    public static int solution(int n, String S) {
        if (S.isEmpty() || S == null) {
            return 2 * n;
        }
        String[] reservedSeats = S.split(" ");
        HashMap<Integer, Set<Character>> positions = new HashMap<>();
        Arrays.stream(reservedSeats).forEach(seat -> {
            int row = seat.charAt(0);
            char col = seat.charAt(1);
            if (positions.containsKey(row)) {
                Set<Character> set = positions.get(row);
                set.add(col);
            } else {
                Set<Character> set = new HashSet<>();
                set.add(col);
                positions.put(row, set);
            }
        });
        int noOfFamilies = (n - positions.size()) % 2;

        for (Set<Character> seats : positions.values()) {
            boolean flag = false;
            if (!seats.contains('b') && !seats.contains('c') && !seats.contains('d') && !seats.contains('e')) {
                flag = true;
                noOfFamilies++;
            }
            if (!seats.contains('f') && !seats.contains('g') && !seats.contains('h') && !seats.contains('j')) {
                flag = true;
                noOfFamilies++;
            }
            if (!flag && !seats.contains('d') && !seats.contains('e') && !seats.contains('f') && !seats.contains('g')) {
                noOfFamilies++;
            }
        }


        return noOfFamilies;
    }
}
