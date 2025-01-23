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
public class LevelTwo implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        ArrayList<Velocity> velocityArrayList = new ArrayList<>();
        for (int i = -5; i <= 5; i++) {
            if (i != 0) {
                velocityArrayList.add(Velocity.fromAngleAndSpeed(10 * i, 5));
            }
        }
        return velocityArrayList;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 600;
    }

    @Override
    public String levelName() {
        return new String("Wide Easy");
    }

    @Override
    public Sprite getBackground() {
        Sprite sprite = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(new Color(152, 247, 250));
                d.drawRectangle(0, 0, 800, 600);
                d.fillRectangle(0, 0, 800, 600);

                d.setColor(new Color(231, 207, 144));
                for (int i = 0; i < 90; i++) {
                    d.drawLine(150, 150, 5 + i * 7, 225);

                }


                d.setColor(new Color(231, 207, 144));
                d.drawCircle(140, 130, 58);
                d.fillCircle(140, 130, 58);
                d.setColor(new Color(229, 193, 72));
                d.drawCircle(140, 130, 46);
                d.fillCircle(140, 130, 46);
                d.setColor(new Color(253, 216, 99));
                d.drawCircle(140, 130, 35);
                d.fillCircle(140, 130, 35);


            }

            @Override
            public void timePassed() {
            }
        };
        return sprite;
    }


    @Override
    public List<Block> blocks() {
        Color[] colrarr = new Color[]{new Color(236, 47, 78), new Color(236, 119, 47), new Color(236, 205, 47),
                new Color(123, 236, 47), new Color(47, 236, 142), new Color(47, 230, 236), new Color(101, 47, 236)};
        int j = 0;
        int x = 26;
        int y = 225;
        ArrayList<Block> blockArrayList = new ArrayList<>();
        for (int i = 1; i < 16; i++) {
            Point zero = new Point(x, y);
            Rectangle rec = new Rectangle(zero, 50, 30);
            if (i == 1 || i == 2) {
                Block block = new Block(rec, colrarr[j]);
                blockArrayList.add(block);
            }
            if (i == 3 || i == 4) {
                Block block = new Block(rec, colrarr[j + 1]);
                blockArrayList.add(block);
            }
            if (i == 5 || i == 6) {
                Block block = new Block(rec, colrarr[j + 2]);
                blockArrayList.add(block);
            }
            if (i == 7 || i == 8 || i == 9) {
                Block block = new Block(rec, colrarr[j + 3]);
                blockArrayList.add(block);
            }
            if (i == 10 || i == 11) {
                Block block = new Block(rec, colrarr[j + 4]);
                blockArrayList.add(block);
            }
            if (i == 12 || i == 13) {
                Block block = new Block(rec, colrarr[j + 5]);
                blockArrayList.add(block);
            }
            if (i == 14 || i == 15) {
                Block block = new Block(rec, colrarr[j + 6]);
                blockArrayList.add(block);
            }
            x = x + 50;
        }
        return blockArrayList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
}
