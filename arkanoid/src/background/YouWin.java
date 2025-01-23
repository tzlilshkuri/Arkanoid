package background;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * * @tzlil shkuri 314706300
 */
public class YouWin implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter myScore;

    /**
     * This is a constructor function.
     *
     * @param k       - our keyboard.
     * @param myScore -the current score.
     */
    public YouWin(KeyboardSensor k, Counter myScore) {
        this.keyboard = k;
        this.stop = false;
        this.myScore = myScore;
    }

    /**
     * doOneFrame function- The function do one frame of the game everytime.
     *
     * @param d our surface.
     */
    public void doOneFrame(DrawSurface d) {
        d.setColor(new Color(89, 161, 120));
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.gray.brighter());
        d.fillRectangle(120, 250, 570, 80);
        d.setColor(Color.white);
        d.drawText(150, 300, "You win! Your Score is " + this.myScore.getValue(), 40);
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
