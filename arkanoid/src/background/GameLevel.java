package background;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import geometry.Ball;
import geometry.Point;
import geometry.Rectangle;
import listener.BallRemover;
import listener.BlockRemover;
import listener.ScoreTrackingListener;
import sprite.SpriteCollection;
import sprite.Paddle;
import sprite.ScoreIndicator;
import sprite.Block;
import sprite.Collidable;
import sprite.Sprite;

import java.awt.Color;
import java.util.List;

/**
 * * @tzlil shkuri 314706300
 */
public class GameLevel implements Animation {
    static final int SCREEN_SIZE_MAX = 800;
    static final int SCREEN_SIZE_MIN = 0;
    static final int SCREEN_Y = 580;
    static final int FRAME_BLOCKS = 4;
    static final int KEYBOARD_LEFT_LIMIT = 25;
    static final int KEYBOARD_RIGHT_LIMIT = 775;
    static final int BLOCK_HEIGHT = 25;
    static final int MY_GUI_X_LIMIT = 800;
    static final int MY_GUI_Y_LIMIT = 600;
    static final double MY_BALL_DX = 4;
    static final double MY_BALL_DY = 3;
    static final double MY_BALL_X = 440;
    static final double MY_BALL_Y = 540;
    static final int MY_BALL_RADIOS = 6;
    static final double MY_PADDLE_X = 400;
    static final double MY_PADDLE_Y = 560;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter counterBlocks;
    private Counter counterBalls;
    private Counter score;
    private AnimationRunner runner;
    private Boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;

    /**
     * This is a constructor function that initialize the sprite, the game and the gui.
     *
     * @param levelInformation - the information of every level.
     * @param runner           - the animation we run.
     * @param keyboard         - our keyboard.
     * @param score            - the score of the player.
     */
    public GameLevel(LevelInformation levelInformation, AnimationRunner runner,
                     KeyboardSensor keyboard, Counter score) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.counterBlocks = new Counter(levelInformation.numberOfBlocksToRemove());
        this.counterBalls = new Counter(levelInformation.numberOfBalls());
        this.score = new Counter(0);
        this.runner = runner;
        this.running = true;
        this.keyboard = keyboard;
        this.levelInformation = levelInformation;
        this.score = score;
    }

    /**
     * CounterBlocks  function- return the blocks the still left in any level.
     *
     * @return counterBlocks -the remain blcks number.
     */
    public Counter getCounterBlocks() {
        return this.counterBlocks;
    }


    /**
     * getCounterBalls function- return the balls the still left in any level.
     *
     * @return counterBalls -the remain balls number.
     */
    public Counter getCounterBalls() {
        return this.counterBalls;
    }

    /**
     * addCollidable function- The function add all the collidables to the game environment.
     * stays in the area we set it up for.
     *
     * @param c - the colldable.
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * addSprite function- The function add all the sprites to the game environment.
     * stays in the area we set it up for.
     *
     * @param s - the sprite.
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * @param c the Collidable we want to remove.
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    /**
     * @param s the Sprite we want to remove.
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }


    /**
     * initialize function- The function create the Blocks,Ball and create the game.
     */
    public void initialize() {
        Point zero = new Point(0, 0);
        Rectangle rec = new Rectangle(zero, MY_GUI_X_LIMIT, MY_GUI_Y_LIMIT);
        levelInformation.getBackground();
        BlockRemover blockRemover = new BlockRemover(this, this.counterBlocks);
        sprites.addSprite(levelInformation.getBackground());

        //making the balls.
        Ball[] myBalls = new Ball[levelInformation.numberOfBalls()];
        for (int i = 0; i < myBalls.length; i++) {
            myBalls[i] = new Ball(400, MY_BALL_Y, MY_BALL_RADIOS,
                    Color.WHITE, environment);
            myBalls[i].setVelocity(levelInformation.initialBallVelocities().get(i));
            myBalls[i].setMinMax(SCREEN_SIZE_MIN, SCREEN_SIZE_MAX);
            sprites.addSprite(myBalls[i]);
        }

        //frame blocks.
        Block[] frameBlocks = new Block[FRAME_BLOCKS];
        frameBlocks[3] = new Block(new Rectangle(new Point(SCREEN_SIZE_MAX - BLOCK_HEIGHT, 0),
                BLOCK_HEIGHT, SCREEN_SIZE_MAX), Color.GRAY);
        frameBlocks[2] = new Block(new Rectangle(new Point(0, 20), SCREEN_SIZE_MAX, BLOCK_HEIGHT), Color.GRAY);
        frameBlocks[1] = new Block(new Rectangle(new Point(0, 0), BLOCK_HEIGHT, SCREEN_SIZE_MAX), Color.GRAY);

        //the death block.
        frameBlocks[0] = new Block(new Rectangle(new Point(0, SCREEN_Y + 20 - 1),
                SCREEN_SIZE_MAX, BLOCK_HEIGHT), Color.GRAY);
        for (int i = 0; i < FRAME_BLOCKS; i++) {
            environment.addCollidable(frameBlocks[i]);
            sprites.addSprite(frameBlocks[i]);
        }

        //part 2- lose the game.
        BallRemover ballRemover = new BallRemover(this, this.counterBalls);
        frameBlocks[0].addHitListener(ballRemover);

        //part 3- score.
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.score);
        sprites.addSprite(scoreIndicator);
        ScoreTrackingListener trackingScore = new ScoreTrackingListener(score);

        //making the paddle.
        Point mypoint = new Point(400 - (levelInformation.paddleWidth() / 2), MY_PADDLE_Y);
        Rectangle myrec = new Rectangle(mypoint, levelInformation.paddleWidth(), 18);
        Block myblock = new Block(myrec, Color.ORANGE);
        Paddle myPaddle = new Paddle(this.runner.getKeyBoardSensor(), KEYBOARD_LEFT_LIMIT,
                KEYBOARD_RIGHT_LIMIT, myblock, this.levelInformation.paddleSpeed());
        sprites.addSprite(myPaddle);
        environment.addCollidable(myPaddle);
        //make sure the ball know that the paddle are collidable.
        for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
            myBalls[i].setPaddle(myPaddle);
        }


        //make all the blocks.
        List<Block> b = this.levelInformation.blocks();
        for (int i = 0; i < b.size(); i++) {
            b.get(i).addHitListener(blockRemover);
            environment.addCollidable(b.get(i));
            b.get(i).addHitListener(trackingScore);
            sprites.addSprite(b.get(i));
        }
    }


    /**
     * run function- The function runs and draw the game.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        this.running = true;
        this.runner.run(this);

    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        d.drawText(540, 18, "Level Name: " + levelInformation.levelName(), 20);
        if (this.counterBlocks.getValue() == 0) {
            this.score.increase(100);
            this.running = false;
        }

        if (this.counterBalls.getValue() == 0) {
            this.running = false;
            KeyPressStoppableAnimation key = new KeyPressStoppableAnimation(runner.getKeyBoardSensor(),
                    KeyboardSensor.SPACE_KEY,
                    new YouLose(runner.getKeyBoardSensor(), this.score));
            this.runner.run(key);
        }

        if (this.runner.getKeyBoardSensor().isPressed("p") || this.runner.getKeyBoardSensor().isPressed("פ")) {
            KeyPressStoppableAnimation key = new KeyPressStoppableAnimation(runner.getKeyBoardSensor(),
                    KeyboardSensor.SPACE_KEY, new PauseScreen(runner.getKeyBoardSensor()));
            this.runner.run(key);
        }
        this.sprites.notifyAllTimePassed();
    }


    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}