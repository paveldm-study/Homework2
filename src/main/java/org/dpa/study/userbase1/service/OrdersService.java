package org.dpa.study.userbase1.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.dpa.study.userbase1.dtos.UserDto;
import org.dpa.study.userbase1.repository.UsersRepository;

import java.io.IOException;

public class OrdersService {
    public static void addOrder(HttpServletRequest request) throws IOException {
        System.out.println("exec adduser");
//        userDto = new ObjectMapper().readValue((JsonParser) request, UserDto.class);
        ObjectMapper mapper = new ObjectMapper();
        UserDto userDto = mapper.readValue(request.getInputStream(), UserDto.class);

        System.out.println(userDto.getName());

        UsersRepository.addUser(userDto);



    }
}
