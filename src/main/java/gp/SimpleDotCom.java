package gp;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.Arrays;

public class SimpleDotCom {
    public static final Logger logger = LogManager.getLogger(SimpleDotCom.class);
    private int[] locationCells;
    private int numOfHits = 0;


    void setLocationCells(int[] cells){
        logger.info("Set locations for " + Arrays.toString(cells));
        locationCells = cells;

    }
    String checkGuess(String stringGuess){
        logger.info("Your guess is " + stringGuess);
        int guess = Integer.parseInt(stringGuess);
        String result = "miss";
        for(int cell: locationCells){
            if(cell == guess){
                result = "hit";
//                logger.info("hit");
                numOfHits ++;
                break;
            }
        }
        if (numOfHits == locationCells.length){
//            logger.info("kill");
            result = "kill";
        }
        logger.info(result);
        return result;
    }

}
