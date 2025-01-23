package sprite;
import geometry.Point;

/**
 * * @tzlil shkuri 314706300
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * This is a constructor function.
     *
     * @param collisionObject the collision Object.
     * @param collisionPoint  the collision Point.
     */
    public CollisionInfo(Collidable collisionObject, Point collisionPoint) {
        this.collisionObject = collisionObject;
        this.collisionPoint = collisionPoint;
    }

    /**
     * collisionPoint function- the function check if there is collision.
     *
     * @return point -return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return collisionPoint;
    }

    /**
     * @return the collision Object -return the object at which the collision occurs.
     */
    public Collidable collisionObject() {
        return collisionObject;
    }

}