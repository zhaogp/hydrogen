package library;

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
            logger.info("Input a  company: ");
            dotComList.add(new SimpleDotCom(gh.getUserInput(), gh.placeDotCom(3)));
        }
    }
    private void startPlaying(){
        logger.info("Start playing ...");
        String guess;
        String guessResult = "miss";
        String companyName;
        while (dotComList.size() > 0){
            logger.info("Please input your guess ");
            guess = gh.getUserInput();
            guessNumber++;
            for (SimpleDotCom com:dotComList){
                companyName = com.getCompanyName();
                logger.debug(companyName);
                guessResult = com.checkGuess(guess);
                if (guessResult.equals("hit")){
                    logger.info("Hit " + companyName);
                    break;
                }
                if (guessResult.equals("kill")){
                    dotComList.remove(com);
                    logger.info("kill " + companyName + ", There still has " + dotComList.size() + " company");
                    break;
                }
            }
            if (guessResult.equals("miss")){
                logger.info("This guess miss, try again");
            }
        }
        logger.info("Your guess number is " + guessNumber);
        logger.info("Game over!");
    }
}
