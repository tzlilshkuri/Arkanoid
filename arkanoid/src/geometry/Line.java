package geometry;
import java.util.ArrayList;
import java.util.List;

/**
 * * @tzlil shkuri 314706300
 */
public class Line {
    private Point start, end;

    /**
     * This is a constructor function.
     *
     * @param start the first point of the line.
     * @param end   the end point of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * This is a constructor function.
     *
     * @param x1 the x value of first point of the line.
     * @param x2 the x value of end point of the line.
     * @param y1 the y value of first point of the line.
     * @param y2 the y value of end point of the line.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * length function- return the length of the line.
     *
     * @return length -the function return the length of the line.
     */
    public double length() {
        return start().distance(end);
    }


    /**
     * middle function- return the middle point between two points.
     *
     * @return middle -the function return the middlle point.
     */
    public Point middle() {
        double myX = (end.getX() + start.getX()) / 2;
        double myY = (end.getY() + start.getY()) / 2;
        Point middlePoint = new Point(myX, myY);
        return middlePoint;
    }

    /**
     * start function- return the start point of the line.
     *
     * @return myFinalPoint -return the first point.
     */
    public Point start() {
        return start;
    }

    /**
     * end function- return the end point of the line.
     *
     * @return myFinalPoint -return the end point.
     */
    public Point end() {
        return end;
    }

    // Returns true if the lines intersect, false otherwise

    /**
     * isIntersecting function- return true if there is intersecting between two points.
     *
     * @param other the line we're comparing our linet with.
     * @return boolean -the function return true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        //check if there is an incline.
        double myLineSubtractionX = this.start.getX() - this.end.getX();
        double otherLineSubtractionX = other.start.getX() - other.end.getX();
        //both Parallel to Y.
        if (myLineSubtractionX == 0 && otherLineSubtractionX == 0) {
            if (isParallelToY(other)) {
                return true;
            }
            return false;
        }
        //there is one same point.
        if (haveOneSamePoint(other)) {
            return true;
        }
        double myLineSubtractionY = this.start.getY() - this.end.getY();
        double otherLineSubtractionY = other.start.getY() - other.end.getY();
        if (myLineSubtractionY == 0 && otherLineSubtractionY == 0) {
            if (isParallelToX(other)) {
                return true;
            }
            return false;
        }
        //only one line have incline.
        if (myLineSubtractionX == 0 && otherLineSubtractionX != 0
                || (myLineSubtractionX != 0 && otherLineSubtractionX == 0)) {
            if (oneOnlyWithNoIncline(other)) {
                return true;
            }
            return false;
        }
        //only one line have incline.
        if (myLineSubtractionY == 0 && otherLineSubtractionY != 0
                || (myLineSubtractionY != 0 && otherLineSubtractionY == 0)) {
            if (oneOnlyWithZeroIncline(other)) {
                return true;
            }
            return false;
        }
        //same lines.
        if (isTheSameLine(other)) {
            return true;
        } else {
            double myLineIncline = findMyIncline(this);
            double otherLineIncline = findMyIncline(other);
            //the inclines are different, now we check if the intersect point is between the lines.
            if (myLineIncline != otherLineIncline) {
                if (intersectBetweenTheLines(other)) {
                    return true;
                }
                return false;
                //same incline so the lines are parallel to each other.
            } else {
                return false;
            }
        }
    }

    /**
     * isTheSameLine function- return true if the lines are equal.
     *
     * @param other the line we're comparing our line with.
     * @return true or false.
     */
    public boolean isTheSameLine(Line other) {
        //the point are equal.
        if (this.start.equals(other.start) && this.end.equals(other.end)) {
            return true;
        }
        if (this.start.equals(other.end) && this.end.equals(other.start)) {
            return true;
        }
        double myIncline = findMyIncline(this);
        double myFreeVariable = this.start.getY() - (myIncline * this.start.getX());
        double otherIncline = findMyIncline(other);
        double otherFreeVariable = other.start.getY() - (otherIncline * other.start.getX());
        if (myIncline == otherIncline && myFreeVariable == otherFreeVariable) {
            return true;
        }
        return false;
    }


