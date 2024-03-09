package org.dpa.study.userbase1.mappers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.dpa.study.userbase1.dtos.UserDto;
import org.dpa.study.userbase1.services.UsersService;

import java.io.IOException;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDto requestToDto(HttpServletRequest request) throws IOException {

        String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(requestBody);

        int idValue = GetParamsFromRequest.getIdParam(request);
        String nameValue = GetParamsFromRequest.getStringParam(request, "name");

        UserDto userDto = new UserDto(idValue, nameValue);

        return userDto;
    }

}
