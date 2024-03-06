package org.dpa.study.userbase1.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dpa.study.userbase1.service.OrdersService;
import org.dpa.study.userbase1.service.UsersService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getContentType().equals("application/json")) {
            try {
                String result = UsersService.getUser(request);
                response.getWriter().write(result);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("something went wrong");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (request.getContentType().equals("application/json")) {
            String result = UsersService.deleteUserById(request);
            response.getWriter().write(result);
        } else {
            System.out.println("something went wrong");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getContentType().equals("application/json")) {
                UsersService.addUser(request);
        } else {
            System.out.println("something went wrong");
        }
    }
}
