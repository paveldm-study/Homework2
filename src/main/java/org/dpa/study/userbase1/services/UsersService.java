package org.dpa.study.userbase1.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.dpa.study.userbase1.dtos.UserDto;
import org.dpa.study.userbase1.mappers.GetParamsFromRequest;
import org.dpa.study.userbase1.mappers.UserMapper;
import org.dpa.study.userbase1.repositories.UsersRepository;
import org.json.JSONArray;

import java.io.IOException;
import java.sql.SQLException;


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

    public static String deleteUserById(HttpServletRequest request) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        UserDto userDto = mapper.readValue(request.getInputStream(), UserDto.class);
        String result = UsersRepository.deleteUserById(userDto);

        return result;
    }
}