
package listener;

import background.Counter;
import background.GameLevel;
import geometry.Ball;
import sprite.Block;

/**
 * * @tzlil shkuri 314706300
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * This is a constructor function.
     *
     * @param game          - set the game.
     * @param removedBlocks - set the remove block.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * @param beingHit -the block that being hit.
     * @param hitter   - the ball that hit the block.
     *                 hitEvent function- Blocks that are hit should be removed
     *                 from the game.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(game);
        beingHit.getHitListeners().remove(this);
        this.remainingBlocks.decrease(1);
    }
}