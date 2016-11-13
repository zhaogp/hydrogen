package jd;

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

        Employee harry = new Employee("Harry Hacker", 1000, 2016, 11, 13);
        harry.raiseSalary(20);
        System.out.println("name" + harry.getName() + ", salary=" + harry.getSalary());

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

}
