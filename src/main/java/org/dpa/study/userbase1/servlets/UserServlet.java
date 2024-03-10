package org.dpa.study.userbase1.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.dpa.study.userbase1.repositories.UsersRepository;
import org.dpa.study.userbase1.services.UsersService;
import org.dpa.study.userbase1.utils.OwnException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getContentType().equals("application/json")) {

            String result = UsersService.addUser(request);

            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");

            PrintWriter out = response.getWriter();
            out.print(result);
            out.flush();
        } else {
            throw new OwnException("something went wrong");
        }
    }




    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UsersService.updateUser(request);
    }


//    @Override
//    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        try {
//            System.out.println("request " + request);
//            UsersService.patchUserById(request);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }


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






}

