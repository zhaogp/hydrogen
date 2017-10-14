package gp;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.*;

import static gp.ObjectAnalyzer.*;

/**
 * Created by zhaogp on 2016/11/15.
 */
public class ReflectionTest {

    @Test
    public void testClassName(){
        try{
            String name = "gp.Manager";
            Class cl = Class.forName(name);
            Class superCl = cl.getSuperclass();

            String modifiers = Modifier.toString(cl.getModifiers());
            System.out.println("modifiers: " + modifiers);

            System.out.print("class " + cl.getName());
            if (superCl != null && superCl != Object.class)
                System.out.print(" extends "+superCl.getName());

            }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testArrayList(){
        ArrayList<Integer> squares = new ArrayList<Integer>();
        for (int i=1; i<2; i++){
            squares.add(i+10);
            System.out.println(new ObjectAnalyzer().toStriing(squares));
        }
    }

    @Test
    public void testGoodCopy(){
        int[] a = {23, 1, 9};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));

        String[] b = {"sam", "bob"};
        b = (String[]) goodCopyOf(b, 5);
        System.out.println(Arrays.toString(b));

    }
    @Test(enabled = false)
    public void testBadCopy(){
        int[] i = {1, 3};
        String[] s = {"sam", "duncon"};
        s = (String[]) badCopyOf(s, 3);
        System.out.println(s);
    }

    @Test
    public void testMethod(){
        try{
            Method sqrt = Math.class.getMethod("sqrt", double.class);
            System.out.println(sqrt);

            for (double x =1 ; x<10; x++){
                double y = (Double) sqrt.invoke(null, x);
                System.out.println(x+" "+y);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
