package gp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class GameHelper {
    private static final Logger logger = LogManager.getLogger();

    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int [] grid = new int[gridSize];
    private int comCount = 0;

    String getUserInput(){
        String rv = null;
//        logger.info("Please input an company: ");
        try{
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            rv = is.readLine();
            if (rv.length() == 0){
                return null;
            }
        }catch (IOException e){
            logger.error(e.getMessage());
        }
        assert rv != null;
        return rv.toLowerCase();
    }
    ArrayList<String> placeDotCom(int comSize) {
        ArrayList<String> alphaCells = new ArrayList<>();
//        String [] alphacoords = new String [comSize]; // holds ‘f6’ type coords
        String temp; // temporary String for concat
        int [] coords = new int[comSize]; // current candidate coords
        int attempts = 0; // current attempts counter
        boolean success = false; // flag = found a good location ?
        int location; // current starting location

        comCount++; // nth dot com to place
        int incr = 1; // set horizontal increment
        if ((comCount % 2) == 1) { // if odd dot com (place vertically)
            incr = gridLength; // set vertical increment
        }
        while ( !success & attempts++ < 200 ) { // main search loop (32)
            location = (int) (Math.random() * gridSize); // get random starting point
            logger.info(" Starting point: " + location);
            int x = 0; // nth position in dotcom to place
            success = true; // assume success
            while (success && x < comSize) { // look for adjacent unused spots
                if (grid[location] == 0) { // if not already used
                    coords[x++] = location; // save location
                    location += incr; // try ‘next’ adjacent
                    if (location >= gridSize){ // out of bounds - ‘bottom’
                        success = false; // failure
                    }
                    if (x>0 && (location % gridLength == 0)) { // out of bounds - right edge
                        success = false; // failure
                    }
                } else { // found already used location
                    logger.info("used " + location);
                    success = false; // failure
                }
            }
        } // end while

        int x = 0; // turn location into alpha coords
        int row;
        int column;
        while (x < comSize) {
            grid[coords[x]] = 1; // mark master grid pts. as ‘used’
            row = coords[x] / gridLength; // get row value
            column = coords[x] % gridLength; // get numeric column value
            temp = String.valueOf(alphabet.charAt(column)); // convert to alpha

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
             logger.info("coord"+x+" = "+ alphaCells.get(x-1));
        }

        return alphaCells;
    }
}
