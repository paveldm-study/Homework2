package org.dpa.study.userbase1.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.dpa.study.userbase1.dtos.UserDto;
import org.dpa.study.userbase1.repository.UsersRepository;

import java.io.IOException;
import java.sql.SQLException;


public class UsersService {

    public static void addUser(HttpServletRequest request) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        UserDto userDto = mapper.readValue(request.getInputStream(), UserDto.class);

        UsersRepository.addUser(userDto);
    }

    public static String getUser(HttpServletRequest request) throws IOException, SQLException {
        ObjectMapper mapper = new ObjectMapper();
        UserDto userDto = mapper.readValue(request.getInputStream(), UserDto.class);

        String result = UsersRepository.getUserById(userDto);

        return result;
    }

    public static String deleteUserById(HttpServletRequest request) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        UserDto userDto = mapper.readValue(request.getInputStream(), UserDto.class);

        String result = UsersRepository.deleteUserById(userDto);

        return result;
    }
}