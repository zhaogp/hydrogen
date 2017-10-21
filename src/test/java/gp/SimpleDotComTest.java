package gp;

import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;

public class SimpleDotComTest {
    @Test(testName = "test hit", description = "测试猜中单元格")
    public void testGuessHit(){
        SimpleDotCom sdc = new SimpleDotCom();

        ArrayList<Integer> a = new ArrayList<>();
        for(int i=0;i<3;i++){
            a.add(i+2);
        }
        sdc.setLocationCells(a);

        String guessResult;
        // test miss
        guessResult = sdc.checkGuess("0");
        assert guessResult.equals("miss");
        // test hit
        guessResult = sdc.checkGuess("2");
        assert guessResult.equals("hit");
        guessResult = sdc.checkGuess("2");
        assert guessResult.equals("miss");
        guessResult = sdc.checkGuess("3");
        assert guessResult.equals("hit");
        // test kill
        guessResult = sdc.checkGuess("4");
        assert guessResult.equals("kill");

    }
}
