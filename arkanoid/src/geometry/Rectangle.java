package geometry;
import java.util.ArrayList;
import java.util.List;

/**
 * * @tzlil shkuri 314706300
 */
public class Rectangle {
    private Point upperLeft;
    private double width, height;

    // Create a new rectangle with location and width/height.

    /**
     * This is a constructor function.
     *
     * @param upperLeft the rectangle upper left point.
     * @param width     the width of the rectangle.
     * @param height    the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }


    /**
     * distance intersectionPoints- the function return a (possibly empty) List of intersection points
     * with the specified line.
     *
     * @param line the point we're comparing our point with.
     * @return myPointlist -the function return the list.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        Point upperRight = new Point(upperLeft.getX() + width, upperLeft.getY());
        Point lowerLeft = new Point(upperLeft.getX(), upperLeft.getY() + height);
        Point lowerRight = new Point(upperLeft.getX() + width, upperLeft.getY() + height);
        Line upperLine = new Line(upperLeft, upperRight);
        Line lowerLine = new Line(lowerLeft, lowerRight);
        Line leftLine = new Line(upperLeft, lowerLeft);
        Line rightLine = new Line(upperRight, lowerRight);
        List<Point> myPointlist = new ArrayList<Point>();
        // Every condition check if there is a collision point between out point to on of the rectangle sides.
        Point p1 = line.intersectionWith(upperLine);
        if (p1 != null) {
            myPointlist.add(p1);
        }
        Point p2 = line.intersectionWith(lowerLine);
        if (p2 != null) {
            myPointlist.add(p2);
        }

        Point p3 = line.intersectionWith(leftLine);
        if (p3 != null) {
            myPointlist.add(p3);
        }
        Point p4 = line.intersectionWith(rightLine);
        if (p4 != null) {
            myPointlist.add(p4);
        }
        return myPointlist;
    }


    /**
     * getWidth function- return the width of the rectangle.
     *
     * @return width- the rectangle width.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * getWidth function- return the height of the rectangle.
     *
     * @return height- the rectangle height.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * @param upperLeftX the x value of the point that we want to update.
     *                   setUpperLeftX function- update x value.
     */
    public void setUpperLeftX(double upperLeftX) {
        this.upperLeft.setX(this.upperLeft.getX() + upperLeftX);
    }


    /**
     * getUpperLeft function- return the upper-left point of the rectangle.
     *
     * @return upperLeft- the rectangle upper left point.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}
