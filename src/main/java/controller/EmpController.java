package controller;


import dto.EmployeeRequest;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Manager;
import service.EmpService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/addemp")
public class EmpController  extends HttpServlet {

    EmpService empService;

    {
        try {
            empService = new EmpService();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
           List<Manager> mlist= empService.getAllManager();
            req.setAttribute("manager", mlist);
            PrintWriter out=resp.getWriter();
            out.println(mlist);



            RequestDispatcher rd= req.getRequestDispatcher("fetchpart.jsp");
            rd.forward(req, resp);
//         List<Employee> employees=empService.getAllEmployee();
//         req.setAttribute("emplist",employees);
//
//            req.getRequestDispatcher("List-emp.jsp").forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
try{
 String name=   req.getParameter("uname");

  String salary=  req.getParameter("salary");
int sal=  Integer.parseInt(salary);
    String manager=req.getParameter("manager");
    int i = Integer.parseInt(manager);
    EmployeeRequest employee=new EmployeeRequest(name, sal,i);
    empService.addEmp(employee);
//    Cookie cookie= new Cookie("name", name);
//    cookie.setMaxAge(60*60);
//    resp.addCookie(cookie);

    PrintWriter out=resp.getWriter();
out.println("<script>" +
        "alert('successfully submiited');" +
     "window.location.href='addemp';"+
    "</script>");

   //resp.sendRedirect(req.getContextPath()+"/addemp");
} catch (Exception e) {
    throw new RuntimeException(e);
}


    }
}