    /**
     * isParallelToY function- return true if the lines are parallel.
     *
     * @param other the line we're comparing our line with.
     * @return true or false.
     */
    public boolean isParallelToY(Line other) {
        //different x.
        if (this.start.getX() != other.start.getX()) {
            return false;
        }
        //one line contained in each other
        double myLineStartY = this.start.getY();
        double myLineEndY = this.end.getY();
        double myLineMaxY = Math.max(myLineStartY, myLineEndY);
        double myLineMinY = Math.min(myLineStartY, myLineEndY);
        double otherLineStartY = other.start.getY();
        double otherLineEndY = other.end.getY();
        double otherLineMaxY = Math.max(otherLineStartY, otherLineEndY);
        double otherLineMinY = Math.min(otherLineStartY, otherLineEndY);
        //check if the point is really between the lines.
        if (myLineMinY >= otherLineMinY && myLineMinY <= otherLineMaxY
                || myLineMinY <= otherLineMinY && myLineMinY >= otherLineMaxY) {
            return true;
        }
        if (myLineMaxY >= otherLineMinY && myLineMaxY <= otherLineMaxY
                || myLineMaxY <= otherLineMinY && myLineMaxY >= otherLineMaxY) {
            return true;
        }
        if (otherLineMinY >= myLineMinY && otherLineMinY <= myLineMaxY
                || otherLineMinY <= myLineMinY && otherLineMinY >= myLineMaxY) {
            return true;
        }
        return false;
    }


    /**
     * isParallelToX function- return true if the lines are parallel.
     *
     * @param other the line we're comparing our line with.
     * @return true or false.
     */
    public boolean isParallelToX(Line other) {
        double myLineStartX = this.start.getX();
        double myLineEndX = this.end.getX();
        double myLineMaxX = Math.max(myLineStartX, myLineEndX);
        double myLineMinX = Math.min(myLineStartX, myLineEndX);
        double otherLineStartX = other.start.getX();
        double otherLineEndX = other.end.getX();
        double otherLineMaxX = Math.max(otherLineStartX, otherLineEndX);
        double otherLineMinX = Math.min(otherLineStartX, otherLineEndX);
        //check if the point is really between the lines.
        if (myLineStartX >= otherLineStartX && myLineStartX <= otherLineEndX
                || myLineStartX <= otherLineStartX && myLineStartX >= otherLineEndX) {
            return true;
        }
        if (myLineEndX >= otherLineStartX && myLineEndX <= otherLineEndX
                || myLineEndX <= otherLineStartX && myLineEndX >= otherLineEndX) {
            return true;
        }
        if (otherLineStartX >= myLineStartX && otherLineStartX <= myLineEndX
                || otherLineStartX <= myLineStartX && otherLineStartX >= myLineEndX) {
            return true;
        }
        return false;
    }

    /**
     * haveOneSamePoint function- return true if the lines have one point in common.
     *
     * @param other the line we're comparing our line with.
     * @return true or false.
     */
    public boolean haveOneSamePoint(Line other) {
        if (this.start.equals(other.start)) {
            return true;
        }
        if (this.start.equals(other.end)) {
            return true;
        }
        if (this.end.equals(other.start)) {
            return true;
        }
        if (this.end.equals(other.end)) {
            return true;
        }
        return false;
    }


    /**
     * intersectBetweenTheLines function- return true if the intersect point is between the lines.
     *
     * @param other the line we're comparing our line with.
     * @return true or false.
     */
    public boolean intersectBetweenTheLines(Line other) {
        double myIncline = findMyIncline(this);
        double myFreeVariable = this.start.getY() - (myIncline * this.start.getX());
        double otherIncline = findMyIncline(other);
        double otherFreeVariable = other.start.getY() - (otherIncline * other.start.getX());
        double intersectionX = (otherFreeVariable - myFreeVariable) / (myIncline - otherIncline);
        double intersectionY = (myIncline * intersectionX) + myFreeVariable;
        Point intersectionNewPoint = new Point(intersectionX, intersectionY);
        //check if the point is between the lines.
        double myLineMaxX = Math.max(this.start.getX(), this.end.getX());
        double myLineMinX = Math.min(this.start.getX(), this.end.getX());
        double otherLineMaxX = Math.max(other.start.getX(), other.end.getX());
        double otherLineMinX = Math.min(other.start.getX(), other.end.getX());
        if (intersectionX >= myLineMinX && intersectionX <= myLineMaxX
                && intersectionX >= otherLineMinX && intersectionX <= otherLineMaxX) {
            return true;
        }
        return false;
    }


