package sprite;
import biuoop.DrawSurface;
import java.util.ArrayList;

/**
 * * @tzlil shkuri 314706300
 */

public class SpriteCollection {
    private ArrayList<Sprite> listSprite;


    /**
     * This is a constructor function in order to initialize the sprite list.
     */
    public SpriteCollection() {
        listSprite = new ArrayList<Sprite>();
    }

    /**
     * @param s the sprite we want to add to the sprite list.
     *          addSprite function- add a sprite to the list.
     */
    public void addSprite(Sprite s) {
        listSprite.add(s);
    }

    /**
     * @param s the sprite we want to remove to the sprite list.
     *          removeSprite function- remove a sprite to the list.
     */
    public void removeSprite(Sprite s) {
        listSprite.remove(s);
    }

    /**
     * timePassed function- notify the sprite that time has passed.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < listSprite.size(); i++) {
            listSprite.get(i).timePassed();
        }
    }

    /**
     * @param d the surface we draw on.
     *          drawAllOn function- draw the sprite to the screen.
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < listSprite.size(); i++) {
            listSprite.get(i).drawOn(d);
        }

    }
}