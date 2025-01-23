package sprite;

import background.GameLevel;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import geometry.Ball;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;

import java.awt.Color;


/**
 * * @tzlil shkuri 314706300
 */

public class Paddle implements Sprite, Collidable {
    public static final double ALLOWED_ERROR = Math.pow(10, -10);
    public static final int FIRST_REGION = 0;
    public static final int SECOND_REGION = 1;
    public static final int THIRD_REGION = 2;
    public static final int FOURTH_REGION = 3;
    public static final int FIFTH_REGION = 4;
    private biuoop.KeyboardSensor keyboard;
    private Block myPaddle;
    private int startLimit;
    private int endLimit;
    private int paddleSpeed;


    /**
     * This is another constructor function.
     *
     * @param mykeboard   the keyboard.
     * @param startLimit  the left limit of the paddle.
     * @param endLimit    the right limit of the paddle.
     * @param myBlock     the paddle's block.
     * @param paddleSpeed the paddle speed.
     */
    public Paddle(KeyboardSensor mykeboard, int startLimit, int endLimit, Block myBlock, int paddleSpeed) {
        this.keyboard = mykeboard;
        this.startLimit = startLimit;
        this.endLimit = endLimit;
        this.myPaddle = myBlock;
        this.paddleSpeed = paddleSpeed;

    }

    /**
     * moveLeft function- the function moves the paddle to the left if the paddle doesn't cross the limit.
     */
    public void moveLeft() {
        if (this.myPaddle.getCollisionRectangle().getUpperLeft().getX() > startLimit) {
            this.myPaddle.getCollisionRectangle().setUpperLeftX(-this.paddleSpeed);
        }
    }

    /**
     * moveRight function- the function moves the paddle to the right if the paddle doesn't cross the limit.
     */
    public void moveRight() {
        if (this.myPaddle.getCollisionRectangle().getUpperLeft().getX()
                + this.myPaddle.getCollisionRectangle().getWidth() < endLimit) {
            this.myPaddle.getCollisionRectangle().setUpperLeftX(this.paddleSpeed);
        }
    }

    /**
     * timePassed function- the function check if the user press the left or right key and calls
     * the other functuion in order to move the paddle.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }

        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    /**
     * @param d - the surface we draw on.
     *          drawOn- this function draw a paddle.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(myPaddle.getColor());
        d.fillRectangle((int) this.getCollisionRectangle().getUpperLeft().getX(),
                (int) this.getCollisionRectangle().getUpperLeft().getY(),
                (int) this.getCollisionRectangle().getWidth(), (int) this.getCollisionRectangle().getHeight());

        d.setColor(Color.black);
        d.drawRectangle((int) this.getCollisionRectangle().getUpperLeft().getX(),
                (int) this.getCollisionRectangle().getUpperLeft().getY(),
                (int) this.getCollisionRectangle().getWidth(), (int) this.getCollisionRectangle().getHeight());

    }

    /**
     * getCollisionRectangle function- the function return the collision point with the rectangle.
     *
     * @return this.myPaddle.getCollisionRectangle() -the function return y value of the point.
     */
    public Rectangle getCollisionRectangle() {
        return this.myPaddle.getCollisionRectangle();
    }

