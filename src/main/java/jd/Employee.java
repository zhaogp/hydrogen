package jd;

import java.time.LocalDate;

public class Employee{
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

}