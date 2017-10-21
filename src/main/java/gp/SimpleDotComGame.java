package gp;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;

public class SimpleDotComGame {
    public static final Logger logger = LogManager.getLogger();

    public static void main(String[] args){
        SimpleDotCom sdc = new SimpleDotCom();
        // Generate a random int number range(0,5)
        int random = (int) (Math.random() * 5);
        ArrayList<Integer> cells = new ArrayList<>();
        for (int i=0;i<3;i++){
            cells.add(random+i);
        }
        sdc.setLocationCells(cells);

        // Get user input
        GameHelper gh = new GameHelper();
        String guessResult = "miss";
        int guessTimes = 0;
        while (!guessResult.equals("kill")){
            guessTimes += 1;
            String in = gh.getUserInput("Please input an integer: ");
            guessResult = sdc.checkGuess(in);
        }
        logger.info("Use " + guessTimes + " for guessing");

    }
}
