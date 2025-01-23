package sprite;

import geometry.Ball;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
/**
 * * @tzlil shkuri 314706300
 */

public interface Collidable {


    /**
     * hit function-  return the "collision shape" of the object.
     *
     * @return Rectangle - the collision point.
     */
    Rectangle getCollisionRectangle();


    /**
     * hit function- The classes that implement the function will return the new velocity expected after the hit.
     *
     * @param collisionPoint  - the collision point.
     * @param currentVelocity - the current velocity.
     * @param hitter - the ball that hits to block.
     * @return hit - the new velocity.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}