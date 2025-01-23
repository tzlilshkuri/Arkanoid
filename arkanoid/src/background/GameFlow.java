package background;

import biuoop.KeyboardSensor;

import java.util.List;

/**
 * * @tzlil shkuri 314706300
 */
public class GameFlow {
    private AnimationRunner ar;
    private KeyboardSensor ks;
    private Counter score;

    /**
     * This is a constructor function.
     *
     * @param ar    out animation.
     * @param ks    our keyboard.
     * @param score keeping the score for all levels.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, Counter score) {
        this.ar = ar;
        this.ks = ks;
        this.score = score;
    }

    /**
     * getAr function- the function get the animation.
     *
     * @return ar -the animation.
     */
    public AnimationRunner getAr() {
        return ar;
    }

    /**
     * runLevels function- The function runs all the levels in the order we choose.
     * this function also check if we lost in the game or loose in one of the levels.
     *
     * @param levels the array that stores the levels order.
     */
    public void runLevels(List<LevelInformation> levels) {
        int myLevelsCounter = 0;
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, ar, this.ks, this.score);
            level.initialize();

            while (level.getCounterBalls().getValue() > 0 && level.getCounterBlocks().getValue() > 0) {
                myLevelsCounter++;
                level.run();
            }
            if (myLevelsCounter == levels.size()) {
                KeyPressStoppableAnimation key = new KeyPressStoppableAnimation(ks, KeyboardSensor.SPACE_KEY,
                        new YouWin(ks, this.score));
                ar.run(key);
            }

            if (level.getCounterBalls().getValue() == 0) {
                break;
            }
        }
    }
}