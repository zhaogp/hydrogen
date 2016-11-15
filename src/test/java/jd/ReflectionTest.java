package jd;

import org.testng.annotations.Test;
import java.util.Scanner;
import java.lang.reflect.*;

/**
 * Created by zhaogp on 2016/11/15.
 */
public class ReflectionTest {

    @Test
    public void testClassName(){
        try{
            String name = "jd.Manager";
            Class cl = Class.forName(name);
            Class superCl = cl.getSuperclass();
            System.out.print("class " + cl.getName());
            if (superCl != null && superCl != Object.class)
                System.out.print(" extends "+superCl.getName());
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
