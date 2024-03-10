package org.dpa.study.userbase1.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.dpa.study.userbase1.dtos.UserDto;
import org.dpa.study.userbase1.mappers.GetParamsFromRequest;
import org.dpa.study.userbase1.mappers.UserMapper;
import org.dpa.study.userbase1.repositories.UsersRepository;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class UsersService {

    public static String addUser(HttpServletRequest request) throws IOException {

        UserDto userDto = UserMapper.requestToDto(request);
        UsersRepository.addUser(userDto);

        return "User is added: " + userDto.getId() + " " + userDto.getName();
    }

    public static JSONArray getUser(HttpServletRequest request) throws IOException, SQLException {

        int idValue = GetParamsFromRequest.getIdParam(request);
        JSONArray jsonArray = UsersRepository.getUser(idValue);

        return jsonArray;
    }

    public static void updateUser(HttpServletRequest request) throws IOException {

        InputStream inputStream = request.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder requestBody = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }
        String requestBodyString = requestBody.toString();

        String output = requestBodyString.replaceAll("[\"{}]", "");
        String[] parts = output.split(",");
        Map<String, String> hashMap = new HashMap<>();

        for(String elem : parts) {
            String[] temp = elem.split(":");
            hashMap.put(temp[0].trim(), temp[1].trim());
        }

        int idValue = Integer.parseInt(hashMap.get("id"));
        String nameValue = hashMap.get("name");

        UsersRepository.updateUserById(idValue, nameValue);
    }

    public static String deleteUserById(HttpServletRequest request) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        UserDto userDto = mapper.readValue(request.getInputStream(), UserDto.class);
        String result = UsersRepository.deleteUserById(userDto);

        return result;
    }
}