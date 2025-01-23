package sprite;
import background.Counter;
import biuoop.DrawSurface;
import geometry.Point;
import geometry.Rectangle;
import java.awt.Color;

/**
 * * @tzlil shkuri 314706300
 */
public class ScoreIndicator implements Sprite {
    private Block block;
    private Counter score;
    static final int SCREEN_SIZE_MAX = 800;

    /**
     * This is another constructor function.
     *
     * @param score the counter score.
     */
    public ScoreIndicator(Counter score) {
        this.block = new Block(new Rectangle(new Point(0, 0), SCREEN_SIZE_MAX, 20), Color.WHITE);
        this.score = score;

    }

    @Override
    public void drawOn(DrawSurface d) {
        this.block.drawOn(d);
        d.drawText(375, 18, "Score " + this.score.getValue(), 20);
    }

    @Override
    public void timePassed() {

    }
}
