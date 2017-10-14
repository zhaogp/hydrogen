package gp;

import java.time.LocalDate;
import java.util.Comparator;

public class Employee implements Comparable<Employee>,
        Comparator<String>, Cloneable {
    /**
     * The employee name, salary and hireDay
     */
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month, int day)
    {
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay.of(year, month, day);
    }

    public String getName(){
        return name;
    }

    public double getSalary(){
        return salary;
    }

    public LocalDate getHireDay(){
        return hireDay;
    }

    /**
     * Raises the salary of an employee.
     * @param byPercent
     * @return the amount of the raise
     */
    public double raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
        return raise;
    }

    public int compareTo(Employee other){
        return Double.compare(salary, other.salary);
    }


    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }

    public Employee clone() throws CloneNotSupportedException{
        Employee cloned = (Employee)super.clone();
        return cloned;
    }
}