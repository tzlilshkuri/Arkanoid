package sprite;

import background.GameLevel;
import biuoop.DrawSurface;
import geometry.Ball;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import listener.HitListener;
import listener.HitNotifier;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * * @tzlil shkuri 314706300
 */
public class Block implements Collidable, Sprite, HitNotifier {
    public static final double ALLOWED_ERROR = Math.pow(10, -10);
    private Rectangle rec;
    private java.awt.Color color;
    private ArrayList<HitListener> listHitListeners;


    /**
     * This is a constructor function.
     *
     * @param rec   this is the Rectangle.
     * @param color the color of the Rectangle.
     */
    public Block(Rectangle rec, java.awt.Color color) {
        this.rec = rec;
        this.color = color;
        listHitListeners = new ArrayList<HitListener>();
    }

    /**
     * getHitListeners function- return the Hit Listeners.
     *
     * @return listHitListeners -the Hit Listeners.
     */
    public List<HitListener> getHitListeners() {
        return this.listHitListeners;
    }


    /**
     * getCollisionRectangle function- the Return the "collision shape" of the object.
     *
     * @return this.rec -the ollision shape.
     */
    public Rectangle getCollisionRectangle() {
        return this.rec;
    }

    /**
     * timePassed function- the function check if we need to move the block.
     */
    public void timePassed() {
    }

    /**
     * removeFromGame -the function remove from the game the sprite and the Collidable items.
     *
     * @param game - our game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }

    /**
     * hit function- check where the ball hit the block and change is velocity according to the hit point.
     *
     * @param collisionPoint  - the collisionPoint.
     * @param currentVelocity - out current velocity.
     * @param hitter          - the ball that hits the block.
     * @return currentVelocity -the function return the new velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Point upperRight = new Point(rec.getUpperLeft().getX() + rec.getWidth(), rec.getUpperLeft().getY());
        Point lowerLeft = new Point(rec.getUpperLeft().getX(), rec.getUpperLeft().getY() + rec.getHeight());
        Point lowerRight = new Point(rec.getUpperLeft().getX() + rec.getWidth(),
                rec.getUpperLeft().getY() + rec.getHeight());
        //if the X value are the same.
        if (Math.abs(collisionPoint.getX() - lowerLeft.getX()) <= ALLOWED_ERROR
                || Math.abs(collisionPoint.getX() - lowerRight.getX()) <= ALLOWED_ERROR) {
            currentVelocity.setDx(-currentVelocity.getDx());
        }

        //if the Y value are the same.
        if (Math.abs(collisionPoint.getY() - rec.getUpperLeft().getY()) <= ALLOWED_ERROR
                || Math.abs(collisionPoint.getY() - lowerRight.getY()) < ALLOWED_ERROR) {

            currentVelocity.setDy(-currentVelocity.getDy());
        }
        this.notifyHit(hitter);
        return currentVelocity;
    }


    /**
     * @param surface the surface we want to draw on.
     *                drawOn function- the function draw the block on the given DrawSurface.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) rec.getUpperLeft().getX(), (int) rec.getUpperLeft().getY(),
                (int) rec.getWidth(), (int) rec.getHeight());
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) rec.getUpperLeft().getX(), (int) rec.getUpperLeft().getY(),
                (int) rec.getWidth(), (int) rec.getHeight());


    }

    /**
     * getColor function- return the color.
     *
     * @return color -the color of the block.
     */
    public Color getColor() {
        return this.color;
    }


    @Override
    public void addHitListener(HitListener hl) {
        listHitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        listHitListeners.remove(hl);
    }


    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.listHitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }


}
