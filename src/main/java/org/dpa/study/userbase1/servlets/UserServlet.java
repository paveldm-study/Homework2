package org.dpa.study.userbase1.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.dpa.study.userbase1.mappers.GetParamsFromRequest;
import org.dpa.study.userbase1.services.UsersService;
import org.dpa.study.userbase1.utils.OwnException;
import org.json.JSONArray;
import org.json.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

import java.io.*;
import java.sql.SQLException;
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
            System.out.println("something went wrong");
        }
    }



//    пока не получилось вынуть id и name одновременно
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        Collections.list(httpServletRequest.getParameterNames())
//                .stream()
//                .collect(Collectors.toMap(parameterName -> parameterName, httpServletRequest::getParameterValues));



//        <b>Message</b> getInputStream() has already been called for this request</ да шо ж такое
//        InputStream inputStream = request.getInputStream();
////        Прочитать данные из inputStream и преобразовать их в строку:
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//        StringBuilder requestBody = new StringBuilder();
//        String line;
//
//        while ((line = reader.readLine()) != null) {
//            requestBody.append(line);
//        }
//        String requestBodyString = requestBody.toString();
//
//        System.out.println(requestBodyString);
//
//        String jsonString = "{ \"id\": 4, \"name\": \"Samantha Smithttt\"}";
//
//        JSONParser parser = new JSONParser();
//        try {
//            JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
//
//            HashMap<String, Object> map = new HashMap<>();
//            map.put("id", jsonObject.get("id"));
//            map.put("name", jsonObject.get("name"));
//
//            System.out.println(map);
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//        String jsonString = requestBodyString;
//        JSONParser parser = new JSONParser();
//        JSONObject jsonObject = null;
//        try {
//            jsonObject = (JSONObject) parser.parse(jsonString);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
////        Создать HashMap и добавить значения из JSONObject с ключами "id" и "name":
//
//        HashMap<String, Object> hashMap = new HashMap<>();
//        hashMap.put("id", jsonObject.get("id"));
//        hashMap.put("name", jsonObject.get("name"));

//        Разобрать строку с параметрами на отдельные параметры и их значения:

//        String[] params = requestBodyString.split("&");
//        Map<String, String> paramMap = new HashMap<>();
//        for (String param : params) {
//            System.out.println("param " + param);
//            String[] parts = param.split("=");
//            String paramName = parts[0];
//            String paramValue = parts[1];
//            paramMap.put(paramName, paramValue);
//        }
//
//        hashMap.forEach((key, value) -> {
//            System.out.println(key + " : " + value);
//        });



//        HttpServletRequest originalRequest = request;
////                Создайте копию запроса, используя метод clone():
//
//        var copiedRequest = (HttpServletRequest) originalRequest.clone();

//        System.out.println("id " + GetParamsFromRequest.getIdParam(request));
//        System.out.println("nam, " + GetParamsFromRequest.getStringParam(request, "name"));
//        System.out.println("id " + GetParamsFromRequest.getIdParam(request));
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

