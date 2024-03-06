package org.dpa.study.userbase1.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.dpa.study.userbase1.database.DatabaseConnection;
import org.dpa.study.userbase1.dtos.UserDto;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class UsersRepository {

    public static String getUserById(UserDto user) {
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT  *  FROM shopdb.shopschema.users WHERE id = ?")) {
            preparedStatement.setInt(1, user.getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            Map<Integer, String> data = new HashMap<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                data.put(id, name);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            String jacksonData = objectMapper.writeValueAsString(data);

            return jacksonData;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void addUser(UserDto user) {
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO shopdb.shopschema.users (id, name) VALUES (?, ?)")) {

            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

      public static String deleteUserById(UserDto user) {
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM shopdb.shopschema.users WHERE (id = ?)")) {

            preparedStatement.setInt(1, user.getId());
            preparedStatement.executeUpdate();

            return "success";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
