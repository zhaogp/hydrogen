package jd;

import org.testng.annotations.Test;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.io.*;
import javax.swing.*;
import javax.swing.JOptionPane;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testRaiseSalary(){
        Employee harry = new Employee("Harry Hacker", 1000, 2016, 11, 13);
        harry.raiseSalary(20);
        System.out.println("name" + harry.getName() + ", salary=" + harry.getSalary());
    }

    @Test
    public void testManager(){
        Employee[] staff = new Employee[3];
        Manager boss = new Manager("cui yan", 2000, 2013, 3, 4);
        boss.setBonus(500);
        //fill the staff with Manager and  Employee objects
        staff[0] = boss;
        staff[1] = new Employee("zhao guoping", 18000, 2016, 8, 8);
        staff[2] = new Employee("cui junling", 12000, 2011, 8, 1);
        //print out information about all Employee objects
        for (Employee e : staff){
            System.out.println("name = "+e.getName()+", salary = "+e.getSalary());
        }

        Arrays.sort(staff);
        for (Employee e: staff){
            System.out.println(e.getName()+" salary "+e.getSalary());
        }

    }

	@Test
	public void testProperties(){
		Properties p = new Properties();
		try {
			p.load(new FileInputStream("src/test/resources/test.properties"));
			Enumeration enu = p.propertyNames();

			while(enu.hasMoreElements()) {
				String k = (String) enu.nextElement();
				String v = p.getProperty(k);
				System.out.println("key: "+k+"; v: "+v);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}

    @Test
    public void testTimer(){
        ActionListener al = new TimePrinter();
        Timer t = new Timer(3000, al);
        t.start();

        JOptionPane.showMessageDialog(null, "quit?");
        System.exit(0);
    }

    @Test
    public void testClone(){
        try{
            Employee cui = new Employee("junling", 100.1, 2014, 3, 5);
            Employee copy = cui.clone();
            copy.raiseSalary(30);
            System.out.println("cui's salary is :" + cui.getSalary());
            System.out.println("copy's salary is :" + copy.getSalary());

        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testLambda(){
        String[] children = {"xiaoyu", "xinyao", "zhenjiang", "zhenhua", "nana"};
        System.out.println("Before sort is: "+Arrays.toString(children));
        System.out.println("sorted by length:");
        Arrays.sort(children, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(children));
    }

    @Test
    public void testInnerClass(){
        TalkingClock clock = new TalkingClock(2000, true);
        clock.start();

        JOptionPane.showMessageDialog(null, "inner quit ?");
        System.exit(0);
    }

}

