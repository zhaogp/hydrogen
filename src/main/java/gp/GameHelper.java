package gp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class GameHelper {
    private static final Logger logger = LogManager.getLogger();
    String getUserInput(){
        String rv = null;
        System.out.print("Please input an integer: ");
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
    void setComName(SimpleDotCom sdc){
        String rv = null;
        System.out.println("Input a company name:");
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            sdc.setCompanyName(br.readLine());
        }catch (IOException e){
            logger.error(e.getMessage());
        }
    }
}
