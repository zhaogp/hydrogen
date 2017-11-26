package gp;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;

public class SimpleDotCom {
    private static final Logger logger = LogManager.getLogger(SimpleDotCom.class);
    private ArrayList<String> locationCells;
    private String companyName;

    void setCompanyName(String s){
        companyName = s;
    }
    void setLocationCells(ArrayList<String> cells){
        locationCells = cells;
    }
    void printCompanyName(){
        logger.info("Name: " + companyName);
    }
    void printLocationCells(){
        logger.info("location: " + locationCells);
    }
    String checkGuess(String stringGuess){
        logger.info("Your guess is " + stringGuess);
        int index = locationCells.indexOf(stringGuess);
        String result = "miss";
        if(index != -1){
            result = "hit";
            locationCells.remove(index);
            if (locationCells.isEmpty()){
                result = "kill";
                logger.info("You sunk " + companyName);
            }
        }
        logger.info(result);
        return result;
    }
}
