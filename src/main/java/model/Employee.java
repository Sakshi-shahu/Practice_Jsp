package model;

public class Employee
{
    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", empname='" + empname + '\'' +
                ", salary=" + salary +
                ", manager=" + manager +
                '}';
    }

    public Employee(String empname, double salary, int manager) {

        this.empname = empname;
        this.salary = salary;
        this.manager = manager;
    }

    public Employee() {
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public  int empid;



    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    private String empname;
    private double salary;
    private  int manager;


}
