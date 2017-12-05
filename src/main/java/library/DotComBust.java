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
        System.out.print("How many company will you sink？");
        int companyCount = Integer.parseInt(gh.getUserInput());
        for (int i=0; i<companyCount; i++){
            System.out.print("Input a name of company: ");
            dotComList.add(new SimpleDotCom(gh.getUserInput(), gh.placeDotCom(3)));
        }
    }
    private void startPlaying(){
        System.out.println("Start playing ...");
        String guess;
        String guessResult = "miss";
        String companyName;
        while (dotComList.size() > 0){
            System.out.print("Please input your guess: ");
            guess = gh.getUserInput();
            guessNumber++;
            for (SimpleDotCom com:dotComList){
                companyName = com.getCompanyName();
                logger.debug(companyName);
                guessResult = com.checkGuess(guess);
                if (guessResult.equals("hit")){
                    System.out.println("Hit " + companyName);
                    break;
                }
                if (guessResult.equals("kill")){
                    dotComList.remove(com);
                    System.out.println("kill " + companyName + ", There still has " + dotComList.size() + " company");
                    break;
                }
            }
            if (guessResult.equals("miss")){
                System.out.print("This guess miss, try again. ");
            }
        }
        System.out.println("Your guess number is " + guessNumber);
        System.out.println("Game over!");
    }
}
