package listener;

import geometry.Ball;
import sprite.Block;

/**
 * * @tzlil shkuri 314706300
 */
public interface HitListener {

    /**
     * @param beingHit -the block that being hit.
     * @param hitter   - the ball that hit the block.
     *                 hitEvent function- Blocks that are hit should be removed
     *                 from the game.
     */
    void hitEvent(Block beingHit, Ball hitter);
}