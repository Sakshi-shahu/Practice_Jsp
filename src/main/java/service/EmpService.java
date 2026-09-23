package service;

import dao.EmpDao;
import dto.EmployeeRequest;
import model.Employee;
import model.Manager;
import org.modelmapper.ModelMapper;
import repo.IEmpService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmpService {

    public IEmpService empService=new EmpDao();

    private  final ModelMapper mapper=new ModelMapper();

    public EmpService() throws SQLException {


    }

    public  void addEmp(EmployeeRequest employeeRequest) throws SQLException{

    Employee emp1=   mapper.map(employeeRequest, Employee.class);

        empService.addEmployee(emp1);
    }

    public List<Manager> getAllManager() throws  SQLException{
       List<Manager> managerList= empService.getAllManager();


        managerList.stream().filter(m->m.getmName().equalsIgnoreCase("bob johnson")).forEach(m-> System.out.println(m.getmName()));




       return  managerList;
    }


    //public boolean  updateEmployee()



    public List<Employee> getAllEmployee() throws  SQLException{
List<Employee> list = new ArrayList<>();
         empService.getAllEmployee().stream().filter(m->m.getSalary()>5000)
                .forEach(m->list.add(m));
         return  list;
    //  List<Employee> employees=  empService.getAllEmployee();



     //List<Employee> highestPaid= employees.stream().filter(e->e.getSalary()>2000).collect(Collectors.toList());
      //  System.out.println(highestPaid);

//        Now Q2:
//
//        Find all employees whose name is "Kashish Yadav", ignoring case. Return them as a List<Employee>.

  //    List<Employee> empPalak=   employees.stream().filter(e->e.getEmpname().equalsIgnoreCase("palak")).toList(); // doubt

//           List<Employee> empPalak=   employees.stream().filter(e->e.getEmpname().equalsIgnoreCase("palak")).collect(Collectors.toList()); // doubt
//        System.out.println(empPalak);



//        Now Q3:
//
//        Check whether any employee already has a manager (manager != null). Return only true/false.

      //  employees.stream().anyMatch(x -> x.getManager() != null);


//
//        Q4 now:
//
//        Check whether NO employee has salary less than 15,000. Return true/false.

//
//        boolean re =employees.stream().noneMatch(x->x.getSalary()<15000);
//        System.out.println(re);

        //        Ab
//        Q5:
//
//        List<Employee> se sirf employee names nikaal kar List<String> banao.

// using map and not using filter



//        List<String> empStringlist=  employees.stream().map(x->x.getEmpname()).collect(Collectors.toList());
//        System.out.println(empStringlist);
// Q5 ka short version
//        List<String> empStringlist = employees.stream()
//                .map(Employee::getEmpname)
//                .toList();




//        Q6 🔥
//
//        Create a new List<Employee> where employees are sorted by salary from lowest to highest.


//       List<Employee> slary= employees.stream().sorted(Comparator.comparing(x->x.getSalary())).collect(Collectors.toList());
//        System.out.println("from salary"+slary);




//        List<Employee> slaryreversed= employees.stream().sorted(Comparator.comparing(x->x.getSalary()).reversed()).collect(Collectors.toList());
//        System.out.println("from salary"+slary);
   //     return  employees;






    }

}
