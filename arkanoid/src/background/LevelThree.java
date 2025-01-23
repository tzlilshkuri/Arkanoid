package background;

import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import sprite.Block;
import sprite.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * * @tzlil shkuri 314706300
 */
public class LevelThree implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        ArrayList<Velocity> velocityArrayList = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            if (i != 0) {
                velocityArrayList.add(Velocity.fromAngleAndSpeed(10 * i, 5));
            }
        }
        return velocityArrayList;
    }

    @Override
    public int paddleSpeed() {
        return 6;
    }

    @Override
    public int paddleWidth() {
        return 90;
    }

    @Override
    public String levelName() {
        return new String("Green 3");
    }

    @Override
    public Sprite getBackground() {
        Point zero = new Point(0, 0);
        Rectangle rec = new Rectangle(zero, 800, 600);
        Block block = new Block(rec, new Color(198, 242, 246));
        return block;
    }

    @Override
    public List<Block> blocks() {
        ArrayList<Block> blockArrayList = new ArrayList<>();
        Color[] colrarr = new Color[]{new Color(90, 239, 74), new Color(124, 245, 112), new Color(217, 239, 117),
                new Color(239, 219, 118), new Color(236, 194, 110)};
        for (int i = 0; i < 5; i++) {
            for (int j = 10; j > i; j--) {
                Block block = new Block(new Rectangle(new Point(203 + j * 52, 120 + i * 24),
                        52, 24), colrarr[i]);
                blockArrayList.add(block);
            }
        }
        return blockArrayList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 40;
    }
}
