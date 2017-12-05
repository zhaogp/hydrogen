package library;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;

public class SimpleDotCom {
    private static final Logger logger = LogManager.getLogger(SimpleDotCom.class);
    private ArrayList<String> locationCells;
    private String companyName;

    public SimpleDotCom(){
        this("JD.com");
    }
    public SimpleDotCom(String name){
        companyName = name;
    }
    public SimpleDotCom(String name, ArrayList<String> location){
        companyName = name;
        locationCells = location;
        System.out.println(companyName + ": " + locationCells.toString());
    }

//    void setCompanyName(String s){
//        companyName = s;
//    }
//    void setLocationCells(ArrayList<String> cells){
//        locationCells = cells;
//    }
    String getCompanyName(){
//        logger.info(companyName);
        return companyName;
    }
    String checkGuess(String stringGuess){
        logger.debug("Your guess is " + stringGuess);
        int index = locationCells.indexOf(stringGuess);
        String result = "miss";
        if(index != -1){
            result = "hit";
            locationCells.remove(index);
            if (locationCells.isEmpty()){
                result = "kill";
                logger.debug("You sunk " + companyName);
            }
        }
        logger.debug(result);
        return result;
    }
}
