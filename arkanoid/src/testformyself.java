//import biuoop.DrawSurface;
//import biuoop.GUI;
//import biuoop.Sleeper;
//import java.awt.*;
//
//public class testformyself {
//
//    public static void main(String[] args)
//    {
//        GUI gui = new GUI("Test", 400, 400);
//        Sleeper sleeper = new Sleeper();
//        GameEnvironment game=new GameEnvironment();
//        Ball newBall = new Ball(22,38, 4, Color.BLACK, game);
//        newBall.setVelocity(6,6);
//        newBall.setMinMax(0,400);
//
//        Block [] arrblock= new Block[8];
//        Point zero= new Point(0,0);
//        Point a=new Point(0,380);
//        Point b=new Point(380,0);
//
//        Rectangle rec1=new Rectangle(zero,400,20);
//        Rectangle rec2=new Rectangle(zero,20,400);
//        Rectangle rec3=new Rectangle(a,400,20);
//        Rectangle rec4=new Rectangle(b,20,400);
//        Rectangle rec5=new Rectangle(new Point(40,80),150,20);
//        Rectangle rec6=new Rectangle(new Point(80,160),150,20);
//        Rectangle rec7=new Rectangle(new Point(120,220),150,20);
//        Rectangle rec8=new Rectangle(new Point(160,280),150,20);
//
//
//        Block b1= new Block(rec1, Color.GRAY);
//        arrblock[0]= b1;
//        Block b2=new Block(rec2,Color.GRAY);
//        arrblock[1]= b2;
//        Block b3=new Block(rec3,Color.GRAY);
//        arrblock[2]= b3;
//        Block b4=new Block(rec4,Color.GRAY);
//        arrblock[3]= b4;
//        Block b5= new Block(rec5, Color.ORANGE);
//        arrblock[4]= b5;
//        Block b6=new Block(rec6,Color.PINK);
//        arrblock[5]= b6;
//        Block b7=new Block(rec7,Color.CYAN);
//        arrblock[6]= b7;
//        Block b8=new Block(rec8,Color.MAGENTA);
//        arrblock[7]= b8;
//
//        for (int i = 0; i <8 ; i++)
//        {
//            game.addCollidable(arrblock[i]);
//        }
//
//        while (true)
//        {
//            DrawSurface d = gui.getDrawSurface();
//            for (int i = 0; i <8; i++) {
//                arrblock[i].drawOn(d);
//            }
//            newBall.moveOneStep();
//            newBall.drawOn(d);
//            gui.show(d);
//            sleeper.sleepFor(50);  // wait for 50 milliseconds.
//        }
//    }
//}