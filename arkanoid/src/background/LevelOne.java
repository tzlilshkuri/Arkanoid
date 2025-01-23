package background;

import biuoop.DrawSurface;
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
public class LevelOne implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        ArrayList<Velocity> velocityArrayList = new ArrayList<>();
        for (int i = 0; i < this.numberOfBalls(); i++) {
            velocityArrayList.add(new Velocity(0, 6));
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
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        Sprite sprite = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(new Color(39, 4, 72));
                d.fillRectangle(0, 0, 800, 600);
                d.setColor(new Color(225, 80, 223));
                d.drawCircle(400, 142, 50);
                d.drawCircle(400, 142, 75);
                d.drawCircle(400, 142, 100);
                d.drawLine(270, 142, 380, 142);
                d.drawLine(420, 142, 530, 142);
                d.drawLine(400, 42, 400, 122);
                d.drawLine(400, 162, 400, 272);
            }

            @Override
            public void timePassed() {
            }
        };
        return sprite;
    }

    @Override
    public List<Block> blocks() {
        ArrayList<Block> blockArrayList = new ArrayList<>();
        Point zero = new Point(380, 125);
        Rectangle rec = new Rectangle(zero, 40, 40);
        Block block = new Block(rec, new Color(89, 118, 161));

        blockArrayList.add(block);
        return blockArrayList;
    }


    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
