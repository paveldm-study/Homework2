package org.dpa.study.userbase1.mappers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.stream.Collectors;

public class GetParamsFromRequest {

    public static String getStringParam(HttpServletRequest request, String paramName) throws IOException {
        String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(requestBody);

        String paramValue = jsonNode.get(paramName).asText();

        return paramValue;
    }

    public static int getIdParam(HttpServletRequest request) throws IOException {
        String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(requestBody);

        String paramValue = jsonNode.get("id").asText();
        int intValue = 0;

        try {
            intValue = Integer.parseInt(paramValue);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return intValue;
    }
}
