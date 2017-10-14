package gp;

import org.testng.annotations.Test;

public class SimpleDotComTest {
    @Test(testName = "test hit", description = "测试猜中单元格")
    public void testGuessHit(){
        SimpleDotCom sdc = new SimpleDotCom();

        int[] locations = {2, 3, 4};
        sdc.setLocationCells(locations);
        String guessResult;

        // test miss
        guessResult = sdc.checkGuess("0");
        assert guessResult.equals("miss");
        // test hit
        guessResult = sdc.checkGuess("2");
        assert guessResult.equals("hit");

        // test kill

    }
}
