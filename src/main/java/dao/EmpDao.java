package dao;

import model.Employee;
import model.Manager;
import repo.IEmpService;
import util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao implements IEmpService {

    DbConnection dbConnection=new DbConnection();
    Connection connection= dbConnection.getConnection();

    public EmpDao() throws SQLException {
    }


    @Override
    public void addEmployee(Employee employee) throws SQLException {
 boolean existsemp=employeeExists(employee.getEmpname());
 if(existsemp){
     System.out.println("employee is already having a manager");
     return ;
 }
        String sql="insert into employee(empname, salary, manager) values(?,?,?)";

    Connection con= dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

ps.setString(1, employee.getEmpname());
ps.setDouble(2, employee.getSalary());
ps.setInt(3, employee.getManager());
      int rows=  ps.executeUpdate();
if(rows>0){
    System.out.println("Employee inserted successfully");
}
    }

    @Override
    public List<Manager> getAllManager() throws SQLException {
        List<Manager> managerList = new ArrayList<>();
      String sql="select * from Manager";
     PreparedStatement ps = connection.prepareStatement(sql);
   ResultSet rs= ps.executeQuery();
   while(rs.next()){
       Manager manager=new Manager();
       manager.setMid(rs.getInt("mid"));
       manager.setmName(rs.getString("mName"));
       managerList.add(manager);
   }
   return managerList;
    }

    @Override
    public boolean employeeExists(String name) throws SQLException {
     String  sql="select exists (select 1 from employee where empname=? and manager is not null)";
   Connection con=  dbConnection.getConnection();

  PreparedStatement ps= con.prepareStatement(sql);
  ps.setString(1,name);

ResultSet rs=ps.executeQuery();
   if(rs.next()){
       return  rs.getBoolean(1);
   }
       return false;

    }

    @Override
    public boolean updateEmployee(int id, Employee employee) throws SQLException {
        String  sql="update employee set salary=? and manager=? where empid=?";
       Connection con= dbConnection.getConnection();
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1, id);
        pt.setInt( 2,employee.getManager());
        pt.setDouble(1, employee.getSalary());
      int row=  pt.executeUpdate();
      if(row>0){
          System.out.println("emploioyee updated successfully");
          return true;
      }
return  false;
    }

    @Override
    public List<Employee> getAllEmployee() throws SQLException {
  String sql="select * from employee";
  List<Employee> employeeList=new ArrayList<>();
 Connection con= dbConnection.getConnection();
 PreparedStatement ps=con.prepareStatement(sql);
 ResultSet rs=ps.executeQuery();
 while (rs.next()){
     Employee employee=new Employee();
     employee.setEmpid(rs.getInt("empid"));
     employee.setEmpname(rs.getString("empname"));
     employee.setSalary(rs.getDouble("salary"));
     employee.setManager(rs.getInt("manager"));
     employeeList.add(employee);
 }
 return  employeeList;

    }
}
