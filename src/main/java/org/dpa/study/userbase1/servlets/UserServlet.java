package org.dpa.study.userbase1.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.dpa.study.userbase1.services.UsersService;
import org.dpa.study.userbase1.utils.OwnException;
import org.json.JSONArray;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getContentType().equals("application/json")) {

            JSONArray jsonArray = UsersService.getUser(request);

            if (jsonArray != null) {
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.print(jsonArray.toString());
                out.flush();
            } else {
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");

                PrintWriter out = response.getWriter();
                out.print("Result is null");
                out.flush();
            }
        } else {
            throw new OwnException("Request is not a json");
        }
    }


    @SneakyThrows
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getContentType().equals("application/json")) {
            String result = UsersService.deleteUserById(request);
            response.getWriter().write(result);
        } else {
            throw new OwnException("Something went wrong");
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getContentType().equals("application/json")) {
            System.out.println(request);
            System.out.println("dopost");

            String result = UsersService.addUser(request);

            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");

            PrintWriter out = response.getWriter();
            out.print(result);
            out.flush();
        } else {
            throw new OwnException("Something went wrong");
        }
    }
}

