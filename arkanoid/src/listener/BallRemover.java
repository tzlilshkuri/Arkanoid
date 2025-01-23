package listener;

/**
 * * @tzlil shkuri 314706300
 */
import background.Counter;
import background.GameLevel;
import geometry.Ball;
import sprite.Block;

/**
 * * @tzlil shkuri 314706300
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;


    /**
     * This is a constructor function.
     * In the function we set the game and the counter.
     * @param game - set the game.
     * @param remainingBalls - set the remain balls.
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(game);
        this.remainingBalls.decrease(1);
    }
}
