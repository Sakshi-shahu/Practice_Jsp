package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;
import service.EmpService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/emplist")
public class EmployeeListController  extends HttpServlet {

EmpService empService;

    @Override
    public void init() throws ServletException {
        try {
            empService=new EmpService();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            List<Employee> employees=empService.getAllEmployee();
         req.setAttribute("emplist",employees);

            req.getRequestDispatcher("List-emp.jsp").forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        super.doGet(req, resp);
    }
}
