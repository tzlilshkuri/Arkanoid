package background;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * * @tzlil shkuri 314706300
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * This is a constructor function.
     *
     * @param k -the keyboard.
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }


    /**
     * doOneFrame function- The function do one frame of the game everytime.
     * @param d our surface.
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    /**
     * shouldStop function- return false if we want to end/freeze frame.
     *
     * @return boolean - return false.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
