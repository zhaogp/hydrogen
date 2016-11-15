package jd;

import java.util.Properties;
import java.util.Scanner;

import jd.Employee;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        String name;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a class: ");
        name = in.next();
        System.out.println("Class name is: "+name);
     }

}