    /**
     * hit function- check where exactly the ball hit the paddle and change is velocity according to the place.
     *
     * @param collisionPoint  - the collisionPoint.
     * @param currentVelocity - out current velocity.
     * @param hitter          - the ball that hits the block.
     * @return currentVelocity -the function return the new velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {

        Rectangle rec = this.myPaddle.getCollisionRectangle();
        Point upperLeft = new Point(rec.getUpperLeft().getX(), rec.getUpperLeft().getY());
        Point upperRight = new Point(rec.getUpperLeft().getX() + rec.getWidth(), rec.getUpperLeft().getY());
        Point lowerLeft = new Point(rec.getUpperLeft().getX(), rec.getUpperLeft().getY() + rec.getHeight());
        Point lowerRight = new Point(rec.getUpperLeft().getX() + rec.getWidth(),
                rec.getUpperLeft().getY() + rec.getHeight());

        //the ball hits the left/right side of the paddle but have zero dy velocity.
        if (currentVelocity.getDy() == 0) {

            currentVelocity.setDx(-currentVelocity.getDx());
            return currentVelocity;
        }
        //the ball hits the left side of the paddle.
        if (Math.abs(collisionPoint.getX() - lowerLeft.getX()) <= ALLOWED_ERROR
                || Math.abs(collisionPoint.getX() - upperLeft.getX()) <= ALLOWED_ERROR) {
            double myDx = currentVelocity.getDx() * currentVelocity.getDx();
            double myDy = currentVelocity.getDy() * currentVelocity.getDy();
            double myspeed = Math.sqrt(myDx + myDy);
            currentVelocity = Velocity.fromAngleAndSpeed(300, myspeed);
        }
        //the ball hits the right side of the paddle.
        if (Math.abs(collisionPoint.getX() - upperRight.getX()) <= ALLOWED_ERROR
                || Math.abs(collisionPoint.getX() - lowerRight.getX()) <= ALLOWED_ERROR) {
            double myDx = currentVelocity.getDx() * currentVelocity.getDx();
            double myDy = currentVelocity.getDy() * currentVelocity.getDy();
            double myspeed = Math.sqrt(myDx + myDy);
            currentVelocity = Velocity.fromAngleAndSpeed(60, myspeed);
        }
        //the ball hits the paddle.
        if (Math.abs(collisionPoint.getY() - rec.getUpperLeft().getY()) <= ALLOWED_ERROR
                || Math.abs(collisionPoint.getY() - upperRight.getY()) < ALLOWED_ERROR) {
            double myx = collisionPoint.getX() - upperLeft.getX();
            //the length of every part in the paddle.
            double splitToParts = this.myPaddle.getCollisionRectangle().getWidth() / 5;
            //the ball hits part 1 of the paddle.
            if ((myx / splitToParts) - 1 <= FIRST_REGION && ((myx / splitToParts) - 1 <= SECOND_REGION)) {
                double myDx = currentVelocity.getDx() * currentVelocity.getDx();
                double myDy = currentVelocity.getDy() * currentVelocity.getDy();
                double myspeed = Math.sqrt(myDx + myDy);
                currentVelocity = Velocity.fromAngleAndSpeed(300, myspeed);
            }
            //the ball hits part 2 of the paddle.
            if ((myx / splitToParts) - 1 >= FIRST_REGION && (myx / splitToParts) - 1 <= SECOND_REGION) {
                double myDx = currentVelocity.getDx() * currentVelocity.getDx();
                double myDy = currentVelocity.getDy() * currentVelocity.getDy();
                double myspeed = Math.sqrt(myDx + myDy);
                currentVelocity = Velocity.fromAngleAndSpeed(330, myspeed);
            }
            //the ball hits part 3 of the paddle.
            if ((myx / splitToParts) - 1 >= SECOND_REGION && (myx / splitToParts) - 1 <= THIRD_REGION) {
                currentVelocity.setDy(-currentVelocity.getDy());
            }
            //the ball hits part 4 of the paddle.
            if ((myx / splitToParts) - 1 >= THIRD_REGION && (myx / splitToParts) - 1 <= FIFTH_REGION) {
                double myDx = currentVelocity.getDx() * currentVelocity.getDx();
                double myDy = currentVelocity.getDy() * currentVelocity.getDy();
                double myspeed = Math.sqrt(myDx + myDy);
                currentVelocity = Velocity.fromAngleAndSpeed(30, myspeed);

            }
            //the ball hits part 5 of the paddle.
            if ((myx / splitToParts) - 1 >= FOURTH_REGION && (myx / splitToParts) - 1 <= FIFTH_REGION) {
                double myDx = currentVelocity.getDx() * currentVelocity.getDx();
                double myDy = currentVelocity.getDy() * currentVelocity.getDy();
                double myspeed = Math.sqrt(myDx + myDy);
                currentVelocity = Velocity.fromAngleAndSpeed(60, myspeed);
            }
        }
        return currentVelocity;
    }


    /**
     * @param g our Game.
     *          addToGame function-  add the paddle to the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(myPaddle);
    }
}