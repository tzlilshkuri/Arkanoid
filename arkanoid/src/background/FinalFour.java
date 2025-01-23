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
public class FinalFour implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        ArrayList<Velocity> velocityArrayList = new ArrayList<>();
        for (int i = -1; i <= 2; i++) {
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
        return new String("Final Four");
    }

    @Override
    public Sprite getBackground() {
        Point zero = new Point(0, 0);
        Rectangle rec = new Rectangle(zero, 800, 600);
        Block block = new Block(rec,  new Color(239, 174, 206));
        return block;
    }

    @Override
    public List<Block> blocks() {
        ArrayList<Block> blockArrayList = new ArrayList<>();
        Color[] colrarr = new Color[]{new Color(64, 1, 80), new Color(101, 8, 124), new Color(141, 46, 166),
                new Color(174, 78, 199), new Color(205, 125, 225), new Color(230, 174, 245), new Color(249, 224, 255)};
        int x = 25;
        int y = 115;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 15; j++) {
                Point zero = new Point(x, y);
                Rectangle rec = new Rectangle(zero, 50, 25);
                Block block = new Block(rec, colrarr[i]);
                blockArrayList.add(block);
                x = x + 50;
            }
            y = y + 25;
            x = 25;
        }
        return blockArrayList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 105;
    }
}
