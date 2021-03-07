package algorhytms;

public class QueuePositions {

    public static void minimumBribes(int[] q) {
        int bribes = 0;
        for (int i = 0; i < q.length; i++) {
            if ((q[i] - (i + 1)) > 2) {
                System.out.println("Too chaotic");
                return;
            }else{
                for (int j = 0; j < i; j++) {
                    if (q[j] > q[i]) {
                        bribes++;
                    }
                }
            }
        }

        System.out.println(bribes);

    }

    public static void main(String[] args) {
        minimumBribes(new int[]{2, 1, 5, 3, 4});
    }
}
