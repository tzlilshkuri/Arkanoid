package background;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * * @tzlil shkuri 314706300
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboard;
    private String stringStopKey;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * This is a constructor function.
     * @param sensor -the keyboard.
     * @param key -the keyboard.
     * @param animation - the animation we're running.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboard = sensor;
        this.stringStopKey = key;
        this.animation = animation;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    /**
     * doOneFrame function- The function do one frame of the game everytime.
     *
     * @param d our surface.
     */
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
        if (!this.keyboard.isPressed(this.stringStopKey)) {
            this.isAlreadyPressed = false;
        }
        if (this.keyboard.isPressed(this.stringStopKey) && !this.isAlreadyPressed) {
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