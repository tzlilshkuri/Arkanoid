
import background.LevelInformation;
import background.LevelOne;
import background.LevelTwo;
import background.LevelThree;
import background.FinalFour;
import background.AnimationRunner;
import background.GameFlow;
import background.Counter;

import java.util.ArrayList;
import java.util.List;

/**
 * * @tzlil shkuri 314706300
 */


public class Ass6Game {

    /**
     * @param numbers -arr of strings.
     * @return newarr -the function convert string arr to int arr.
     */
    public static int[] stringsToInts(String[] numbers) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].equals("1")) {
                int n = Integer.parseInt(numbers[i]);
                a.add(n);
            }
            if (numbers[i].equals("2")) {
                int n = Integer.parseInt(numbers[i]);
                a.add(n);
            }
            if (numbers[i].equals("3")) {
                int n = Integer.parseInt(numbers[i]);
                a.add(n);
            }
            if (numbers[i].equals("4")) {
                int n = Integer.parseInt(numbers[i]);
                a.add(n);
            }
        }
        int[] newarr1 = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            newarr1[i] = a.get(i);
        }
        return newarr1;
    }

    /**
     * @param args the main function. the main call the other functions that prints the game.
     */
    public static void main(String[] args) {
        int num = (stringsToInts(args).length);
        if (num == 0) {
            //make levels.
            LevelInformation level1 = new LevelOne();
            LevelInformation level2 = new LevelTwo();
            LevelInformation level3 = new LevelThree();
            LevelInformation level4 = new FinalFour();
            //add to the list.
            List<LevelInformation> levelInformations = new ArrayList<>();
            levelInformations.add(level1);
            levelInformations.add(level2);
            levelInformations.add(level3);
            levelInformations.add(level4);
            //new game flow
            AnimationRunner runner = new AnimationRunner();
            GameFlow gameFlow = new GameFlow(runner, runner.getKeyBoardSensor(), new Counter(0));
            //running the levels.
            gameFlow.runLevels(levelInformations);
            //close the game.
            gameFlow.getAr().getGui().close();
        } else {
            int[] newarr = stringsToInts(args);
            List<LevelInformation> levelInformations = new ArrayList<>();
            for (int i = 0; i < newarr.length; i++) {
                if (newarr[i] == 1) {
                    LevelInformation level = new LevelOne();
                    levelInformations.add(level);
                }
                if (newarr[i] == 2) {
                    LevelInformation level = new LevelTwo();
                    levelInformations.add(level);
                }
                if (newarr[i] == 3) {
                    LevelInformation level = new LevelThree();
                    levelInformations.add(level);
                }
                if (newarr[i] == 4) {
                    LevelInformation level = new FinalFour();
                    levelInformations.add(level);
                }
            }
            //new game flow
            AnimationRunner runner = new AnimationRunner();
            GameFlow gameFlow = new GameFlow(runner, runner.getKeyBoardSensor(), new Counter(0));
            //running the levels.
            gameFlow.runLevels(levelInformations);
            //close the game.
            gameFlow.getAr().getGui().close();
        }
    }
}