    /**
     * oneOnlyWithNoIncline function- return true if only one line have no incline.
     *
     * @param other the line we're comparing our line with.
     * @return true or false.
     */
    public boolean oneOnlyWithNoIncline(Line other) {
        //our line doesn't have an incline.
        if (this.start.getX() == this.end.getX()) {
            double otherIncline = findMyIncline(other);
            double otherFreeVariable = other.start.getY() - (otherIncline * other.start.getX());
            double sum = otherIncline * this.start.getX() + otherFreeVariable;
            double minY = Math.min(this.start.getY(), this.end.getY());
            double maxY = Math.max(this.start.getY(), this.end.getY());
            double otherMax = Math.max(other.start.getX(), other.end.getX());
            double otherMin = Math.min(other.start.getX(), other.end.getX());
            if (this.start.getX() < otherMin || this.start.getX() > otherMax) {

                return false;
            }
            if (sum >= minY && sum <= maxY) {
                return true;
            }
            return false;
        } else {
            //our line doesn't have an incline.
            double myIncline = findMyIncline(this);
            double myFreeVariable = this.start.getY() - (myIncline * this.start.getX());
            double sum = myIncline * other.start.getX() + myFreeVariable;
            double minY = Math.min(other.start.getY(), other.end.getY());
            double maxY = Math.max(other.start.getY(), other.end.getY());
            double maxX = Math.max(this.start.getX(), this.end.getX());
            double minX = Math.min(this.start.getX(), this.end.getX());
            if (minX > other.start.getX() || maxX < other.start.getX()) {
                return false;
            }
            if (sum >= minY && sum <= maxY) {
                return true;
            }
            return false;
        }
    }


    /**
     * oneOnlyWithZeroIncline function- return true if only one line have zero incline.
     *
     * @param other the line we're comparing our line with.
     * @return true or false.
     */
    public boolean oneOnlyWithZeroIncline(Line other) {
        //check which of the line have zero incline.
        if (this.start.getY() == this.end.getY()) {
            double myFreeVariable = this.start.getY();
            double otherIncline = findMyIncline(other);
            double otherFreeVariable = other.start.getY() - (otherIncline * other.start.getX());
            double intersectionX = (otherFreeVariable - myFreeVariable) / (-otherIncline);
            //check if the point is between the lines.
            if (intersectionX >= other.start.getX() && intersectionX <= other.end.getX()
                    || intersectionX >= other.end.getX() && intersectionX <= other.start.getX()) {
                return true;
            }
            return false;
        } else {
            double otherFreeVariable = other.start.getY();
            double myIncline = findMyIncline(this);
            double myFreeVariable = this.start.getY() - (myIncline * this.start.getX());
            double intersectionX = (myFreeVariable - otherFreeVariable) / (-myIncline);
            //check if the point is between the lines.
            if (((intersectionX >= this.start.getX() && intersectionX <= this.end.getX())
                    || (intersectionX >= this.end.getX() && intersectionX <= this.start.getX()))
                    && ((intersectionX >= other.start.getX() && intersectionX <= other.end.getX())
                    || (intersectionX >= other.end.getX() && intersectionX <= other.start.getX()))) {
                return true;
            }
            return false;
        }
    }


    /**
     * findMyIncline function- return the incline between two points.
     *
     * @param myLine the line we're comparing our linet with.
     * @return findY / findX-the incline.
     */
    public double findMyIncline(Line myLine) {
        double findY = myLine.end.getY() - myLine.start.getY();
        double findX = myLine.end.getX() - myLine.start.getX();
        return findY / findX;
    }


