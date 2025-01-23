package background;

import biuoop.DrawSurface;

/**
 * * @tzlil shkuri 314706300
 */
public interface Animation {

    /**
     * doOneFrame function- The function do one frame of the game everytime.
     *
     * @param d our surface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * shouldStop function- return false if we want to end/freeze frame.
     *
     * @return boolean - return false.
     */
    boolean shouldStop();
}