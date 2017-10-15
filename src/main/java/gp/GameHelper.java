package gp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameHelper {
    public static final Logger logger = LogManager.getLogger();
    public String getUserInput(String prompt){
        String rv = null;
        System.out.print(prompt);
        try{
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            rv = is.readLine();
            if (rv.length() == 0){
                return null;
            }
        }catch (IOException e){
            logger.error(e.getMessage());
        }
        return rv;
    }
}
