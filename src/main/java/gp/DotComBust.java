package gp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

public class DotComBust {
    private static final Logger logger = LogManager.getLogger();
    private GameHelper gh = new GameHelper();
    private ArrayList<SimpleDotCom> dotComList = new ArrayList<>();
    private int guessNumber;

    public static void main(String [] args){
        DotComBust dotComBust = new DotComBust();
        dotComBust.setUpGame();
        dotComBust.startPlaying();
    }
    private void setUpGame(){
        //Get company name and locations
        for (int i=0; i<3; i++){
            SimpleDotCom sdc = new SimpleDotCom();
            logger.info("Input a  company: ");
            sdc.setCompanyName(gh.getUserInput());
            sdc.setLocationCells(gh.placeDotCom(3));
            sdc.printCompanyName();
            sdc.printLocationCells();
            dotComList.add(sdc);
        }
    }
    void startPlaying(){
        logger.info("Start playing ...");
        String guess;
        String guessResult;
        while (dotComList.size() > 0){
            guess = gh.getUserInput();
            guessNumber++;
            for (SimpleDotCom com:dotComList){
                guessResult = com.checkGuess(guess);
                if (guessResult.equals("hit")){
                    break;
                }
                if (guessResult.equals("kill")){
                    dotComList.remove(com);
                    break;
                }
            }
        }
        logger.info("Your guess number is " + guessNumber);
        logger.info("Game over!");
    }
}
