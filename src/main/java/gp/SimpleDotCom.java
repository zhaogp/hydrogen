package gp;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;

public class SimpleDotCom {
    private static final Logger logger = LogManager.getLogger(SimpleDotCom.class);
    private ArrayList<Integer> locationCells;

    void setLocationCells(ArrayList<Integer> cells){
        logger.info("Set locations for " + cells.toString());
        locationCells = cells;
    }
    String checkGuess(String stringGuess){
        logger.info("Your guess is " + stringGuess);
        Integer guess = Integer.parseInt(stringGuess);
        String result = "miss";
        if(locationCells.indexOf(guess) != -1){
            result = "hit";
            locationCells.remove(guess);
            if (locationCells.isEmpty()){
                result = "kill";
            }
        }
        logger.info(result);
        return result;
    }

}
