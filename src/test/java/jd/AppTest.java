package jd;

import org.testng.annotations.Test;
import java.util.Properties;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.io.*;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void test01(){
        Employee harry = new Employee("Harry Hacker", 1000, 2016, 11, 13);
        harry.raiseSalary(20);
        System.out.println("name" + harry.getName() + ", salary=" + harry.getSalary());
    }

    @Test
    public void test02(){
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
    }

	@Test
	public void testProperties(){
		Properties p = new Properties();
		try {
			p.load(new FileInputStream("src/test/resources/test.properties"));
			Enumeration enu = p.propertyNames();

			while(enu.hasMoreElements()) {
				String k = (String) enu.nextElement();
				String v = (String) p.getProperty(k);
				System.out.println("key: "+k+"; v: "+v);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}

		System.out.println(new File(".").getAbsolutePath());
	}
}

