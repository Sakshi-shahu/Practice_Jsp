package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.EmpService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/")
public class EmpEditController  extends HttpServlet {

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




        super.doGet(req, resp);
    }
}
