package org.dpa.study.userbase1.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.dpa.study.userbase1.dtos.UserDto;

import java.io.IOException;

public class UserMapper {

    public static UserDto mapUser(HttpServletRequest request) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        UserDto userDto = mapper.readValue(request.getInputStream(), UserDto.class);
        return userDto;
    }

}