    /**
     * intersectionWith function- return the intersection point if the lines intersect and null otherwise.
     *
     * @param other the line we're comparing with our Line.
     * @return the intersection point if there is one and null if not.
     */
    public Point intersectionWith(Line other) {
        //there is no intersection point.
        if (!this.isIntersecting(other)) {
            return null;
        }
        //same line
        if (isTheSameLine(other)) {
            double myMin = Math.min(this.start.getX(), this.end.getX());
            double myMax = Math.max(this.start.getX(), this.end.getX());
            double otherMin = Math.min(other.start.getX(), other.end.getX());
            double otherMax = Math.max(other.start.getX(), other.end.getX());
            if (myMin == otherMax) {
                if (this.start.getX() < this.end.getX()) {
                    return this.start;
                }
                return this.end;
            }
            if (otherMin == myMax) {
                if (other.start.getX() < other.end.getX()) {
                    return other.start;
                }
                return other.end;

            }
            return null;
        }
        //the lines have one similar point.
        if (haveOneSamePoint(other)) {
            if (this.start == other.start || this.start == other.end) {
                Point intersectionNewPoint = new Point(this.start.getX(), this.start.getY());
                return intersectionNewPoint;
            }
            if (this.end == other.start || this.end == other.end) {
                Point intersectionNewPoint = new Point(this.end.getX(), this.end.getY());
                return intersectionNewPoint;
            }
        }
        //only when have an incline.
        if (this.start.getX() == this.end.getX() && (other.start.getX() != other.end.getX())) {
            double otherIncline = findMyIncline(other);
            double otherFreeVariable = other.start.getY() - (otherIncline * other.start.getX());
            if (other.start.getY() == 0 && other.end.getY() == 0) {
                Point intersectionNewPoint = new Point(this.start.getX(), 0);
                return intersectionNewPoint;
            } else {

                Point intersectionNewPoint = new Point(this.start.getX(), (otherIncline * this.start.getX())
                        + otherFreeVariable);
                return intersectionNewPoint;
            }
        }
        if (other.start.getX() == other.end.getX() && (this.start.getX() != this.end.getX())) {
            double myIncline = findMyIncline(this);
            double myFreeVariable = this.start.getY() - (myIncline * this.start.getX());
            if (this.start.getY() == 0 && this.end.getY() == 0) {
                Point intersectionNewPoint = new Point(myFreeVariable, 0);
                return intersectionNewPoint;
            } else {
                Point intersectionNewPoint = new Point(other.start.getX(), (myIncline * other.start.getX())
                        + myFreeVariable);
                return intersectionNewPoint;
            }
        }
        //check if every line have an incline.
        double myLineSubtractionX = this.start.getX() - this.end.getX();
        double otherLineSubtractionX = other.start.getX() - other.end.getX();
        //calculate the intersection point.
        if (myLineSubtractionX != 0 && otherLineSubtractionX != 0) {
            double myIncline = findMyIncline(this);
            double myFreeVariable = this.start.getY() - (myIncline * this.start.getX());
            double otherIncline = findMyIncline(other);
            double otherFreeVariable = other.start.getY() - (otherIncline * other.start.getX());
            double intersectionX = (otherFreeVariable - myFreeVariable) / (myIncline - otherIncline);
            double intersectionY = (myIncline * intersectionX) + myFreeVariable;
            Point intersectionNewPoint = new Point(intersectionX, intersectionY);
            return intersectionNewPoint;
        }
        double myLineSubtractionY = this.start.getY() - this.end.getY();
        double otherLineSubtractionY = other.start.getY() - other.end.getY();
        //both have zero incline.
        if (myLineSubtractionY == 0 && otherLineSubtractionY == 0) {
            return null;
        }
        return null;
    }

    /**
     * equals function- return true is the lines are equal, false otherwise.
     *
     * @param other the line we're comparing with our Line.
     * @return true if the lines is the same, otherwise return false.
     */
    public boolean equals(Line other) {
        double myIncline = findMyIncline(this);
        double otherIncline = findMyIncline(other);
        if (myIncline != otherIncline) {
            return false;
        }
        double myFreeVariable = this.start.getY() - (myIncline * -this.start.getX());
        double otherFreeVariable = other.start.getY() - (otherIncline * -other.start.getX());
        if (myFreeVariable != otherFreeVariable) {
            return false;
        }
        return true;
    }


    /**
     * equals closestIntersectionToStartOfLine- return the closest intersection point to the start of the line.
     *
     * @param rect the rectangle that out line could intersect with.
     * @return the closest intersection point or null if there is no one.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> myPointlist = new ArrayList<Point>();
        Line newLine = new Line(this.start, this.end);
        double minDistance = Double.POSITIVE_INFINITY;
        int index = -1;
        myPointlist = rect.intersectionPoints(newLine);
        //there is no intersection.
        if (myPointlist.size() == 0) {
            return null;
        }
        int numOfPoints = myPointlist.size();
        double[] distanceArr = new double[numOfPoints];
        for (int i = 0; i < numOfPoints; i++) {
            Point point = new Point(myPointlist.get(i).getX(), myPointlist.get(i).getY());
            double mydis = this.start.distance(point);
            if (mydis < minDistance) {
                index = i;
                minDistance = mydis;
            }
        }
        if (index != -1) {
            Point theClosetPoint = new Point(myPointlist.get(index).getX(), myPointlist.get(index).getY());

            return theClosetPoint;
        }
        //return the most close point to the start.
        return null;
    }

}