package listener;

import background.Counter;
import geometry.Ball;
import sprite.Block;

/**
 * * @tzlil shkuri 314706300
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * This is a constructor function.
     *
     * @param scoreCounter -set the score counter.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }


    /**
     * @param beingHit -the block that being hit.
     * @param hitter   - the ball that hit the block.
     *                 hitEvent function- Blocks that are hit should be removed
     *                 from the game.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}