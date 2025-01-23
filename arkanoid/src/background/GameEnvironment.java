package background;
import geometry.Line;
import geometry.Point;
import sprite.Collidable;
import sprite.CollisionInfo;
import java.util.ArrayList;

/**
 * * @tzlil shkuri 314706300
 */
public class GameEnvironment {
    private ArrayList<Collidable> listCollidable;


    /**
     * This is a constructor function in order to initialize the list..
     */
    public GameEnvironment() {
        listCollidable = new ArrayList<Collidable>();
    }

    /**
     * addCollidable- the function add the given collidable to the environment.
     *
     * @param c the collidable.
     */
    public void addCollidable(Collidable c) {
        listCollidable.add(c);
    }

    /**
     * removeCollidable- the function remove the given collidable to the environment.
     *
     * @param c the collidable.
     */
    public void removeCollidable(Collidable c) {
        listCollidable.remove(c);
    }

    /**
     * CollisionInfo function-  Assume an object moving from line.start() to line.end()
     * and check If this object will not collide with any of the collidables.
     *
     * @param trajectory - the
     * @return CollisionInfro -the function return the information about the closest collision that is going to occur.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Point closestPoint = null;
        double distance = 0., minDistance = Double.POSITIVE_INFINITY;
        int index = -1;
        //the numbers of the blocks.
        int sizeOfList = listCollidable.size();
        //there is no blocks.
        if (sizeOfList == 0) {
            return null;
        }
        //We'll go over each block and see if there's collision point.
        for (int i = 0; i < sizeOfList; i++) {
            Point newPoint = trajectory.closestIntersectionToStartOfLine(listCollidable.get(i).getCollisionRectangle());
            if (newPoint != null) {
                distance = trajectory.start().distance(newPoint);
                if (distance < minDistance) {
                    minDistance = distance;
                    index = i;
                    closestPoint = newPoint;
                }
            }
        }
        //there is no collision.
        if (index == -1) {
            return null;
        }
        CollisionInfo myCollisionInfo = new CollisionInfo(listCollidable.get(index), closestPoint);
        return myCollisionInfo;
    }
}
