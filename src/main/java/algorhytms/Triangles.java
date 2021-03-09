package algorhytms;

public class Triangles {
    /*
    0 no triangle
    1 an equilateral triangle
    2 random triangle
     */
    public static int triangle(int a, int b, int c) {
        if (a > 0 && b > 0 && c > 0) {
            if (a == b && b == c) {
                return 1;
            } else {
                if ((a + b >= c) || (b + c >= a) || (a + c >= b)) {
                    return 2;
                }
            }
        }
        return 0;
    }
}
