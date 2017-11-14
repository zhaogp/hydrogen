package gp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

public class DotComBust {
    private static final Logger logger = LogManager.getLogger();
    private GameHelper gh = new GameHelper();
    private ArrayList<SimpleDotCom> dotComList = new ArrayList<>();

    ArrayList<String> getRandomCells1(){
        ArrayList<String> cells = new ArrayList<>();
        cells.add("B2");
        cells.add("B3");
        cells.add("B4");
        return cells;
    }
    ArrayList<String> getRandomCells2(){
        ArrayList<String> cells = new ArrayList<>();
        cells.add("E4");
        cells.add("B5");
        cells.add("B6");
        return cells;
    }
    ArrayList<String> getRandomCells3(){
        ArrayList<String> cells = new ArrayList<>();
        cells.add("C0");
        cells.add("D0");
        cells.add("E0");
        return cells;
    }
    public void setUpGame(){
        //Get company name and locations
        SimpleDotCom sdc1 = new SimpleDotCom("jingdong", getRandomCells1());
        SimpleDotCom sdc2 = new SimpleDotCom("alibaba", getRandomCells2());
        SimpleDotCom sdc3 = new SimpleDotCom("amazon", getRandomCells3());

        dotComList.add(sdc1);
        dotComList.add(sdc2);
        dotComList.add(sdc3);
        }
}
