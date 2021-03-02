package algorhytms;

import java.util.List;

public class PolygonAlgo {
    //check what you can form with dimensions from input list
    /*
    Sample input:
    36 30 36 30
    15 15 15 15
    46 96 90 100
    86 86 86 86
    100 200 100 200
    -100 200 -100 200

    2 squares 2 rectangles 2 other polys
    expected output: 2 2 2
     */
    private int squares = 0;
    private int rectangles = 0;
    private int other = 0;

    public String checkPolygonsTypes(List<String> polygons) {

        polygons.stream()
                .map(dimString -> dimString.split(" "))
                .forEach(this::addPolyType);

        return "" + squares + " " + rectangles + " " + other;
    }

    private void addPolyType(String[] dims) {
        if (0 >= Integer.parseInt(dims[0]) || 0 >= Integer.parseInt(dims[1]) || 0 >= Integer.parseInt(dims[2]) || 0 >= Integer.parseInt(dims[3])) {
            other++;
        } else if (Integer.parseInt(dims[0]) == Integer.parseInt(dims[2]) && Integer.parseInt(dims[1]) == Integer.parseInt(dims[3]) && Integer.parseInt(dims[0]) != Integer.parseInt(dims[1])) {
            rectangles++;
        } else if (Integer.parseInt(dims[0]) == Integer.parseInt(dims[2]) && Integer.parseInt(dims[1]) == Integer.parseInt(dims[3]) && Integer.parseInt(dims[0]) == Integer.parseInt(dims[1])) {
            squares++;
        } else {
            other++;
        }
    }
}
