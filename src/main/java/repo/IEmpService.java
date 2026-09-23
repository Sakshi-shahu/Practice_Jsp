package repo;

import model.EmpDocument;
import model.Employee;
import model.Manager;

import java.sql.SQLException;
import java.util.List;

public interface IEmpService {


     void addEmployee(Employee employee) throws SQLException;

     List<Manager> getAllManager() throws SQLException;


    //void  addDocument(EmpDocument document);

    boolean employeeExists(String name) throws SQLException;

   boolean updateEmployee(int id, Employee employee) throws SQLException;

List<Employee> getAllEmployee() throws SQLException;

}
