package org.dpa.study.userbase1.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.dpa.study.userbase1.dtos.OrderDto;
import org.dpa.study.userbase1.dtos.UserDto;
import org.glassfish.jersey.model.internal.RankedComparator;

import java.io.IOException;

public class OrderMapper {

    public static OrderDto mapUser(HttpServletRequest request) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        OrderDto orderDto = mapper.readValue(request.getInputStream(), OrderDto.class);
        return orderDto;
    }
}
