package dto;

public class EmployeeRequest {
    public EmployeeRequest(String empname, double salary, int manager) {
        this.empname = empname;
        this.salary = salary;
        this.manager = manager;
    }

    private String empname;
    private double salary;
    private  int manager;

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

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
}
