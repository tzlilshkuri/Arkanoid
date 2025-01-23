package background;

import biuoop.DrawSurface;
import biuoop.Sleeper;
import sprite.SpriteCollection;
import java.awt.Color;

/**
 * * @tzlil shkuri 314706300
 */
public class CountdownAnimation implements Animation {
    private Boolean stop;
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private double t;


    /**
     * This is a constructor function.
     *
     * @param numOfSeconds the num of seconds before we change the number.
     * @param countFrom    the number we start to count.
     * @param gameScreen   the sprite we draw.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.stop = false;
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.t = 1000 * (this.numOfSeconds / this.countFrom);
    }

    /**
     * doOneFrame function- The function do one frame of the game everytime.
     *
     * @param d our surface.
     */
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        Sleeper sleeper = new Sleeper();
        d.setColor(Color.black);
        d.drawText(390, 400, "" + this.countFrom, 41);
        d.setColor(Color.gray.brighter());
        d.drawText(390, 400, "" + this.countFrom, 40);
        this.countFrom = this.countFrom - 1;
        if (this.numOfSeconds == -1) {
            this.stop = true;
        }
        if (this.numOfSeconds != 2) {
            sleeper.sleepFor((long) this.t);
        }
        numOfSeconds = numOfSeconds - 1;
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