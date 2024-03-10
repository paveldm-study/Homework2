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



//    пока не получилось вынуть id и name одновременно
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {

        UsersService.updateUser(request);








//        for(String elem : parts) {
//            String[] temp = elem.split(":");
//            hashMap.put(temp[1], temp[2]);
//        }
//
//        hashMap.forEach((key, value) -> {
//            System.out.println(key + " : " + value);
//        });





//        BufferedReader reader = request.getReader();
//        StringBuilder sb = new StringBuilder();
//        String line;
//
//        while ((line = reader.readLine()) != null) {
//            sb.append(line);
//        }
//
//        String requestBody = sb.toString();
////        Parse the request body String to extract the parameters:
//
//        Map<String, String> params = new HashMap<>();
//        String[] parts = requestBody.split("&");
//
//        for (String part : parts) {
//            String[] keyVal = part.split("=");
//            if (keyVal.length == 2) {
//                String key = URLDecoder.decode(keyVal[0], "UTF-8");
//                String value = URLDecoder.decode(keyVal[1], "UTF-8");
//                params.put(key, value);
//            }
//        }
//
//        String paramValue0 = params.get("id");
//        String paramValue1 = params.get("name");
//
//        System.out.println("^ " + paramValue0 + " " + paramValue1);





//        StringBuilder sb = new StringBuilder();
//        BufferedReader reader = request.getReader();
//        String line;
//        while ((line = reader.readLine()) != null) {
//            sb.append(line);
//        }
//
//        String requestBody = sb.toString();
//        System.out.println("Тело запроса PUT: " + requestBody);
//        После этого вы можете разобрать строку requestBody и извлечь значения параметров "id" и "name".
//
//                Например, с использованием библиотеки JSON Simple:



//
//// Разбор тела запроса в JSON объект
//        JSONParser parser = new JSONParser();
//        try {
//            JSONObject jsonObject = (JSONObject) parser.parse(requestBody);
//
//            // Получение параметров по ключам
//            long id = (long) jsonObject.get("id");
//            String name = (String) jsonObject.get("name");
//
//            System.out.println("id: " + id);
//            System.out.println("name: " + name);
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


//        System.out.println(request.getContentType());
//        System.out.println(request.getQueryString());
//
//        Map<String, String[]> parameterMap = Collections.list(request.getParameterNames()).stream().
//            collect(Collectors.toMap(parameterName -> parameterName, request::getParameterValues));
//
//        if (parameterMap.isEmpty()) {
//            System.out.println("dtretr");
//        }
//
//        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
//            System.out.print(entry.getKey() + ": ");
//            for (String value : entry.getValue()) {
//                System.out.print(value + ", ");
//            }
//            System.out.println();
//        }



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

