package background;

import geometry.Velocity;
import sprite.Block;
import sprite.Sprite;
import java.util.List;

/**
 * * @tzlil shkuri 314706300
 */
public interface LevelInformation {
    /**
     * numberOfBalls function- the function  return the number of the ball in the level.
     *
     * @return numberOfBalls - the number of the ball in the level.
     */
    int numberOfBalls();


    /**
     * initialBallVelocities function- the function initial velocity of each ball.
     *
     * @return initialBallVelocities - return a list that kepp the velocity of every ball.
     */
    List<Velocity> initialBallVelocities();

    /**
     * paddleSpeed function- the function return the paddle speed in every level.
     *
     * @return paddleWidth - the paddle speed.
     */
    int paddleSpeed();

    /**
     * paddleWidth function- the function return the paddle width in every level.
     *
     * @return paddleWidth - the paddle width.
     */
    int paddleWidth();


    /**
     * numberOfBalls function- the function return  the level name that will be displayed at the top of the screen.
     *
     * @return levelName - the string level name.
     */
    String levelName();


    /**
     * numberOfBalls function- the function return a sprite with the background of the level.
     *
     * @return levelName - the backgrpund.
     */
    Sprite getBackground();


    /**
     * blocks function- the function initial the Blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return blocks - return a list that keep the blocks.
     */
    List<Block> blocks();

    /**
     * numberOfBlocksToRemove function- the function return the number of the blocks in the level.
     *
     * @return numberOfBlocksToRemove - the number of the block in the level.
     */
    int numberOfBlocksToRemove();
}