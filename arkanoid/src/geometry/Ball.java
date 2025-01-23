package geometry;

import background.GameLevel;
import background.GameEnvironment;
import biuoop.DrawSurface;
import sprite.CollisionInfo;
import sprite.Paddle;
import sprite.Sprite;

import java.awt.Color;

/**
 * * @tzlil shkuri 314706300
 */

public class Ball implements Sprite {
    static final double INFINITESIMAL = 0.000000001;
    static final int SAVE_THE_BALL = 2;
    public static final double ALLOWED_ERROR = Math.pow(10, -10);
    private Point center;
    private int r;
    private Paddle myPaddle;
    private java.awt.Color color;
    private Velocity v;
    private int minSize;
    private int maxSize;
    private GameEnvironment gameEnvironment;


    /**
     * This is a constructor function.
     *
     * @param center          this is where the ball is start on the screen.
     * @param r               the Radios to the ball.
     * @param color           the color of the ball.
     * @param gameEnvironment - our game environment.
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.v = new Velocity(1, 1);
        this.gameEnvironment = gameEnvironment;
        this.myPaddle = null;
    }

    /**
     * This is another constructor function.
     *
     * @param x               the X-element of the point.
     * @param y               the Y-element of the point.
     * @param r               the Radios to the ball.
     * @param color           the color of the ball.
     * @param gameEnvironment - our game environment.
     */
    public Ball(double x, double y, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.minSize = 0;
        this.maxSize = 200;
        this.v = new Velocity(1, 1);
        this.gameEnvironment = gameEnvironment;
        this.myPaddle = null;

    }

    /**
     * getX function- the function get the x values of this point.
     *
     * @return x -the function return x value of the point.
     */
    public int getX() {
        return (int) center.getX();
    }

    /**
     * getY function- the function get the y values of this point.
     *
     * @return y -the function return y value of the point.
     */
    public int getY() {
        return (int) center.getY();

    }

    /**
     * getPoint function- the function get the center point of thr ball.
     *
     * @return point -the function return the point.
     */
    public Point getPoint() {
        return this.center;
    }

    /**
     * @param minSize1 Where the range of the ball begins
     * @param maxSize1 Where the range of the ball ends
     *                 That's the exact range at which the ball can only move.
     *                 setMinMax function- update min and max value.
     */
    public void setMinMax(int minSize1, int maxSize1) {
        this.minSize = minSize1;
        this.maxSize = maxSize1;
    }


    /**
     * getSize function- return the size of the ball's radios.
     *
     * @return r -the function return the Radios.
     */
    public int getSize() {

        return this.r;
    }

    /**
     * getgetColor function- return the color of the ball.
     *
     * @return color -the function return the color.
     */
    public java.awt.Color getColor() {

        return this.color;
    }


    /**
     * @param x1 the x value of the center point that we want to update.
     *           setX function- update x value.
     */
    public void setX(int x1) {
        this.center.setX(x1);
    }

    /**
     * @param y1 the y value of the center point that we want to update.
     *           setY function- update y value.
     */
    public void setY(int y1) {

        this.center.setY(y1);
    }

    /**
     * @param p1 the value of the center point that we want to update.
     *           setPoint function- update the point value.
     */
    public void setPoint(Point p1) {
        this.center = p1;
    }


    /**
     * @param color1 the color of the point that we want to update.
     *               setColor function- update color value.
     */
    public void setColor(java.awt.Color color1) {

        this.color = color1;
    }


    /**
     * @param v the velocity of the ball.
     *          setVelocity function- update velocity value.
     */
    public void setVelocity(Velocity v) {

        this.v = v;

    }

    /**
     * @param myPaddle the paddle.
     *                 setPaddle function- update the paddle.
     */
    public void setPaddle(Paddle myPaddle) {
        this.myPaddle = myPaddle;
    }


    /**
     * @param dx the velocity of the x value.
     * @param dy the velocity of the y value.
     *           setVelocity function- update velocity value.
     *           The change between this function and the previous one is the parameters.
     */
    public void setVelocity(double dx, double dy) {

        this.v = new Velocity(dx, dy);

    }

    /**
     * getVelocity function- return the velocity value of the ball.
     *
     * @return v -the function return the ball velocity.
     */
    public Velocity getVelocity() {

        return this.v;

    }

    /**
     * timePassed function- notify the sprite that time has passed.
     */
    public void timePassed() {
        this.moveOneStep();
    }


    /**
     * moveOneStep function- The function directs the ball so that it doesn't come out of the screen and
     * stays in the area we set it up for.
     */
    public void moveOneStep() {
        //if the x value of the ball is out of the screen but his value is also positive.
        if (this.center.getX() + this.getSize() > maxSize && v.getDx() > 0) {
            this.setVelocity(-v.getDx(), v.getDy());
        }
        //if the x value of the ball is out of the screen but his value is also negative.
        if (this.center.getX() - this.getSize() < minSize && v.getDx() < 0) {
            this.setVelocity(-v.getDx(), v.getDy());
        }
        //if the y value of the ball is out of the screen but his value is also positive.
        if (this.center.getY() + this.getSize() > maxSize && v.getDy() > 0) {
            this.setVelocity(v.getDx(), -v.getDy());
        }
        //if the y value of the ball is out of the screen but his value is also negative.
        if (this.center.getY() - this.getSize() < minSize && v.getDy() < 0) {
            this.setVelocity(v.getDx(), -v.getDy());
        }
        //next step.
        Line myTrajctory = new Line(this.center.getX(), this.center.getY(), this.center.getX() + v.getDx(),
                this.center.getY() + v.getDy());

        //check if there is a collision point.
        CollisionInfo myCollision = this.gameEnvironment.getClosestCollision(myTrajctory);
        //there is a hit.
        if (myCollision != null) {
            if (v.getDy() == 0) {
                v.setDy(-1);
            }
            //set the new velocity.
            Velocity v1 = myCollision.collisionObject().hit(this, myCollision.collisionPoint(), this.getVelocity());
            //set the new center.
            this.center.setX(this.center.getX() + INFINITESIMAL);
            this.center.setY(this.center.getY() + INFINITESIMAL);
            //make sure that the paddle doesn't run over the ball.
            Point upperLeft = myPaddle.getCollisionRectangle().getUpperLeft();
            if ((this.center.getX() > upperLeft.getX() && this.center.getX()
                    < upperLeft.getX() + myPaddle.getCollisionRectangle().getWidth())
                    && this.center.getY() > upperLeft.getY()) {
                this.center.setX(this.center.getX());
                this.center.setY(upperLeft.getY() - SAVE_THE_BALL);
            }
            this.setVelocity(v1);
            return;
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * @param game - the game we remove sprite from.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }

    /**
     * @param surface the surface we want to draw on.
     *                drawOn function- the function draw the ball on the given DrawSurface.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
        surface.setColor(Color.black);
        surface.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
    }
}