package sprite;
import biuoop.DrawSurface;

/**
 * * @tzlil shkuri 314706300
 */
public interface Sprite {

    /**
     * @param d the sprite we draw.
     *          drawOn function- draw the sprite to the screen.
     */
    void drawOn(DrawSurface d);


    /**
     * timePassed function- notify the sprite that time has passed.
     */
    void timePassed();
}