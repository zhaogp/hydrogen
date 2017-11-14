package gp;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;

public class SimpleDotCom {
    private static final Logger logger = LogManager.getLogger(SimpleDotCom.class);
    private ArrayList<String> locationCells;
    private String companyName;

    public SimpleDotCom(String name, ArrayList<String> cells){
        locationCells = cells;
        companyName = name;
    }
    public String getCompanyName(){
        return companyName;
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
