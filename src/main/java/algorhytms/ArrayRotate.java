package algorhytms;

public class ArrayRotate {

    public static int[] rotLeft(int[] a, int d){
        int n = a.length;
        int[] rotArray = new int[n];
        for(int oldIndex = 0; oldIndex < n ;oldIndex++){
            int newIndex = (oldIndex + n -d) % n;
            rotArray[newIndex] = a[oldIndex];
        }
        return rotArray;
    }

}
