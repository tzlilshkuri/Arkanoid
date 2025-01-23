package geometry;

/**
 * * @tzlil shkuri 314706300
 */
public class Point {
    public static final double ALLOWED_ERROR = Math.pow(10, -10);
    private double x, y;

    /**
     * This is a constructor function.
     *
     * @param x the X-element of the point.
     * @param y the Y-element of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }


    /**
     * distance function- return the distance of this point to the other point.
     *
     * @param other the point we're comparing our point with.
     * @return myFinalPoint -the function return the distance between to two points.
     */
    public double distance(Point other) {
        double myPointX = Math.pow((this.x - other.getX()), 2);
        double myPointY = Math.pow((this.y - other.getY()), 2);
        double myFinalPoint = Math.sqrt((myPointX + myPointY));
        return myFinalPoint;
    }


    /**
     * equals function- return true is the points are equal, false otherwise.
     *
     * @param other the point we're comparing our point with.
     * @return boolean -the function return true if the point equal, false otherwise.
     */
    public boolean equals(Point other) {
        if (other == null) {
            return false;
        }
        return Math.abs(this.x - other.getX()) < ALLOWED_ERROR && Math.abs(this.y - other.getY()) < ALLOWED_ERROR;
    }


    /**
     * getX function- return the x and y values of this point.
     *
     * @return x -the function return x value of the point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * getY function- return the x and y values of this point.
     *
     * @return y -the function return y value of the point.
     */
    public double getY() {
        return this.y;
    }

    /**
     * @param x1 the x value of the point that we want to update.
     *           setX function- update x value.
     */
    public void setX(double x1) {
        this.x = x1;
    }

    /**
     * @param y1 the y value of the point that we want to update.
     *           setY function-  update y value.
     */
    public void setY(double y1) {
        this.y = y1;
    }
}