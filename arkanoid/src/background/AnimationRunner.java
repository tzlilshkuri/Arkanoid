package background;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;


/**
 * * @tzlil shkuri 314706300
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;
    private int countLevels;


    /**
     * This is a constructor function.
     * the funtion open new GUI, reset the number of levels we played.
     * and identify the sleeper and the time for every frame.
     */
    public AnimationRunner() {
        this.gui = new GUI("Hello", 800, 600);
        this.framesPerSecond = 60;
        this.sleeper = new Sleeper();
        this.countLevels = 0;
    }

    /**
     *run function- The function run the animation as long as we don't get a false response
     * from the doOneFrame function.
     * @param animation - the animation we're running.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * getGui function- the function get the GUI.
     *
     * @return gui - our Gui.
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * getKeyBoardSensor function- the function get the keyboard.
     *
     * @return keyboard - our keyboard.
     */
    public KeyboardSensor getKeyBoardSensor() {
        return this.gui.getKeyboardSensor();
    }

}
