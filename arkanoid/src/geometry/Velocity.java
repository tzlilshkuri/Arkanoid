package geometry;
/**
 * * @tzlil shkuri 314706300
 */

public class Velocity {

    private double dx;
    private double dy;

    /**
     * This is a constructor function.
     * @param dx this is the x velocity of thr ball.
     * @param dy this is the y velocity of thr ball.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * getDx function- the function get the dx values of this point.
     *
     * @return dx -the function return dx value of the point.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * getDy function- the function get the dx values of this point.
     *
     * @return dy -the function return dx value of the point.
     */
    public double getDy() {
        return this.dy;
    }


    /**
     * @param dx1 the dx value of the ball that we want to update.
     * setDx function- update dx value.
     */
    public void setDx(double dx1) {
        this.dx = dx1;
    }

    /**
     * @param dy1 the dy value of the ball that we want to update.
     *            setDy function- update dy value.
     */
    public void setDy(double dy1) {
        this.dy = dy1;
    }

    /**
     * @param speed this is our speed value.
     * @param angle this is our angle value.
     * The function receives speed and angle and calculates accordingThe
     * function receives speed and angle and calculates according to the data
     * the new movement and speed of the ball
     * @return Velocity return the update velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = (speed * Math.sin(Math.toRadians(angle)));
        double dy = -(speed * Math.cos(Math.toRadians(angle)));

        return new Velocity(dx, dy);
    }


    /**
     * @param p this is our point.
     * the function take a point with position (x,y) and return a new point
     *with position (x+dx, y+dy)
     * @return newPoint return the updated point.
     */
    public Point applyToPoint(Point p) {
        Point newPoint = new Point(p.getX() + this.dx, p.getY() + this.dy);
        return newPoint;

    }



}